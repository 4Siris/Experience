package org.example.Controllers;

import org.example.ButtonMenu;
import org.example.game.Game;
import org.example.game.Processing;
import org.example.repository.Account;
import org.example.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Controller
public class MainController {
    private Game gm;
    private int upgradeX = 0;
    private int upgradeY = 0;

    @Autowired
    AccountRepo accountRepo;// Репозиторий для запроса к базе данных

    List<ButtonMenu> buttonMenu = new ArrayList<>();{
        buttonMenu.add(new ButtonMenu("Начать игру","/prestartMenu"));
        buttonMenu.add(new ButtonMenu("Обучение", "/tutorial"));
        buttonMenu.add(new ButtonMenu("Правила", "/rules"));
        buttonMenu.add(new ButtonMenu("Статистика", "/statistic"));
    }

    @GetMapping("/statistic")
    public String statistic1(@RequestParam(name="action",required = false)String action,
                             @RequestParam(name="login",required = false)String login,
                             @RequestParam(name="password",required = false)String password,
                             @RequestParam(name="save",required = false)String save,
                             Model model){
        //Добавление/перезапись данных игрока
        if(save!=null){
            Account winner = accountRepo.findByLogin(login);
            if(winner!=null){
                if(winner.getPassword().equals(password)){
                    accountRepo.deleteById(winner.getId());
                    winner.setScore(winner.getScore() + gm.getPlayers().length);
                    accountRepo.save(winner);
                }
            }else{
                accountRepo.save(new Account(login,password,gm.getPlayers().length));
            }
        }
        //Поиск в статистике
        Iterable<Account> accounts = new ArrayList<>();
        if(action!=null){
            switch (action) {
                case "Name" -> accounts = accountRepo.findByOrderByLogin();
                case "Score" -> accounts = accountRepo.findByOrderByScoreDesc();
            }
        }else accounts = accountRepo.findAll();
        model.addAttribute("accounts", accounts);
        return "statistic";
    }

    @GetMapping("/")
    public String startMenu(Model model){
        model.addAttribute("menuButtons",buttonMenu);
        return "startMenu";
    }

    @GetMapping("/prestartMenu")
    public String prestartMenu(){
        return "prestartMenu";
    }

    @GetMapping("/startGame")
    public String startGame(@RequestParam(name="X")String x, @RequestParam(name="Y")String y,
                            @RequestParam(name="Player1",required = false)String playerName1,
                            @RequestParam(name="Player2",required = false)String playerName2,
                            @RequestParam(name="Player3",required = false)String playerName3,
                            @RequestParam(name="Player4",required = false)String playerName4,
                            Model model){
        int mapWidth;
        int mapHeight;
        try {
            mapWidth = Integer.parseInt(x);
            mapHeight = Integer.parseInt(y);
            if((mapHeight<1||mapHeight>15)||(mapWidth<1)||mapWidth>15)throw new NumberFormatException();
        }catch (NumberFormatException e){
            model.addAttribute("message","Некорректное введение размеров карты");
            return "prestartMenu";
        }
        ArrayList<String> names = new ArrayList<>();
        if(!playerName1.equals(""))names.add(playerName1);
        if(!playerName2.equals(""))names.add(playerName2);
        if(!playerName3.equals(""))names.add(playerName3);
        if(!playerName4.equals(""))names.add(playerName4);
        if(names.size()<1){
            model.addAttribute("message","Нету игроков");
            return "prestartMenu";
        }
        gm = Processing.process(mapWidth,mapHeight,names);
        return game(null,null,null,null,null,model);
    }

