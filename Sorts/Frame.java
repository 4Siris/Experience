package com.company;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Frame extends JPanel implements Runnable{
    JFrame jFrame;
    Thread thread;
    InputSort sort1;
    QuickSort sort2;
    NewRandomSort sort3;
    BubbleSort sort4;
    HairbrushSort sort5;
    ShakeSort sort6;

    Frame(int[] array) throws InterruptedException {
        thread=new Thread(this);
        sort1=new InputSort(array);
        sort2=new QuickSort(array);
        sort3=new NewRandomSort(array);
        sort4=new BubbleSort(array);
        sort5=new HairbrushSort(array);
        sort6=new ShakeSort(array);
        windowFrom();
        thread.start();
        sort1.start();
        sort2.start();
        sort3.start();
        sort4.start();
        sort5.start();
        sort6.start();
        Thread.sleep(60000);
        sort1.interrupt();
        sort2.interrupt();
        sort3.interrupt();
        sort4.interrupt();
        sort5.interrupt();
        sort6.interrupt();
        thread.interrupt();
    }

    public void paint(Graphics a) {
        a.clearRect(0, 0, 1800,1000);
        for (int i = 0; i < 100; i++) {
            a.setColor(Color.BLACK);
            a.fillRect(i*6,(500-(sort1.getElement(i)*4)),6, sort1.getElement(i)*4);
        }
        for (int i = 0; i < 100; i++) {
            a.setColor(Color.BLACK);
            a.fillRect(600+i*6,(500-(sort2.getElement(i)*4)),6, sort2.getElement(i)*4);
        }
        for (int i = 0; i < 100; i++) {
            a.setColor(Color.BLACK);
            a.fillRect(1200+i*6,(500-(sort3.getElement(i)*4)),6, sort3.getElement(i)*4);
        }
        for (int i = 0; i < 100; i++) {
            a.setColor(Color.BLACK);
            a.fillRect(i*6,(1000-(sort4.getElement(i)*4)),6, sort4.getElement(i)*4);
        }
        for (int i = 0; i < 100; i++) {
            a.setColor(Color.BLACK);
            a.fillRect(600+i*6,(1000-(sort5.getElement(i)*4)),6, sort5.getElement(i)*4);
        }
        for (int i = 0; i < 100; i++) {
            a.setColor(Color.BLACK);
            a.fillRect(1200+i*6,(1000-(sort6.getElement(i)*4)),6, sort6.getElement(i)*4);
        }
    }

    public void windowFrom() {
        jFrame = new JFrame();
        jFrame.setSize(1850,1100);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(this);
        jFrame.setVisible(true);
    }

    public void run() {
        try {
            while (!thread.isInterrupted()) {
                repaint();
                thread.sleep(2);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}