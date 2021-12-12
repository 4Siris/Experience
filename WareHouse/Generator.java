package com.company;

import java.util.Scanner;

public class Generator extends Thread{
    Scanner sin=new Scanner(System.in);

    @Override
    public void run() {
        try {
        System.out.println("t: ");
        int t= sin.nextInt();
        System.out.println("n: ");
        int n=sin.nextInt();
        System.out.println("m: ");
        int m= sin.nextInt();
        WareHouse wareHouse=new WareHouse(m,n);
        for(int i=0;i<t;i++){
            Car car=new Car(wareHouse);
            car.start();
                sleep((int)(Math.random()*3000+1000));
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        interrupt();
    }
}
