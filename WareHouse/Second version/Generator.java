package com.company;

import java.util.Scanner;

public class Generator extends Thread{
    Scanner sin=new Scanner(System.in);

    @Override
    public void run() {
        try {
        System.out.print("t: ");
        int t= sin.nextInt();
        System.out.print("n: ");
        int n=sin.nextInt();
        System.out.print("m: ");
        int m= sin.nextInt();
        WareHouse wareHouse=new WareHouse(m,n);
        for(int i=0;i<t;i++){
                wareHouse.firstlyGetCar(new Car());
                sleep((int)(Math.random()*1000+1000));
            }
        sleep((int)(t*1.0/n*4000));
        wareHouse.stopWork();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        interrupt();
    }
}
