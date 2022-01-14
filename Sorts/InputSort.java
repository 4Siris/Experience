package com.company;

public class InputSort extends Sort{
    private int[] array;

    public InputSort(int[] array){
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
            for(int i=1;i<array.length;i++){
                int x=array[i];
                int j;
                for(j=i;j>0;j--){
                    sleep(2);
                    if(array[j-1]<=x)break;
                    sleep(4);
                    array[j]=array[j-1];
                }
                sleep(4);
                array[j]=x;
            }
            interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
