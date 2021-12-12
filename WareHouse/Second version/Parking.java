package com.company;

import java.util.HashSet;
import java.util.Set;

public class Parking {
    private Set<Car> places;

    public Parking(){
        places=new HashSet<>();
    }

    public Set<Car> getPlaces() {
        return places;
    }

    public void addCar(Car car){
        places.add(car);
    }

    public void removeCar(Car car){
        places.remove(car);
    }

    @Override
    public String toString() {
        return "Парковка: " + places.toString();
    }
}
