package com.company;

import java.util.ArrayList;
import java.util.List;

public class AutoSystem extends Service{
    public AutoSystem(int accomplishedTime,int amountOfMemory, int choice, String customer){
        super(0,0,accomplishedTime,new ArrayList<>(),customer,amountOfMemory);
        ShowData showData=new ShowData(accomplishedTime,amountOfMemory,customer);
        Regression regression=new Regression(accomplishedTime,amountOfMemory,customer);
        NeuralNetwork neuralNetwork=new NeuralNetwork(accomplishedTime,amountOfMemory,choice,customer);
        List<Worker> workers=new ArrayList<>();
        Worker newWorker=new Worker(3,120);
        workers.add(newWorker);
        workers.add(newWorker);
        workers.add(newWorker);
        workers.addAll(showData.getAmountOfWorkers());
        workers.addAll(regression.getAmountOfWorkers());
        workers.addAll(neuralNetwork.getAmountOfWorkers());
        setAmountOfWorkers(workers);
        setCostDollars(15000+showData.getCostDollars()+regression.getCostDollars()+neuralNetwork.getCostDollars());
    }
}
