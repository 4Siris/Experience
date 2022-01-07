package com.company;

import java.util.Arrays;

public class BubbleSort extends Sort{
    public BubbleSort(){
        super();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i + 1 < row.length; i++) {
                for (int j = 0; j + 1 < row.length - i; j++) {
                    sleep(2);
                    if (row[j] > row[j + 1]) {
                        sleep(4);
                        int temp = row[j];
                        row[j] = row[j + 1];
                        row[j + 1] = temp;
                        showRow();
                    }
                }
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
