package org.example.game;

import java.util.ArrayList;

//Класс Клетка из которой и состоит карта, хранит данные
public class Cell {
    private Field field;
    private Resources resources;
    private Player claim;
    private Building buildingPlace;

    public Cell(Player player){
        setField(new Field());
        setResources(new Resources());
        setClaim(player);
        setBuildingPlace(new Building(field));
        refreshCell();
    }

    public void setField(Field field) {
        this.field = field;
    }
    public void setResources(Resources resources) {
        this.resources = resources;
    }
    public void setClaim(Player claim) {
        this.claim = claim;
    }
    public void setBuildingPlace(Building buildingPlace) {
        this.buildingPlace = buildingPlace;
    }

    public ArrayList<String> getTerrains () {
        return field.getTerrain();
    }
    public Field getField() {
        return field;
    }
    public Resources getResources() {
        return resources;
    }
    public Player getClaim() {
        return claim;
    }
    public Building getBuildingPlace() {
        return buildingPlace;
    }

    //Метод для обновления данных клетки в начале и в случае постройки/уничтожения здания
    public void refreshCell(){
        ArrayList<String> terrains=field.getTerrain();
        Resources tempResources=new Resources();

        if(terrains.contains("field"))tempResources.setFood(tempResources.getFood()+1);
        if(terrains.contains("forest")){
            tempResources.setFood(tempResources.getFood()+1);
            tempResources.setProductivity(tempResources.getProductivity()+1);
        }
        if(terrains.contains("lake"))tempResources.setFood(tempResources.getFood()+1);
        if(terrains.contains("mountain"))tempResources.setProductivity(tempResources.getProductivity()+1);
        if(buildingPlace.getCurrentBuilding().equals("farm"))tempResources.setFood(tempResources.getFood()+1);
        if(buildingPlace.getCurrentBuilding().equals("mine"))tempResources.setProductivity(tempResources.getProductivity()+1);
        if(buildingPlace.getCurrentBuilding().equals("sawmill"))tempResources.setProductivity(tempResources.getProductivity()+1);

        setResources(tempResources);
    }

    @Override
    public String toString() {
        return resources.toString();
    }
}