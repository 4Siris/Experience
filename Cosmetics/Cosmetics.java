package com.company;

public class Cosmetics {
    private String brand;
    private int costDollars;
    private int costCent;
    private boolean naturalComponents;
    private int expirationData;

    public Cosmetics() {
        brand ="";
        costDollars=0;
        costCent=0;
        naturalComponents =false;
        expirationData =0;

    }
    public Cosmetics(String brand, int costDollars, int costCent, boolean naturalComponents, int expirationData) {
        setBrand(brand);
        setCostDollars(costDollars);
        setCostCent(costCent);
        setNaturalComponents(naturalComponents);
        setExpirationData(expirationData);
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setCostDollars(int costDollars) {
        if(costDollars >=0)this.costDollars = costDollars;
    }
    public void setCostCent(int costCent) {
        if(costCent>0)
        {
            if(costCent>=100) this.costDollars+=costCent/100;
            this.costCent = costCent%100;
        }
    }
    public void setNaturalComponents(boolean naturalComponents) {
        this.naturalComponents = naturalComponents;
    }
    public void setExpirationData(int expirationData) {
        if(expirationData >=0)this.expirationData = expirationData;
    }

    public String getBrand() {
        return brand;
    }
    public int getCostDollars() {
        return costDollars;
    }
    public int getCostCent() {
        return costCent;
    }
    public boolean isNaturalComponents() {
        return naturalComponents;
    }
    public int getExpirationData() {
        return expirationData;
    }

    public void showInstructions() {
        System.out.println("Инструкция по приминению: ...");
    }
    public void showUtilizationMethod(){
        System.out.println("Метод утилицазии: ...");
    }

    @Override
    public String toString() {
        showInstructions();
        showUtilizationMethod();
        return "Бренд: " + brand + '\t' + "Стоймость: " + costDollars + '.' + costCent + '\n'
                +"Натуральные ли компоненты: " + ((naturalComponents)?("Да"):("Нет")) + '\n'
                +"Срок годности: " + expirationData +'\n';
    }
}
