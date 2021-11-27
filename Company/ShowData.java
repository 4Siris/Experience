package com.company;

import java.util.ArrayList;
import java.util.List;

public class ShowData extends Service{
    public ShowData(int accomplishedTime, int amountOfMemory, String customer){
        super(40*amountOfMemory,0,accomplishedTime,new ArrayList<>(),customer,amountOfMemory);
        Worker newWorker=new Worker(1,33);
        List<Worker> workers=new ArrayList<>();
        workers.add(newWorker);
        setAmountOfWorkers(workers);
    }
}
