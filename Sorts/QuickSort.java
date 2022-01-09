package com.company;

import java.util.Arrays;

public class QuickSort extends Sort{
    public QuickSort(){
        super();
    }

    public void run() {
        quickSortPart(0,row.length-1);
        interrupt();
    }

    public void quickSortPart(int from,int to){
        if(from<to){
            int q=processing(from,to);
            quickSortPart(from,q-1);
            quickSortPart(q+1,to);
        }
    }

    public int processing(int from,int to) {
        try {
            int x = row[to];
            int begin = from;
            for (int i = from; i < to; i++) {
                if (row[i] <= x) {
                    sleep(6);
                    int temp = row[i];
                    row[i] = row[begin];
                    row[begin] = temp;
                    begin++;
                    showRow();
                }
            }
            sleep(6);
            int temp = row[to];
            row[to] = row[begin];
            row[begin] = temp;
            showRow();
            return begin;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void showRow() {
        System.out.println(Arrays.toString(row));
    }
}
