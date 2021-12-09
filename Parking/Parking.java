package com.company;

class Parking extends Thread{
    private boolean[] parkingPlaces;

    public Parking(){
        parkingPlaces=new boolean[20];
    }

    public synchronized void placeCar(Car car){
        for (int i=0;i<parkingPlaces.length;i++){
            if (!parkingPlaces[i]){
                car.setParkingPlace(i+1);
                parkingPlaces[i]=true;
                break;
            }
        }
    }

    public synchronized void driveCar(Car car){
        parkingPlaces[car.getParkingPlace()-1]=false;
        car.setParkingPlace(0);
    }

    @Override
    public void run() {
        try {
            while (!interrupted()) {
                for(int i=0;i<20;i++){
                    System.out.print((parkingPlaces[i])?("Машина "):("Пусто "));
                }
                System.out.println();
                sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
