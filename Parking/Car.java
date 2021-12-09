package com.company;

public class Car extends Thread{
    private Parking parking;
    private int parkingPlace;

    public Car(Parking parking){
        this.parking=parking;
        parkingPlace =0;
    }

    public void setParkingPlace(int parkingPlace) {
        this.parkingPlace = parkingPlace;
    }

    public int getParkingPlace() {
        return parkingPlace;
    }

    public void run() {
        try {
            while (!interrupted()) {
                if (this.parkingPlace == 0) {
                    parking.placeCar(this);
                    sleep((int) (Math.random() * 5000 + 5000));
                }
                if (this.parkingPlace != 0) {
                    parking.driveCar(this);
                    sleep((int) (Math.random() * 8000 + 7000));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
