package com.company;

import java.util.HashMap;
import java.util.Map;

public final class Localization {
    private static Localization instance;
    private Map<String, Map<String, String>> languages;

    public Map<String, Map<String, String>> getLanguages() {
        return languages;
    }

    private Localization(){
        languages=new HashMap<>();
        Map<String, String>language=new HashMap<>();
        language.put("Доход компании", "Доход компании");
        language.put("ShowData", "Показать данные");
        language.put("Regression", "Регрессия");
        language.put("NeuralNetwork", "Нейронная сеть");
        language.put("AutoSystem", "Автоматизированная система");
        languages.put("RU",language);
        language=new HashMap<>();
        language.put("Доход компании", "Company income");
        language.put("ShowData", "Show data");
        language.put("Regression", "Regression");
        language.put("NeuralNetwork", "Neural network");
        language.put("AutoSystem", "Auto system");
        languages.put("EN",language);
        language=new HashMap<>();
        language.put("Доход компании", "Revni konpayi an");
        language.put("ShowData", "Мontre done yo");
        language.put("Regression", "Regression");
        language.put("NeuralNetwork", "Rezo neral");
        language.put("AutoSystem", "Sistèm otomatik");
        languages.put("HT",language);
    }

    public static Localization getInstance(){
        if(instance==null){
            instance=new Localization();
        }
        return instance;
    }
}
