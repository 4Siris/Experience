package com.company;

public class HandCream extends Cream{
    public HandCream(){
        super();
    }
    public HandCream(String smell, int viscosity, String brand, int costDollars, int costCent, boolean naturalComponents, int expirationData, Sex sex, Age age){
        super(smell, viscosity, brand, costDollars, costCent, naturalComponents, expirationData, sex, age);
    }

    public String toString() {
        return super.toString() + "Для рук" + '\n';
    }
}
