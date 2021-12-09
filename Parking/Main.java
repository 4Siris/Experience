package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Parking parking=new Parking();
        Car[] cars=new Car[50];
        parking.start();
        for (int i=0;i<cars.length;i++) {
            cars[i]=new Car(parking);
            cars[i].start();
        }
        Thread.sleep(30000);
        for(int i=0;i<50;i++)cars[i].interrupt();
        parking.interrupt();
    }
}
