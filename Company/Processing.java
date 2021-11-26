package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Processing {
    public Processing(String file) throws FileNotFoundException {
        String input=Downloader.DownloadInput(file);
        String[] services=input.split("\n");
        Map<String, String> language=localization(services[0]);
        List<Service> serviceList = inputServices(services);
        showSummary(serviceList,language);
    }

    public Map<String, String> localization(String language){
        return Localization.getInstance().getLanguages().get(language);
    }

    public List<Service> inputServices (String[] services){
        List<Service> serviceList=new ArrayList<>();
        for(int i=1;i<services.length;i++){
            String service=services[i].split("_")[0].toLowerCase(Locale.ROOT).trim();
            switch (service){
                case "показать данные":
                    ShowData showData=new ShowData(Integer.parseInt(services[i].split("_")[1]),Integer.parseInt(services[i].split("_")[2]));
                    serviceList.add(showData);
                    break;
                case "регрессия":
                    Regression regression=new Regression(Integer.parseInt(services[i].split("_")[1]),Integer.parseInt(services[i].split("_")[2]));
                    serviceList.add(regression);
                    break;
                case "нейронная сеть":
                    NeuralNetwork neuralNetwork=new NeuralNetwork(Integer.parseInt(services[i].split("_")[1]),Integer.parseInt(services[i].split("_")[2]),Integer.parseInt(services[i].split("_")[3]));
                    serviceList.add(neuralNetwork);
                    break;
                case "автоматизированная система":
                    AutoSystem autoSystem=new AutoSystem(Integer.parseInt(services[i].split("_")[1]),Integer.parseInt(services[i].split("_")[2]),Integer.parseInt(services[i].split("_")[3]));
                    serviceList.add(autoSystem);
                    break;
                default:
                    break;
            }
        }
        return serviceList;
    }

    public void showSummary (List<Service> serviceList, Map<String, String> language){
        String ans="";
        ans+=language.get("Доход компании");
        ans+=": ";
        double sum=0;
        for(Service service: serviceList){
            sum+=service.getCostDollars()+(service.getCostCents()*0.01);
            int salary=0;
            for(Worker worker:service.getAmountOfWorkers()){
                salary+=worker.getSalary();
            }
            salary*=service.getAccomplishedTime();
            sum-=salary;
        }
        ans+=sum;
    }
}
