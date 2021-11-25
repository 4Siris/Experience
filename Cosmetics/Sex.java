package com.company;

public class Sex {
    private String sex;

    public Sex(){
        sex="";
    }
    public Sex(String sex){
        setSex(sex);
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Пол: " + sex;
    }
}
