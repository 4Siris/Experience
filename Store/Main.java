package com.company;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        new MainFrame();
    }
}
