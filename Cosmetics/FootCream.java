package com.company;

public class FootCream extends Cream{
    public FootCream(){
        super();
    }
    public FootCream(String smell, int viscosity, String brand, int costDollars, int costCent, boolean naturalComponents, int expirationData, Sex sex, Age age){
        super(smell, viscosity, brand, costDollars, costCent, naturalComponents, expirationData, sex, age);
    }

    public String toString() {
        return super.toString() + "Для ног" + '\n';
    }
}
