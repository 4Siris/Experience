package org.example.game;

import java.util.*;

//Главный класс-мэнеджер хранит данные об игре и занимается процессом игры
public class Game {
    private Cell[][] map;
    private Player[] players;
    private Map<String, Integer> scores;
    private int aimScore;
    private int currentPlayer = 0;

    //Стартовые методы для настройки игры
    public Game(Cell[][] map, Player[] players) {
        setPlayers(players);
        setMapAndScore(map);
    }

    public void setPlayers(Player[] players) {
        scores = new HashMap<>();
        this.players = players;
        for (Player player : players) scores.put(player.getName(), player.getScore());
    }
    public void setMapAndScore(Cell[][] map) {
        this.map = map;
        aimScore = (map.length+map[0].length)/2*players.length;
    }
    //========

    public Cell[][] getMap() {
        return map;
    }
    public Player[] getPlayers() {
        return players;
    }
    public Map<String, Integer> getScores() {
        return scores;
    }
    public int getAimScore() {
        return aimScore;
    }
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    //Метод конца хода
    public String endTurn() {
        gainResources(players[currentPlayer]);
        do {
            if (currentPlayer < players.length - 1) currentPlayer++;
            else currentPlayer = 0;
        }while (players[currentPlayer] == Processing.neutral);
        gainScore();
        refreshCells();
        return refreshStats();
    }

    //Методы захвата клетки
    public int takeCell(int x, int y) {
        boolean isFirstMove = !checkForAnyFields(currentPlayer);
        if (isFirstMove) {
            if (map[y][x].getClaim().equals(Processing.neutral)) {
                if(!claimCell(players[currentPlayer], map[y][x])){
                    //Недостаточно ресурсов
                    return 3;
                }
                refreshStats();
                refreshCells();
                return 0;
            }
            //Вам надо выбрать ничейную землю
            return 1;
        }
        if (map[y][x].getClaim().equals(players[currentPlayer])) {
            //Это клетка занята вами
            return 2;
        }
        boolean checkBorders = false;
        //Проверка соседство со своей территорией
        if (x > 0) checkBorders = map[y][x - 1].getClaim().equals(players[currentPlayer]);
        if (x < map[y].length - 1) checkBorders = checkBorders || map[y][x + 1].getClaim().equals(players[currentPlayer]);
        if (y > 0) checkBorders = checkBorders || map[y - 1][x].getClaim().equals(players[currentPlayer]);
        if (y < map.length - 1) checkBorders = checkBorders || map[y + 1][x].getClaim().equals(players[currentPlayer]);
        //===========
        if (!checkBorders) {
            //Клетка не граничит с вашей территорией
            return 4;
        } else {
            if(!claimCell(players[currentPlayer], map[y][x])){
                //Недостаточно ресурсов
                return 3;
            }
        }
        refreshStats();
        refreshCells();
        //Захвата произведён
        return 0;
    }

    private boolean claimCell(Player player, Cell cell) {
        int amount = cell.getResources().getProductivity() + cell.getResources().getFood();
        if (cell.getBuildingPlace().getCurrentBuilding().equals("wall")) amount += 5;
        if (player.getResources().getProductivity() >= amount) {
            player.getResources().setProductivity(player.getResources().getProductivity() - amount);
            cell.setClaim(player);
            //Клетка захвачена
            return true;
        } else {
            //Недостаточно ресурсов
            return false;
        }
    }
    //Метод проверки первого хода
    private boolean checkForAnyFields(int currentPlayer) {
        boolean ans = false;
        for (Cell[] cells : map) {
            for (int j = 0; j < map[0].length; j++) {
                ans = ans || (cells[j].getClaim().equals(players[currentPlayer]));
            }
        }
        return ans;
    }
    //============

