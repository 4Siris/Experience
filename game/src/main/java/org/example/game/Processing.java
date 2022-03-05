package org.example.game;

import java.util.ArrayList;
import java.util.HashMap;

//Статический класс для создания стартовых данных игры и хранения статических данных
public class Processing {
    public static Game process(int x, int y, ArrayList<String> names){
        Processing.generate();
        Cell[][]map = createMap(x,y);
        Player[]players = createPlayers(names);
        return new Game(map,players);
    }

    public static HashMap<String, String> terrainUpgrades= new HashMap<>();
    public static Player neutral=new Player("none",0);

    private static void generate(){
        terrainUpgrades.put("field","farm");
        terrainUpgrades.put("mountain","mine");
        terrainUpgrades.put("forest","sawmill");
    }

    private static Player[] createPlayers(ArrayList<String> names){
        Player[] players=new Player[names.size()];
        for(int i=0;i<players.length;i++){
            players[i]=new Player(names.get(i),i+1);
        }
        return players;
    }
    private static Cell[][] createMap(int x, int y){
        Cell[][]cells=new Cell[y][x];
        for(int i=0;i<y;i++) {
            for (int j = 0; j < x;j++) {
                cells[i][j] = new Cell(neutral);
            }
        }
        return cells;
    }
}