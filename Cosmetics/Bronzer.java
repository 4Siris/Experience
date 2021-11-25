package com.company;

public class Bronzer extends Powder{
    public Bronzer(){
        super();
    }
    public Bronzer(String color, boolean matting, String brand, int costDollars, int costCent, boolean naturalComponents, int expirationData){
        super(color, matting, brand, costDollars, costCent, naturalComponents, expirationData);
    }

    public String toString() {
        return super.toString() + "Бронзер" + '\n';
    }
}