    //Методы для улучшения клетки
    //Метод проверки и, в случае успешной проверки, возврат списка возможных построек
    public ArrayList<String> checkForUpgradesCell(int x, int y) {
        ArrayList<String> possibleBuildings = new ArrayList<>();
        if (players[currentPlayer].getResources().getProductivity() < 1){
            possibleBuildings.add("Не достаточно ресурсов");
            return possibleBuildings;
        }
        if (!map[y][x].getClaim().equals(players[currentPlayer])) {
            possibleBuildings.add("Не ваша клетка");
            return possibleBuildings;
        }
        if (!map[y][x].getBuildingPlace().getCurrentBuilding().equals("none")){
            possibleBuildings.add("На клетке уже есть постройка");
            return possibleBuildings;
        }
        possibleBuildings.addAll(map[y][x].getBuildingPlace().getPossibleBuildings());
        return possibleBuildings;
    }
    //Метод проверки и, в случае успешной проверки, постройка здания
    public int upgradeCell(String building,int x, int y){
        if(building.equals("wall")){
            if(players[currentPlayer].getResources().getProductivity()<5)
                //Недостаточно ресурсов нужно 5
                return 5;
            else {
                players[currentPlayer].getResources().setProductivity(players[currentPlayer].getResources().getProductivity()-5);
                map[y][x].getBuildingPlace().build(building);
                map[y][x].refreshCell();
            }
        }else {
            if(players[currentPlayer].getResources().getProductivity()<1)
                //Недостаточно ресурсов нужно 1
                return 1;
            else {
                players[currentPlayer].getResources().setProductivity(players[currentPlayer].getResources().getProductivity()-1);
                map[y][x].getBuildingPlace().build(building);
                map[y][x].refreshCell();
            }
        }
        //Успешная постройка
        return 0;
    }
    //=======

    //Методы для сноса улучшения
    public int deleteUpgrade(int x, int y) {
        ArrayList<Integer[]> coordinates = checkForAnyUpgradedFields(currentPlayer);
        if (coordinates.isEmpty())
            //Нету клеток с улучшениями
            return 1;
        if (!map[y][x].getClaim().equals(players[currentPlayer]))
            //Выбранная клетка не ваша
            return 2;
        if (map[y][x].getBuildingPlace().getCurrentBuilding().equals("none"))
            //На клетке ничего не построено
            return 3;
        map[y][x].getBuildingPlace().destroyBuilding();
        map[y][x].refreshCell();
        return 0;
    }

    private ArrayList<Integer[]> checkForAnyUpgradedFields(int currentPlayer){
        ArrayList<Integer[]> coordinates=new ArrayList<>();
        for(int i=0;i< map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j].getClaim().equals(players[currentPlayer])){
                    if(!map[i][j].getBuildingPlace().getCurrentBuilding().equals("none")){
                        Integer[] coordinate=new Integer[]{j,i};
                        coordinates.add(coordinate);
                    }
                }
            }
        }
        return coordinates;
    }
    //==========

    //Методы для функции сдаться
    public void surrender(){
        removeAllClaims(currentPlayer);
        scores.remove(players[currentPlayer].getName());
        if(checkIfAlong())return;
        players[currentPlayer]=Processing.neutral;
        do{
            if(currentPlayer==players.length-1)currentPlayer=0;
            else currentPlayer++;
        }while (players[currentPlayer]==Processing.neutral);
        refreshCells();
    }

    private void removeAllClaims(int currentPlayer){
        for (Cell[] cells : map) {
            for (int j = 0; j < map[0].length; j++) {
                if (cells[j].getClaim().equals(players[currentPlayer])) cells[j].setClaim(Processing.neutral);
            }
        }
    }
    //==========

    //Функциональные методы использующиеся многими другими методами
    private void gainResources(Player player){
        for (Cell[] cells : map) {
            for (int j = 0; j < map[0].length; j++) {
                if (cells[j].getClaim().equals(player)) {
                    players[cells[j].getClaim().getNumber() - 1].getResources().setProductivity(players[cells[j].getClaim().getNumber() - 1].getResources().getProductivity() + cells[j].getResources().getProductivity());
                    players[cells[j].getClaim().getNumber() - 1].getResources().setFood(players[cells[j].getClaim().getNumber() - 1].getResources().getFood() + cells[j].getResources().getFood());
                }
            }
        }
    }
    private void gainScore(){
        for (Player player : players) if(!player.equals(Processing.neutral))player.gainScore();
    }
    private String refreshStats(){
        for(Player player:players)if(!player.equals(Processing.neutral))scores.put(player.getName(),player.getScore());
        for(Player player:players)
            if(!player.equals(Processing.neutral))
                if(scores.get(player.getName())>=aimScore){
                    return "Победил игрок "+player.getName();
                }
        return "";
    }
    private void refreshCells(){
        for (Cell[] cells : map) {
            for (int j = 0; j < map[0].length; j++) {
                cells[j].refreshCell();
            }
        }
    }
    public boolean checkIfAlong(){
        return scores.size() == 1;
    }
}
