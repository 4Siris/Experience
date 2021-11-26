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
        languages.put("RU",language);
        language=new HashMap<>();
        language.put("Доход компании", "Company income");
        languages.put("EN",language);
        language=new HashMap<>();
        language.put("Доход компании", "Revni konpayi an");
        languages.put("HT",language);
    }

    public static Localization getInstance(){
        if(instance==null){
            instance=new Localization();
        }
        return instance;
    }
}
