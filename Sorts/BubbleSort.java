package com.company;

public class BubbleSort extends Sort{
    private int[] array;

    public BubbleSort(int[] array){
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
        try {
            for (int i = 0; i + 1 < array.length; i++) {
                for (int j = 0; j + 1 < array.length - i; j++) {
                    sleep(2);
                    if (array[j] > array[j + 1]) {
                        sleep(4);
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
            interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
