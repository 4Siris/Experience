package com.company;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.*;

public class Processing {
    public Processing(String file) throws FileNotFoundException {
        String input=Downloader.DownloadInput(file);
        String[] services=input.split("\n");
        Map<String, String> language=localization(services[0]);
        List<Service> serviceList = inputServices(services);
        Map<String, Double> customersIncome=new HashMap<>();
        Map<String, Double> servicesIncome=new HashMap<>();
        showSummary(serviceList,language,customersIncome,servicesIncome);
        showNegativeCustomers(customersIncome);
        showTopFiveCustomers(customersIncome);
        showTopServices(servicesIncome,language);
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
                    ShowData showData=new ShowData(Integer.parseInt(services[i].split("_")[1]),Integer.parseInt(services[i].split("_")[2]),(services[i].split("_")[3]));
                    serviceList.add(showData);
                    break;
                case "регрессия":
                    Regression regression=new Regression(Integer.parseInt(services[i].split("_")[1]),Integer.parseInt(services[i].split("_")[2]),(services[i].split("_")[3]));
                    serviceList.add(regression);
                    break;
                case "нейронная сеть":
                    NeuralNetwork neuralNetwork=new NeuralNetwork(Integer.parseInt(services[i].split("_")[1]),Integer.parseInt(services[i].split("_")[2]),Integer.parseInt(services[i].split("_")[3]),(services[i].split("_")[4]));
                    serviceList.add(neuralNetwork);
                    break;
                case "автоматизированная система":
                    AutoSystem autoSystem=new AutoSystem(Integer.parseInt(services[i].split("_")[1]),Integer.parseInt(services[i].split("_")[2]),Integer.parseInt(services[i].split("_")[3]),(services[i].split("_")[4]));
                    serviceList.add(autoSystem);
                    break;
                default:
                    break;
            }
        }
        return serviceList;
    }

    public void showSummary (List<Service> serviceList, Map<String, String> language, Map<String, Double> customersIncome, Map<String, Double> servicesIncome){
        String ans="";
        ans+=language.get("Доход компании");
        ans+=": ";
        double sum=0;
        double tempSum=sum;
        for(Service service: serviceList){
            tempSum=service.getCostDollars()+(service.getCostCents()*0.01);
            int salary=0;
            for(Worker worker:service.getAmountOfWorkers()){
                salary+=worker.getSalary();
            }
            salary*=service.getAccomplishedTime();
            tempSum-=salary;
            sum+=tempSum;
            customersIncome.put(service.getCustomerName(),tempSum);
            if(service instanceof ShowData)
                if(servicesIncome.get("ShowData")==null) servicesIncome.put("ShowData",tempSum);
                    else servicesIncome.put("ShowData",servicesIncome.get("ShowData")+tempSum);
            if(service instanceof Regression)
                if(servicesIncome.get("Regression")==null)servicesIncome.put("Regression",tempSum);
                    else servicesIncome.put("Regression",servicesIncome.get("Regression")+tempSum);
            if(service instanceof NeuralNetwork)
                if(servicesIncome.get("NeuralNetwork")==null)servicesIncome.put("NeuralNetwork",tempSum);
                else servicesIncome.put("NeuralNetwork",servicesIncome.get("NeuralNetwork")+tempSum);
            if(service instanceof AutoSystem)
                if(servicesIncome.get("AutoSystem")==null)servicesIncome.put("AutoSystem",tempSum);
                else servicesIncome.put("AutoSystem",servicesIncome.get("AutoSystem")+tempSum);
        }
        ans+=sum;
        System.out.println(ans);
    }

    public void showNegativeCustomers(Map<String, Double> customersIncome){
        for (Map.Entry<String, Double> customer: customersIncome.entrySet()){
            if(customer.getValue()<0) System.out.println(customer.getKey()+": "+customer.getValue());
        }
    }

    public void showTopFiveCustomers(Map<String, Double> customersIncome){
        Map<String,Double>tempCustomersIncome=customersIncome;
        String topCustomer="";
        double topIncome=0;
        int frst=1;
        int count=tempCustomersIncome.size();
        for(int i=0;i<((tempCustomersIncome.size()>5)?(5):(5-(5-count)));i++){
            for (Map.Entry<String, Double> customer: tempCustomersIncome.entrySet()){
                if(frst==1){
                    topCustomer=customer.getKey();
                    topIncome=customer.getValue();
                    frst--;
                }
                if(customer.getValue()>topIncome) {
                    topCustomer=customer.getKey();
                    topIncome=customer.getValue();
                }
            }
            tempCustomersIncome.remove(topCustomer);
            System.out.println(topCustomer+": "+topIncome);
            frst=1;
        }
    }

    public void showTopServices(Map<String, Double> servicesIncome, Map<String, String> language){
        Map<String, Double>tempServiceIncome=servicesIncome;
        int frst=1;
        String topService="";
        double topIncome=0;
        int count=tempServiceIncome.size();
        for(int i=0;i<count;i++){
            for(Map.Entry<String,Double> service:tempServiceIncome.entrySet()) {
                if (frst == 1) {
                    topService = service.getKey();
                    topIncome = service.getValue();
                    frst--;
                }
                if (service.getValue() > topIncome) {
                    topService = service.getKey();
                    topIncome = service.getValue();
                }
            }
            tempServiceIncome.remove(topService);
            System.out.println(language.get(topService)+": "+topIncome);
            frst=1;
        }
    }
}
