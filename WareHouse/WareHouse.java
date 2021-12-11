package com.company;

class WareHouse{
    private int maxAmount;
    private int currentAmount;
    private boolean[] ramps;

    public WareHouse(){
        ramps=new boolean[5];
        maxAmount=100;
        currentAmount=0;
    }
    public WareHouse(int maxAmount, int amountOfRamps){
        this.maxAmount=maxAmount;
        ramps=new boolean[amountOfRamps];
    }

    public int getMaxAmount() {
        return maxAmount;
    }
    public int getCurrentAmount() {
        return currentAmount;
    }

    public synchronized int checkRamp() throws InterruptedException {
        for(int i=0;i<ramps.length;i++)if(!ramps[i])return i+1;
        return 0;
    }
    public synchronized void setRamp(boolean ramp, int number){
        ramps[number]=ramp;
    }

    public synchronized boolean upLoading(Car car) {
        if (currentAmount != maxAmount) {
            if (car.getCurrentAmount() != 0) {
                currentAmount += 1;
                car.setCurrentAmount(car.getCurrentAmount() - 1);
            } else return false;
        } else return false;
        return true;
    }

    public synchronized boolean downLoading(Car car){
        if (currentAmount != 0) {
            if (car.getCurrentAmount() != car.getMaxAmount()) {
                currentAmount -= 1;
                car.setCurrentAmount(car.getCurrentAmount() + 1);
            } else return false;
        } else return false;
        return true;
    }
}
