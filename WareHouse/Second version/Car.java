package com.company;

public class Car{
    private int maxAmount;
    private int currentAmount;
    private Goal goal;

    public Car(){
        setMaxAmount((int)(Math.random()*50));
        setCurrentAmount((int)(Math.random()*maxAmount));
        if(Math.random()>0.5)goal=Goal.PUT;
        else goal=Goal.TAKE;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }
    public void setCurrentAmount(int currentAmount) {
        this.currentAmount = currentAmount;
    }

    public int getMaxAmount() {
        return maxAmount;
    }
    public int getCurrentAmount() {
        return currentAmount;
    }
    public Goal getGoal() {
        return goal;
    }

    @Override
    public String toString() {
        return "\nМашина\n" +
                "Загруженность - ("+currentAmount+" / "+maxAmount+")"+
                "\nЦель: " + goal;
    }
}

enum Goal{
    PUT,
    TAKE;
}