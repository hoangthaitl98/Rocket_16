package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputString(String errorMessage) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            else{
                System.out.println(errorMessage);
            }
        }
    }

    public static int inputInt(String errorMessage){
        while (true) {
            int input = scanner.nextInt();
            try{
                return Integer.parseInt(scanner.nextLine().trim());
            }
            catch (Exception e){
                System.out.println(errorMessage);
            }
        }
    }

    public static String inputString(){
        return inputString("Invalid, please input again");
    }

    public static int inputInt(){
        return inputInt("Invalid, please input again");
    }
}
