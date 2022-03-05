package org.example.game;

//Класс хранения данных
public class Resources {
    private int food;
    private int productivity;

    public Resources(){
        setFood(0);
        setProductivity(0);
    }
    public Resources(int food, int productivity){
        setFood(food);
        setProductivity(productivity);
    }

    public void setFood(int food) {
        if(food>=0)this.food = food;
    }
    public void setProductivity(int productivity) {
        if(productivity>=0)this.productivity = productivity;
    }

    public int getFood() {
        return food;
    }
    public int getProductivity() {
        return productivity;
    }

    @Override
    public String toString() {
        return "F="+food+";P="+productivity;
    }
}
