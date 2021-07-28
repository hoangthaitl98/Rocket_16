package com.vti.backend;

import java.util.Scanner;

public class ScannerUtils {
    private static Scanner input = new Scanner(System.in);

    public static int inputInt() {
        while (true){
            try {
                return Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("wrong inputing! Please input an age as int, input again.");
            }
        }
    }

    public static float inputFloat() {
        while (true){
            try {
                return Float.parseFloat(input.nextLine());
            } catch (Exception e) {
                System.out.println("wrong inputing! Please input an age as int, input again.");
            }
        }
    }

    public static double inputDouble() {
        while (true){
            try {
                return Double.parseDouble(input.nextLine());
            } catch (Exception e) {
                System.out.println("wrong inputing! Please input an age as int, input again.");
            }
        }
    }

    public static String inputString(){
        String a = input.nextLine();
        while (a.isEmpty()){
            System.out.println("Input again: ");
            a = input.nextLine();
        }
        return a;
    }
}
