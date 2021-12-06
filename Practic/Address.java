package com.company;

import java.io.StringReader;

public class Address {
    private String country;
    private String region;
    private String district;
    private String street;
    private int house;
    private int flat=0;

    public Address(){
        country="";
        region="";
        district="";
        street="";
        house=0;
    }
    public Address(String country, String region, String district, String street, int house, int flat){
        setCountry(country);
        setRegion(region);
        setDistrict(district);
        setStreet(street);
        setHouse(house);
        setFlat(flat);
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setHouse(int house) {
        if(house>0)this.house = house;
    }
    public void setFlat(int flat) {
        if(flat>0)this.flat = flat;
    }

    public String getCountry() {
        return country;
    }
    public String getRegion() {
        return region;
    }
    public String getDistrict() {
        return district;
    }
    public String getStreet() {
        return street;
    }
    public int getHouse() {
        return house;
    }
    public int getFlat() {
        return flat;
    }

    @Override
    public String toString() {
        return  country + ", " + region+" область" + ", " + district + " район"+'\n' +
                street + " " + house + ((flat!=0)?(", " +flat + " кв."):(""));
    }
}
