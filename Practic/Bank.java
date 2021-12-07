package com.company;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Bank {
    private Set<BankAccount> bankAccounts;

    public Bank(){
        bankAccounts=new HashSet<>();
    }
    public Bank(HashSet<BankAccount> bankAccounts){
        this.bankAccounts=bankAccounts;
    }

    public Scanner sin=new Scanner(System.in);

    public void registration() throws Exception {
        String ans="-";
        String FIO;
        String passportId;
        Address address;
        do {
            System.out.println("Введите ФИО: ");
            FIO = sin.nextLine();
            System.out.println("Где вы проживаете?");
            System.out.println("Страна: ");
            String country = sin.nextLine();
            System.out.println("Область: ");
            String region = sin.nextLine();
            System.out.println("Район: ");
            String district = sin.nextLine();
            System.out.println("Улица: ");
            String street = sin.nextLine();
            System.out.println("Дом: ");
            int house = sin.nextInt();
            System.out.println("Квартира(если нету впишите -): ");
            String flat = sin.nextLine();
            if (flat.equals("-")) flat = "0";
            int flatNum = Integer.parseInt(flat);
            System.out.println("ID паспорта");
            passportId=sin.nextLine();
            address = new Address(country, region, district, street, house, flatNum);
            System.out.println("Всё верно(+/-)?");
            System.out.println(address);
            ans=sin.next();
        }while (!ans.equals("+"));
        System.out.println("В какой валюте будете хранить деньги(BYN/USD/EUR)?");
        String cur=sin.nextLine();
        BankAccount bankAccount=null;
        switch (cur.toLowerCase(Locale.ROOT).trim()){
            case "byn":
                bankAccount = new BankAccount(0,0,currency.BYN,FIO,passportId,address);
                break;
            case "usd":
                bankAccount = new BankAccount(0,0,currency.USD,FIO,passportId,address);
                break;
            case "eur":
                bankAccount = new BankAccount(0,0,currency.EUR,FIO,passportId,address);
                break;
            default:
                break;
        }
        bankAccounts.add(bankAccount);
    }
}
