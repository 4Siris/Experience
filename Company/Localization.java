package com.company;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public final class Localization {
    private static Localization instance;
    private Map<String, Map<String, String>> languages;

    public Map<String, Map<String, String>> getLanguages() {
        return languages;
    }

    private Localization(String fileName) throws FileNotFoundException {
        languages=new HashMap<>();
        String[] sentences=Downloader.downloadLocalization(fileName).split("\n");
        Map<String, String>language;
        for(int i=0;i<sentences.length/6;i++)
        {
            language=new HashMap<>();
            for(int j=1;j<6;j++) {
                language.put(sentences[6 * i + j].split("-")[0], sentences[6 * i + j].split("-")[1]);
            }
            languages.put(sentences[6*i],language);
        }
    }

    public static Localization getInstance(String languageFile) throws FileNotFoundException {
        if(instance==null){
            instance=new Localization(languageFile);
        }
        return instance;
    }
}
