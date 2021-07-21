package TestingSystem;

import java.util.Locale;
import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        //question1();
        //question2();
        //question3();
        //quesiton4();
        //question5();
        //question6();
        question7();
    }

    public static void question1() {
        int count = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap xau: ");
        String inputString = input.nextLine();
        if (inputString.charAt(0) != ' ')
            count++;
        for (int i = 0; i < inputString.length() - 1; i++) {
            if (inputString.charAt(i) == ' ' && inputString.charAt(i + 1) != ' ') {
                count++;
            }
        }
        System.out.println("Xau co " + count + " tu");
    }

    public static void question2() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap xau 1: ");
        String xau1 = input.nextLine();
        System.out.print("Nhap xau 2: ");
        String xau2 = input.nextLine();
        System.out.print("Xau sau khi ghep: " + xau1.concat(xau2));
    }

    public static void question3() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ten: ");
        String name = input.nextLine();

        String first = name.substring(0, 1).toUpperCase();
        String remain = name.substring(1);
        name = first + remain;
        System.out.println(name);
    }

    public static void quesiton4() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ten: ");
        String name = input.nextLine();
        for (int i = 0; i < name.length(); i++) {
            System.out.println("Ki tu " + i + ": " + Character.toUpperCase(name.charAt(i)));
        }
    }

    public static void question5() {
        Scanner input = new Scanner(System.in);
        String ho, ten;
        System.out.print("Nhap ho: ");
        ho = input.nextLine();
        System.out.print("Nhap ten: ");
        ten = input.nextLine();
        System.out.println("Ho va ten: " + ho.concat(ten));
    }

    public static void question6() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ho va ten: ");
        String fullName = input.nextLine();
        String[] word = fullName.split(" ");
        String ho = word[0];
        String dem = "";
        for (int i = 1; i < word.length - 1; i++) {
            dem += word[i] + " ";
        }
        String ten = word[word.length - 1];
        System.out.println("Ho: " + ho);
        System.out.println("Ten dem: " + dem);
        System.out.println("Ten: " + ten);
    }

    public static void question7() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ten: ");
        String fullName = input.nextLine();
        fullName = fullName.trim();
        String[] word = fullName.split(" ");
        String temp = "";
        for (int i = 0; i < word.length; i++) {
            temp += String.valueOf(word[i].charAt(0)).toUpperCase() + word[i].substring(1);
            if (i < word[i].length() - 1) {
                temp += " ";
            }
        }
        System.out.println("Ho va ten: " + temp);
    }
}
