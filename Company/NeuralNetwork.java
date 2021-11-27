package com.company;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork extends Service{
    public NeuralNetwork(int accomplishedTime,int amountOfMemory,int choice, String customer){
        super(0,0,accomplishedTime,new ArrayList<>(),customer,amountOfMemory);
        if(choice==1)setCostDollars(500*accomplishedTime);
        else setCostDollars(200*amountOfMemory);
        Worker newWorker=new Worker(1,33);
        List<Worker> workers=new ArrayList<>();
        workers.add(newWorker);
        newWorker=new Worker(2,70);
        workers.add(newWorker);
        workers.add(newWorker);
        newWorker=new Worker(3,120);
        workers.add(newWorker);
        workers.add(newWorker);
        setAmountOfWorkers(workers);
    }
}
