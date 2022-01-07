package com.company;

import java.util.Arrays;

public class InputSort extends Sort{
    public InputSort(){
        super();
    }

    public void run() {
        try {
            for(int i=1;i<row.length;i++){
                int x=row[i];
                int j=i;
                while(j>0&&row[j-1]>x){
                    sleep(6);
                    row[j]=row[j-1];
                    j--;
                }
                row[j]=x;
                showRow();
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
