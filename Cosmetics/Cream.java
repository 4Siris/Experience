package com.company;

public class Cream extends Cosmetics{
    private String smell;
    private int viscosity;
    private Sex sex;
    private Age age;

    public Cream(){
        super();
        smell ="";
        viscosity =0;
        sex=new Sex();
        age=new Age();
    }
    public Cream(String smell, int viscosity, String brand, int costDollars, int costCent, boolean naturalComponents, int expirationData, Sex sex, Age age){
        super(brand, costDollars, costCent, naturalComponents, expirationData);
        setSmell(smell);
        setViscosity(viscosity);
        this.sex=sex;
        this.age=age;
    }

    public void setSmell(String smell) {
        this.smell = smell;
    }
    public void setViscosity(int viscosity) {
        if(viscosity >=0)this.viscosity = viscosity;
    }

    public String getSmell() {
        return smell;
    }
    public int getViscosity() {
        return viscosity;
    }

    @Override
    public String toString() {
        return super.toString() + "Крем\nЗапах: " + smell + '\t' + "Вязкость: " + viscosity + '\n'
                + ((!sex.getSex().equals(""))?(sex):("")) + ((age.getMaxAge()!=-1)?(age):("")) + '\n';
    }
}
