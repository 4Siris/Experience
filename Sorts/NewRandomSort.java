package com.company;

import java.util.Arrays;

public class NewRandomSort extends Sort{
    public NewRandomSort(){
        super();
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
                for (int i = tempInd; i < row.length; i++) {
                    if (row[tempInd] <= row[i]) {
                        sleep(2);
                        count++;
                    }
                }
                if (count == row.length - tempInd) tempInd++;
                else {
                    int ind = (int) (tempInd + (Math.random() * (20 - tempInd)));
                    sleep(4);
                    int temp = row[ind];
                    row[ind] = row[tempInd];
                    row[tempInd] = temp;
                    showRow();
                }
            } while (tempInd != row.length - 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showRow() {
        System.out.println(Arrays.toString(row));
    }
}
