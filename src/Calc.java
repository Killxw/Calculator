

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Calc {
    public static void main(String[] args) throws IOException {
        System.out.println("Напишите уравнение:");
        Scanner s = new Scanner(System.in);
        String urav = s.nextLine();
        urav = urav.replaceAll("\\s+", "");
        String uravUpper = urav.toUpperCase();
        int plus = 0;
        int minus = 0;
        int mnozh = 0;
        int razd = 0;
        for (char element : urav.toCharArray()) {
            if (element == '+') plus++;
            if (element == '-') minus++;
            if (element == '/') razd++;
            if (element == '*') mnozh++;
        }
        if (plus + minus + mnozh + razd != 1) {
            throw new IOException();
        }
        String  [] numbers = uravUpper.split("[+\\-*/]");
        int k=0;
        for (char element : uravUpper.toCharArray()){
            if(element=='I') k++;
            if(element=='V') k++;
            if(element=='X') k++;
        }
        int numArab1;
        int numArab2;
        if(k>0){
            ConvertToRoman num1 = new ConvertToRoman();
            ConvertToRoman num2 = new ConvertToRoman();
            num1.roman = numbers[0];
            numbers[0] = num1.convert();
            num2.roman = numbers[1];
            numbers[1] = num2.convert();
        }
        int[] chisla = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
        if (k == 0) {
        } else for (char c : urav.toCharArray()) {
           if (Character.isDigit(c)) {
                throw new IOException();
           }
        }
        if(chisla[0]>10){
            throw new IOException();
        }
        if(chisla[0]<0){
            throw new IOException();
        }
        if(chisla[1]<0){
            throw new IOException();
        }
        if(chisla[1]>10){
            throw new IOException();
        }
        int destv = 0;
        if(plus>0){
            destv=1;
        }else if(minus>0){
            destv=2;
        }else if(razd>0){
            destv=3;
        }else if(mnozh>0){
            destv=4;
        }
        int reshenie=0;
        switch (destv){
            case 1 :
                reshenie = chisla[0]+chisla[1];
                break;
            case 2 :
                reshenie = chisla[0]-chisla[1];
                break;
            case 3 :
                reshenie = chisla[0]/chisla[1];
                break;
            case 4 :
                reshenie = chisla[0]*chisla[1];
                break;
        }
        if((k>0)&&(reshenie<=0)){
            throw new IOException();
        }
        StringBuffer otvet = new StringBuffer("");
        if(k>0){
            int c1=reshenie/100;
            for(int i=0;i<c1;i++){
            otvet.append("C");
            }
            int c2=reshenie%100;
            int l1=c2/50;
            if(c2==90){
                otvet.append("XC");
            }else
            for(int i=0;i<l1;i++){
                otvet.append("L");
            }
            int l2=c2%50;
            int x1=l2/10;
            if(c2==90){
            }else
            for(int i=0;i<x1;i++){
                otvet.append("X");
            }
            int g=l2%10;
            switch (g){
                case 0:
                break;
                case 1:
                    otvet.append("I");
                    break;
                case 2:
                    otvet.append("II");
                    break;
                case 3:
                    otvet.append("III");
                    break;
                case 4:
                    otvet.append("IV");
                    break;
                case 5:
                    otvet.append("V");
                    break;
                case 6:
                    otvet.append("VI");
                    break;
                case 7:
                    otvet.append("VII");
                    break;
                case 8:
                    otvet.append("VIII");
                    break;
                case 9:
                    otvet.append("IX");
                    break;
            }
            System.out.println(otvet);
        }else System.out.println(reshenie);
    }
}
class ConvertToRoman {
    String roman;
    String convert() {
        if (roman.equals("I")) return "1";
        if (roman.equals("II")) return "2";
        if (roman.equals("III")) return "3";
        if (roman.equals("IV")) return "4";
        if (roman.equals("V")) return "5";
        if (roman.equals("VI")) return "6";
        if (roman.equals("VII")) return "7";
        if (roman.equals("VIII")) return "8";
        if (roman.equals("IX")) return "9";
        if (roman.equals("X")) return "10";
        return "0";
    }
}






