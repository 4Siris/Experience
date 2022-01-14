package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int row[]=new int[100];
        for (int i = 0; i < 100; i++) {
            row[i] = i + 1;
        }
        for (int i = 0; i < 100; i++) {
            int temp = row[i];
            int j = (int)(Math.random()*100);
            if (i != j) {
                row[i] = row[j];
                row[j] = temp;
            }
        }
        Frame frame=new Frame(row);
    }
}
