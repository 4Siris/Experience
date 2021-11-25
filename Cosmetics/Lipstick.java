package com.company;

public class Lipstick extends Cosmetics{
    private String color;

    public Lipstick(){
        super();
        color="";
    }
    public Lipstick(String color, String brand, int costDollars, int costCent, boolean naturalComponents, int expirationData){
        super(brand, costDollars, costCent, naturalComponents, expirationData);
        setColor(color);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return super.toString() + "Помада\nЦвет: "+ color + '\n';
    }
}
