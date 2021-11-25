package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Service {
    private int costDollars;
    private int costCents;
    private int accomplishedTime;
    private List<Worker> amountOfWorkers;
    private String customerName;
    private int amountOfMemory;

    public Service(){
        costDollars=0;
        costCents=0;
        accomplishedTime=0;
        amountOfWorkers=new ArrayList<>();
        customerName="";
        amountOfMemory=0;
    }
    public Service(int costDollars, int costCents, int accomplishedTime, List<Worker> amountOfWorkers, String customerName, int amountOfMemory){
        setCostDollars(costDollars);
        setCostCents(costCents);
        setAccomplishedTime(accomplishedTime);
        setAmountOfWorkers(amountOfWorkers);
        setCustomerName(customerName);
        setAmountOfMemory(amountOfMemory);
    }

    public void setCostDollars(int costDollars) {
        if(costDollars>=0)this.costDollars = costDollars;
    }
    public void setCostCents(int costCents) {
        if(costCents>=0){
            if(costCents>=100){
                this.costCents = costCents%100;
                this.costDollars+=costCents/100;
            }else this.costCents=costCents;
        }
    }
    public void setAccomplishedTime(int accomplishedTime) {
        if(accomplishedTime>=0)this.accomplishedTime = accomplishedTime;
    }
    public void setAmountOfWorkers(List<Worker> amountOfWorkers) {
        this.amountOfWorkers = amountOfWorkers;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName.toLowerCase(Locale.ROOT).trim();
    }
    public void setAmountOfMemory(int amountOfMemory) {
        if(amountOfMemory>0)this.amountOfMemory = amountOfMemory;
    }

    public int getCostDollars() {
        return costDollars;
    }
    public int getCostCents() {
        return costCents;
    }
    public int getAccomplishedTime() {
        return accomplishedTime;
    }
    public List<Worker> getAmountOfWorkers() {
        return amountOfWorkers;
    }
    public String getCustomerName() {
        return customerName;
    }
    public int getAmountOfMemory() {
        return amountOfMemory;
    }

    @Override
    public String toString() {
        return "Service{" +
                "costDollars=" + costDollars +
                ", costCents=" + costCents +
                ", accomplishedTime=" + accomplishedTime +
                ", amountOfWorkers=" + amountOfWorkers +
                ", customerName='" + customerName + '\'' +
                ", amountOfMemory=" + amountOfMemory +
                '}';
    }
}
