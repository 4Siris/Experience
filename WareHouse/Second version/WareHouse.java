package com.company;

class WareHouse{
    private int maxAmount;
    private int currentAmount;
    private Ramp[] ramps;
    private Parking parking;

    public WareHouse(){
        maxAmount=100;
        currentAmount=0;
        parking=new Parking();
        ramps=new Ramp[5];
        for(int i=0;i<ramps.length;i++){
            ramps[i]=new Ramp(this);
            ramps[i].start();
        }
    }
    public WareHouse(int maxAmount, int amountOfRamps){
        this.maxAmount=maxAmount;
        currentAmount=0;
        parking=new Parking();
        ramps=new Ramp[amountOfRamps];
        for(int i=0;i<ramps.length;i++){
            ramps[i]=new Ramp(this);
            ramps[i].setNumber(i+1);
            ramps[i].start();
        }
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
    public Parking getParking() {
        return parking;
    }

    public void firstlyGetCar(Car car){
        System.out.println("Приехала "+car);
        parking.addCar(car);
    }

    public void stopWork(){
        for(int i=0;i<ramps.length;i++)ramps[i].interrupt();
        if(parking.getPlaces().size()==0) System.out.println("Все машины были обслужены");
        else System.out.println("Несколько машин осталось, по плохим подсчётам компании.\n"+parking);
    }
}