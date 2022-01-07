package com.company;

public  abstract class Sort extends Thread{
    public int[] row=new int[20];
    public Sort(){
        for(int i=0;i<row.length;i++)row[i]=(int)((Math.random()*20)+1);
    }

    public abstract void showRow();
}