    @GetMapping("/game")
    public String game(@RequestParam(name="action",required = false)String action,
                       @RequestParam(name="coordinates",required = false)String coordinates,
                       @RequestParam(name="sur",required = false)String sur,
                       @RequestParam(name="turn",required = false)String endTurn,
                       @RequestParam(name="building",required = false)String building,
                       Model model){
        //Работа программы если игрок делает что-то с картой
        if(action!=null) {
            int x;
            int y;
            try {
                if(coordinates.split(";").length!=2)throw new NumberFormatException();
                x=Integer.parseInt(coordinates.split(";")[0]);
                y=gm.getMap().length+1-Integer.parseInt(coordinates.split(";")[1]);
                if(x<1||x>gm.getMap()[0].length||y<1||y>gm.getMap().length)throw new NumberFormatException();
            }catch (NumberFormatException e){
                model.addAttribute("message","Неправильный ввод координат");
                model.addAttribute("map",gm.getMap());
                model.addAttribute("currentPlayer",gm.getCurrentPlayer()+1);
                model.addAttribute("players",gm.getPlayers());
                model.addAttribute("scores", gm.getScores());
                model.addAttribute("aimScore",gm.getAimScore());
                return "game";
            }
            //Реализация кнопок
            if (action.equals("capture")) {
                switch (gm.takeCell(x - 1, y - 1)) {
                    case 1 -> model.addAttribute("message", "Вам надо выбрать ничейную землю");
                    case 2 -> model.addAttribute("message", "Это клетка занята вами");
                    case 3 -> model.addAttribute("message", "Недостаточно ресурсов");
                    case 4 -> model.addAttribute("message", "Это клетка не граничит с вашей территорией");
                }
            }
            if (action.equals("upgrade")) {
                ArrayList<String> possibleBuildings = gm.checkForUpgradesCell(x-1,y-1);
                if(possibleBuildings.size()==0){
                    model.addAttribute("message","Нечего строить");
                }else {
                    switch (possibleBuildings.get(0)) {
                        case "Не достаточно ресурсов" -> model.addAttribute("message", "Не достаточно ресурсов");
                        case "Не ваша клетка" -> model.addAttribute("message", "Не ваша клетка");
                        case "На клетке уже есть постройка" -> model.addAttribute("message", "На клетке уже есть постройка");
                        default -> {
                            model.addAttribute("buildings",gm.checkForUpgradesCell(x-1,y-1));
                            upgradeX=x;
                            upgradeY=y;
                        }
                    }
                }

            }
            if (action.equals("clear")){
                switch (gm.deleteUpgrade(x-1,y-1)){
                    case 1->model.addAttribute("message","У вас нету клеток с улучшениями");
                    case 2->model.addAttribute("message","Это не ваша клетка");
                    case 3->model.addAttribute("message","На клетке ничего не простроено");
                }
            }
        }
        if(building!=null){
            int res = gm.upgradeCell(building,upgradeX-1,upgradeY-1);
            if(res!=0){
                model.addAttribute("message",("У вас недостаточно ресурсов ("+res+")"));
            }
        }
        //==============

        //Работа контроллера если игрок сдаётся
        if(sur!=null){
            gm.surrender();
            if(gm.checkIfAlong()){
                for (Map.Entry<String, Integer> player : gm.getScores().entrySet())
                    model.addAttribute("message",("Победил игрок " + player.getKey() + "!"));
                return "winScene";
            }
        }
        //Работа контроллера если игрок заканчивает ход
        if(endTurn!=null){
            String res=gm.endTurn();
            if(!res.equals("")){
                model.addAttribute("message", res);
                return "winScene";
            }
        }

        model.addAttribute("map",gm.getMap());
        model.addAttribute("currentPlayer",gm.getCurrentPlayer()+1);
        model.addAttribute("players", gm.getPlayers());
        model.addAttribute("scores", gm.getScores());
        model.addAttribute("aimScore",gm.getAimScore());
        return "game";
    }

    @GetMapping("/tutorial")
    public String tutorial(Model model) throws FileNotFoundException {
        FileReader fileReader = new FileReader("C:/Users/Admin/IdeaProjects/gam/src/main/java/org/example/tutorial.txt");
        Scanner fin = new Scanner(fileReader);
        String text = "";
        while (fin.hasNextLine())text+=fin.nextLine()+"\n";
        model.addAttribute("tutorial",text);
        return "tutorial";
    }

    @GetMapping("/rules")
    public String rules(Model model) throws FileNotFoundException {
        FileReader fileReader = new FileReader("C:/Users/Admin/IdeaProjects/gam/src/main/java/org/example/rules.txt");
        Scanner fin = new Scanner(fileReader);
        String text = "";
        while (fin.hasNextLine())text+=fin.nextLine()+"\n";
        model.addAttribute("rules",text);
        return "rules";
    }
}
