package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String input=Downloader.DownloadInput("C:/Users/Admin/IdeaProjects/Taxes/src/com/company/Input.txt");
        System.out.println(input);
        List<Service>serviceList=new ArrayList<>();
        String[] services=input.split("\n");
        for(int i=0;i<services.length;i++){
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
        System.out.println(serviceList);
    }
}
