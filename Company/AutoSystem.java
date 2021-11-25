package com.company;

import java.util.ArrayList;
import java.util.List;

public class AutoSystem extends Service{
    public AutoSystem(int accomplishedTime,int amountOfMemory, int choice){
        super(0,0,accomplishedTime,new ArrayList<>(),"",amountOfMemory);
        ShowData showData=new ShowData(accomplishedTime,amountOfMemory);
        Regression regression=new Regression(accomplishedTime,amountOfMemory);
        NeuralNetwork neuralNetwork=new NeuralNetwork(accomplishedTime,amountOfMemory,choice);
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
