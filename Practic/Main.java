package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        BankAccount check =new BankAccount(76,12,currency.USD,"Войнов Леонид Михайлович", "ET1234567", new Address());
        BankAccount check2 =new BankAccount(76,12,currency.BYN,"Войнов Леонид Михайлович", "ET1234567", new Address());
        System.out.println(check);
        System.out.println(check2);
    }


}
enum currency{
    BYN(2.5),
    USD(1),
    EUR(0.88);
    private double k;
    private currency(double k){
        this.k=k;
    }
    public static double convert(currency from,currency to, double amount){
        return amount/from.k*to.k;
    }
}