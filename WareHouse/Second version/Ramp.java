package com.company;

import java.util.Set;

public class Ramp extends Thread {
    private WareHouse wareHouse;
    private Car car;
    private int number;

    public Ramp(WareHouse wareHouse) {
        setWareHouse(wareHouse);
        car = null;
    }

    public void setWareHouse(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public WareHouse getWareHouse() {
        return wareHouse;
    }

    public Car getCar() {
        return car;
    }

    public int getNumber() {
        return number;
    }

    public synchronized void chooseCar() {
        Set<Car> cars = wareHouse.getParking().getPlaces();
        if (wareHouse.getCurrentAmount() > 0) {
            for (Car car : cars) {
                if (car.getGoal().equals(Goal.TAKE)) {
                    setCar(car);
                    break;
                }
            }
        }
        if (wareHouse.getCurrentAmount() != wareHouse.getMaxAmount()) {
            for (Car car : cars) {
                if (car.getGoal().equals(Goal.PUT)) {
                    setCar(car);
                    break;
                }
            }
        }
        wareHouse.getParking().removeCar(car);
    }

    public synchronized void putCar(Car car) {
        wareHouse.getParking().addCar(car);
        this.car = null;
    }

    public synchronized boolean putItem() {
        if (wareHouse.getCurrentAmount() != wareHouse.getMaxAmount()) {
            if (car.getCurrentAmount() != 0) {
                System.out.println(number + ". Загрузка товара - " + wareHouse.getCurrentAmount() + " из " + wareHouse.getMaxAmount() + " товаров");
                wareHouse.setCurrentAmount(wareHouse.getCurrentAmount() + 1);
                car.setCurrentAmount(car.getCurrentAmount() - 1);
            } else return false;
        } else return false;
        return true;
    }
    public synchronized boolean takeItem() {
        if (wareHouse.getCurrentAmount() != 0) {
            if (car.getCurrentAmount() != car.getMaxAmount()) {
                System.out.println(number + ". Выгрузка товара - " + wareHouse.getCurrentAmount() + " из " + wareHouse.getMaxAmount() + " товаров");
                wareHouse.setCurrentAmount(wareHouse.getCurrentAmount() - 1);
                car.setCurrentAmount(car.getCurrentAmount() + 1);
            } else return false;
        } else return false;
        return true;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            try {
                while (car == null) {
                    synchronized (wareHouse) {
                        if (wareHouse.getParking() != null) chooseCar();
                        if (car == null) sleep(100);
                    }
                }
                if (car.getGoal().equals(Goal.PUT)) {
                    while (true) {
                        synchronized (wareHouse) {
                            if (!putItem()) {
                                if (car.getCurrentAmount() == 0) {
                                    System.out.println("Уехала " + car);
                                    car = null;
                                } else {
                                    putCar(car);
                                }
                                System.out.println("Освобожнеие " + number + " рампы");
                                break;
                            }
                            sleep(50);
                        }
                    }
                } else {
                    while (true) {
                        synchronized (wareHouse) {
                            if (!takeItem()) {
                                if (car.getCurrentAmount() == car.getMaxAmount()) {
                                    System.out.println("Уехала " + car);
                                    car = null;
                                } else {
                                    putCar(car);
                                }
                                System.out.println("Освобожнеие " + number + " рампы");
                                break;
                            }
                            sleep(50);
                        }
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Рампа "+ number+ " прекратила работу" );
            }
        }
    }
}
