package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Downloader {
    public static String DownloadInput(String fileName) throws FileNotFoundException {
        Scanner fin = new Scanner(new FileReader(fileName));
        String input="";
        while (fin.hasNextLine()){
            input+= fin.nextLine()+'\n';
        }
        return input;
    }
}
