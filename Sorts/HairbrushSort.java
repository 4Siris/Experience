package com.company;

public class HairbrushSort extends Sort{
    private int[] array;

    public HairbrushSort(int[] array){
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
            final double factor = 1.247;
            double step = array.length - 1;
            while (step >= 1) {
                for (int i = 0; (int)(i + step) < array.length; i++) {
                    sleep(2);
                    if (array[i] > array[(int) (i + step)]) {
                        sleep(4);
                        int temp = array[i];
                        array[i] = array[(int) (i + step)];
                        array[(int) (i + step)] = temp;
                    }
                }
                step /= factor;
            }
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
