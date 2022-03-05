package org.example.game;

//Класс Игрок, для взаимодействия с игрой и хранения данных об игроке
public class Player {
    private int number;
    private String name;
    private Resources resources;
    private int score;

    public Player(String name, int number){
        this.number=number;
        this.name=name;
        score=1;
        resources=new Resources(0,3);
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public Resources getResources() {
        return resources;
    }
    public int getNumber() {
        return number;
    }
    public String getName(){
        return name;
    }
    public int getScore() {
        return score;
    }

    public void gainScore(){
        while (1.0*resources.getFood()/score>=1){
            resources.setFood(resources.getFood()-score);
            score++;
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "number=" + number +
                ", name='" + name +
                ", resources=" + resources +
                '}';
    }
}