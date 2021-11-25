package com.company;

public class Highlighter extends Powder{
    public Highlighter(){
        super();
    }
    public Highlighter(String color, boolean matting, String brand, int costDollars, int costCent, boolean naturalComponents, int expirationData){
        super(color, matting, brand, costDollars, costCent, naturalComponents, expirationData);
    }

    @Override
    public String toString() {
        return super.toString() + "Хайлайтер" + '\n';
    }
}
