package com.company;

public class ShakeSort extends Sort{
    private int[] array;

    public ShakeSort(int[] array){
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
            int left=0;
            int right=array.length-1;
            while (left<=right){
                for(int i=right;i>left;i--){
                    sleep(2);
                    if(array[i-1]>array[i]){
                        sleep(4);
                        int temp=array[i];
                        array[i]=array[i-1];
                        array[i-1]=temp;
                    }
                }
                left++;
                for(int i=left;i<right;i++){
                    sleep(2);
                    if(array[i]>array[i+1]){
                        sleep(4);
                        int temp=array[i];
                        array[i]=array[i+1];
                        array[i+1]=temp;
                    }
                }
                right--;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
