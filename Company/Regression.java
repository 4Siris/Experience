package com.company;

import java.util.ArrayList;
import java.util.List;

public class Regression extends Service{
    public Regression(int accomplishedTime,int amountOfMemory, String customer){
        super(0,0,accomplishedTime,new ArrayList<>(),customer,amountOfMemory);
        if(amountOfMemory<=1024)setCostDollars(200*accomplishedTime+50*amountOfMemory);
        else setCostDollars(250*accomplishedTime+70*amountOfMemory);
        Worker newWorker=new Worker(2,70);
        List<Worker> workers=new ArrayList<>();
        workers.add(newWorker);
        workers.add(newWorker);
        setAmountOfWorkers(workers);
    }
}
