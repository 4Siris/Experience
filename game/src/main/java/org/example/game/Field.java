package org.example.game;

import java.util.ArrayList;

//Класс хранения данных
public class Field {
    private ArrayList<String> terrain = new ArrayList<>();

    public Field(){
        int amount= (int) (Math.random()*4+1);
        for(int i=0;i<amount;i++){
            int choice= (int) (Math.random()*4+1);
            switch (choice) {
                case 1 -> addTerrain("field");
                case 2 -> addTerrain("lake");
                case 3 -> addTerrain("mountain");
                case 4 -> addTerrain("forest");
            }
        }
    }

    public void setTerrain(ArrayList<String> terrain) {
        this.terrain = terrain;
    }

    public ArrayList<String> getTerrain() {
        return terrain;
    }

    //Специальный метод для возврата строки правильного формата для класса html
    public String getEachTerrain(){
        return terrain.toString().replace("[","").replace("]","").replace(",","");
    }

    public void addTerrain(String terrain){
        if(!this.terrain.contains(terrain)) {
            this.terrain.add(terrain);
        }
    }

    @Override
    public String toString() {
        return terrain.toString();
    }
}