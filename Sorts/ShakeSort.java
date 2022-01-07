package com.company;

import java.util.Arrays;

public class ShakeSort extends Sort{
    public ShakeSort(){
        super();
    }

    public void run() {
        try {
            int left=0;
            int right=row.length-1;
            while (left<=right){
                for(int i=right;i>left;i--){
                    sleep(2);
                    if(row[i-1]>row[i]){
                        sleep(4);
                        int temp=row[i];
                        row[i]=row[i-1];
                        row[i-1]=temp;
                        showRow();
                    }
                }
                left++;
                for(int i=left;i<right;i++){
                    sleep(2);
                    if(row[i]>row[i+1]){
                        sleep(4);
                        int temp=row[i];
                        row[i]=row[i+1];
                        row[i+1]=temp;
                        showRow();
                    }
                }
                right--;
            }
            interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showRow() {
        System.out.println(Arrays.toString(row));
    }
}
