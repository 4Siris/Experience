package com.company;

public class BankAccount {
    private static int id;
    private int currentId;
    private int sumHigh;
    private int sumLow;
    private currency currency;
    private String FIO;
    private String passportId;
    private Address address;

    public BankAccount(int sumHigh, int sumLow, com.company.currency currency, String FIO, String passportId, Address address) throws Exception {
        id=id+1;
        currentId=id;
        if(sumHigh>=0)this.sumHigh = sumHigh+sumLow/100;
        if(sumLow>=0)this.sumLow = sumLow%100;
        this.currency = currency;
        this.FIO = FIO;
        if(passportId.length()!=9)throw new Exception("Неправильный ввод паспорта!");
            else if(checkPassportId(passportId))this.passportId = passportId;
            else throw new Exception("Неправильный ввод паспорта!");
        this.address = address;
    }

    public void addSum(int sumHigh, int sumLow){
        this.sumLow+=sumLow;
        this.sumHigh+=sumLow/100;
        this.sumHigh+=sumHigh;
    }

    public void takeSum(int sumHigh, int sumLow) throws Exception {
        Exception notEnoughMoney=new Exception("Недостаточно стредств");
        sumHigh+=sumLow/100;
        if(sumHigh>this.sumHigh)throw notEnoughMoney;
        else{
            if(sumHigh==this.sumHigh){
                if(sumLow>this.sumLow)throw  notEnoughMoney;
                else {
                    this.sumHigh=0;
                    this.sumLow-=sumLow;
                }
            }
            if(sumLow>this.sumLow){
                this.sumLow+=100;
                this.sumLow-=sumLow;
                this.sumHigh-=sumHigh+1;
            }
        }
    }

    public boolean checkPassportId (String passportId) throws Exception {
        String[] rightSymbols=("E T Y O P H K X C B M").split(" ");
        char[] digits= {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        boolean ans=false;
        Exception incorrectPassport=new Exception("Неправильный ввод паспорта!");
        for(int i=0;i<rightSymbols.length;i++){
            ans=ans||(passportId.indexOf(rightSymbols[i])==0);
        }
        if(ans){
            ans=false;
            for (int i=0;i<rightSymbols.length;i++){
                ans=ans||(passportId.indexOf(rightSymbols[i],1)==1);
            }
            if(ans){
                ans=true;
                for (int i=2;i<passportId.length();i++){
                    boolean checkDigit=false;
                    for(int j=0;j<digits.length;j++){
                        checkDigit=checkDigit||(passportId.charAt(i)==digits[j]);
                    }
                    if(!checkDigit)throw incorrectPassport;
                }
                return true;
            }else throw incorrectPassport;
        }else throw incorrectPassport;
    }

    @Override
    public String toString() {
        String ID=String.format("%07d",currentId);
        return  "ID: "+ ID + "\n" +
                "Сумма: " + sumHigh +"." + sumLow +" " + currency + "\n" +
                "ФИО: " + FIO + '\n' +
                "ID паспорта: " + passportId + '\n' +
                "Адресс: " + address;
    }
}
