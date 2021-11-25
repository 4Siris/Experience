package com.company;

public class Age {
    private int minAge;
    private int maxAge;

    public Age(){
        minAge=-1;
        maxAge=-1;
    }
     public Age(int minAge, int maxAge){
        setMinAge(minAge);
        setMaxAge(maxAge);
     }

    public void setMinAge(int minAge) {
        if(minAge>=0)this.minAge = minAge;
    }
    public void setMaxAge(int maxAge) {
        if(maxAge>0)this.maxAge = maxAge;
    }

    public int getMinAge() {
        return minAge;
    }
    public int getMaxAge() {
        return maxAge;
    }

    @Override
    public String toString() {
        return "Возраст: от " + minAge + " до " + maxAge;
    }
}
