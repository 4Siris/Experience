package org.example.game;

import java.util.ArrayList;
import java.util.List;

//Класс хранения данных
public class Building {
    private List<String> possibleBuildings;
    private String currentBuilding;

    public Building(Field field){
        possibleBuildings=new ArrayList<>();
        possibleBuildings.add("wall");
        currentBuilding="none";
        ArrayList<String> terrains=field.getTerrain();
        for(String terrain:terrains){
            possibleBuildings.add(Processing.terrainUpgrades.get(terrain));
        }
        do {
            possibleBuildings.remove(null);
        }while (possibleBuildings.contains(null));
    }

    public void setPossibleBuildings(List<String> possibleBuildings) {
        this.possibleBuildings = possibleBuildings;
    }
    public void setCurrentBuilding(String currentBuilding) {
        this.currentBuilding = currentBuilding;
    }

    public List<String> getPossibleBuildings() {
        return possibleBuildings;
    }
    public String getCurrentBuilding() {
        return currentBuilding;
    }

    public void build(String building){
        currentBuilding=building;
    }
    public void destroyBuilding(){
        currentBuilding="none";
    }
}
