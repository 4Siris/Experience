package com.company;

public class Powder extends Cosmetics{
    private String color;
    private boolean matting;

    public Powder(){
        super();
        color="";
        matting=false;
    }
    public Powder(String color, boolean matting, String brand, int costDollars, int costCent, boolean naturalComponents, int expirationData){
        super(brand, costDollars, costCent, naturalComponents, expirationData);
        setColor(color);
        setMatting(matting);
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void setMatting(boolean matting) {
        this.matting = matting;
    }

    public String getColor() {
        return color;
    }
    public boolean isMatting() {
        return matting;
    }

    @Override
    public String toString() {
        return super.toString() + "Пудра\nЦвет: " + color + '\n'
                + "Матирующая: " + ((matting)?("Да"):("Нет")) + '\n';
    }
}
