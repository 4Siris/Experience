package com.company;

public class QuickSort extends Sort{
    private int[] array;

    public QuickSort(int[] array){
        this.array=new int[array.length];
        for(int i=0;i<array.length;i++)
        {
            this.array[i]=array[i];
        }
    }

    public int getElement(int i){
        return array[i];
    }

    public void run() {
        quickSortPart(0,99);
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
            int x = array[to];
            int begin = from;
            for (int i = from; i < to; i++) {
                sleep(2);
                if (array[i] <= x) {
                    sleep(4);
                    int temp = array[i];
                    array[i]=array[begin];
                    array[begin]=temp;
                    begin++;
                }
            }
            sleep(4);
            int temp = array[to];
            array[to]=array[begin];
            array[begin]=temp;
            return begin;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
