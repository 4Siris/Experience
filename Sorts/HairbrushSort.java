package com.company;

import java.util.Arrays;

public class HairbrushSort extends Sort{
    public HairbrushSort(){
        super();
    }

    public void run() {
        try {
            final double factor = 1.247;
            double step = row.length - 1;
            while (step >= 1) {
                for (int i = 0; (int)(i + step) < row.length; i++) {
                    sleep(2);
                    if (row[i] > row[(int) (i + step)]) {
                        sleep(4);
                        int temp = row[i];
                        row[i] = row[(int) (i + step)];
                        row[(int) (i + step)] = temp;
                        showRow();
                    }
                }
                step /= factor;
            }
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
