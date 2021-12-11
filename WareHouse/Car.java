package com.company;

public class Car extends Thread{
    private WareHouse wareHouse;
    private int maxAmount;
    private int currentAmount;
    private boolean add;

    public Car(WareHouse wareHouse){
        setWareHouse(wareHouse);
        setCurrentAmount((int)(Math.random()*10+21));
        setMaxAmount((int)(Math.random()*5+currentAmount));
        if(Math.random()>0.5)add=true;
        else add=false;
    }

    public void setWareHouse(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
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
    public boolean isAdd() {
        return add;
    }

    public void run() {
        try {
            int ramp=0;
            while (ramp==0) {
                ramp = wareHouse.checkRamp();
                if (ramp == 0) wait();
            }
            wareHouse.setRamp(true,ramp-1);
            System.out.println("Прибытие машины на рампу " + ramp);
            if(add){
                while (currentAmount!=0){
                    boolean upload=wareHouse.upLoading(this);
                    if(!upload){
                        if(wareHouse.getCurrentAmount()==wareHouse.getMaxAmount())sleep(100);
                    }else {
                        System.out.println(ramp + ". Загрузка товара - " + wareHouse.getCurrentAmount() + " из " + wareHouse.getMaxAmount() + " товаров");
                        sleep(50);
                    }
                }
            }else {
                while (currentAmount!=maxAmount){
                    boolean download=wareHouse.downLoading(this);
                    if(!download){
                        if(wareHouse.getCurrentAmount()==0)sleep(100);
                    }else {
                        System.out.println(ramp + ". Выгрузка товара - " + wareHouse.getCurrentAmount() + " из " + wareHouse.getMaxAmount() + " товаров");
                        sleep(50);
                    }
                }
            }
            wareHouse.setRamp(false,ramp-1);
            System.out.println("Освобожнеие рампы " + ramp);
            notify();
            interrupt();
        } catch (InterruptedException e) {
            System.out.println("Заказ завершён");
        }
    }
}
