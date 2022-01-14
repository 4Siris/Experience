package com.company;

public class NewRandomSort extends Sort{
    private int[] array;

    public NewRandomSort(int[] array){
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
        newRandomSort();
        interrupt();
    }

    public void newRandomSort() {
        try {
            int tempInd = 0;
            do {
                int count = 0;
                for (int i = tempInd; i < array.length; i++) {
                    if (array[tempInd] <= array[i]) {
                        Thread.sleep(2);
                        count++;
                    }
                }
                if (count == array.length - tempInd) tempInd++;
                else {
                    int ind = (int) (tempInd + (Math.random() * (array.length - tempInd)));
                    sleep(4);
                    int temp = array[ind];
                    array[ind] = array[tempInd];
                    array[tempInd] = temp;
                }
            } while (tempInd != array.length - 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
