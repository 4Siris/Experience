package com.company;

import java.util.Scanner;

public class Digits {
    public static Scanner sin=new Scanner(System.in);
    public Digits(){
        int number=0;
        String ans="";
        do {
            System.out.println("Введите число");
            if(sin.hasNextInt()){
                number=sin.nextInt();
                break;
            }else {
                System.out.println("Надо ввести целое число");
            }
        }while (true);
        boolean isNegative=number<0;
        number=Math.abs(number);
        do {
            int digit=number%10;
            switch (digit){
                case 1:
                    ans=Digit.ONE.digit+ans;
                    break;
                case 2:
                    ans=Digit.TWO.digit+ans;
                    break;
                case 3:
                    ans=Digit.THREE.digit+ans;
                    break;
                case 4:
                    ans=Digit.FOUR.digit+ans;
                    break;
                case 5:
                    ans=Digit.FIVE.digit+ans;
                    break;
                case 6:
                    ans=Digit.SIX.digit+ans;
                    break;
                case 7:
                    ans=Digit.SEVEN.digit+ans;
                    break;
                case 8:
                    ans=Digit.EIGHT.digit+ans;
                    break;
                case 9:
                    ans=Digit.NINE.digit+ans;
                    break;
                case 0:
                    ans=Digit.ZERO.digit+ans;
                    break;
                default:
                    break;
            }
            number/=10;
        }while (number!=0);
        if(isNegative)ans=("     \n     \n ### \n     \n     \n"+ans);
        System.out.println(ans);
    }
    enum Digit{ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, ZERO;
        String digit;
        private Digit(){
            switch (this.name()){
                case "ONE":
                    digit="  #  \n ##  \n# #  \n  #  \n#####\n";
                    break;
                case "TWO":
                    digit=" ### \n#   #\n   # \n  #  \n#####\n";
                    break;
                case "THREE":
                    digit=" ### \n#   #\n  ## \n#   #\n ### \n";
                    break;
                case "FOuR":
                    digit="#   #\n#   #\n#####\n    #\n    #\n";
                    break;
                case "FIVE":
                    digit="#####\n#    \n#####\n    #\n#####\n";
                    break;
                case "SIX":
                    digit="#####\n#    \n#####\n#   #\n#####\n";
                    break;
                case "SEVEN":
                    digit="#####\n   # \n  #  \n #   \n #   \n";
                    break;
                case "EIGHT":
                    digit="#####\n#   #\n#####\n#   #\n#####\n";
                    break;
                case "NINE":
                    digit="#####\n#   #\n#####\n    #\n#####\n";
                    break;
                case "ZERO":
                    digit="#####\n#   #\n#   #\n#   #\n#####\n";
                    break;
                default:
                    break;
            }
        }
        public String toString(){
            return digit;
        }
    }
}
