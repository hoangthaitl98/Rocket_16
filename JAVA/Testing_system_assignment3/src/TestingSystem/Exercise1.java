package TestingSystem;

import java.util.Random;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        question1();
        System.out.println("Question 2 \n" + quesiton2() + "\n");
        System.out.println("Question 3 \n" + question3() + "\n");
        System.out.println(question4());
    }

    public static void question1(){
        System.out.println("Question 1");
        double luongAccount1 = 5240.5;
        double luongAccount2 = 10970.055;

        System.out.println("Luong Account 1: " + (int)luongAccount1);
        System.out.println("Luong Account 2: " + (int)luongAccount2);
        System.out.println();
    }

    public static String quesiton2(){
        Random generator = new Random();
        int random = generator.nextInt(99999);
        String soRanDom = Integer.toString(random);
        if (random < 10000){
            return ("0" + soRanDom);
        } else if (random < 1000){
            return("00" + soRanDom);
        } else if (random < 100){
            return("000" + soRanDom);
        } else if (random < 10){
            return("0000" + soRanDom);
        } else{
            return soRanDom;
        }
    }

    public static int question3(){
        int soRanDom = Integer.parseInt(quesiton2());
        return (soRanDom % 100);
    }

    public static int question4(){
        System.out.println("Question 4");
        Scanner input = new Scanner(System.in);
        int tuSo, mauSo;
        System.out.println("Nhap tu so: ");
        tuSo = input.nextInt();
        System.out.println("Nhap mau so: ");
        mauSo = input.nextInt();
        return tuSo/mauSo;
    }
}
