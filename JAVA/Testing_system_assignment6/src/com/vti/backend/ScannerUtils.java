package com.vti.backend;

import java.util.Scanner;

public class ScannerUtils {
    public int inputInt(String a, String errorMessage){
        int stop = 0;
        while (true){
            try{
                Integer.parseInt(a);
                if (Integer.parseInt(a) < 0){
                    System.out.println(errorMessage);
                }
                return Integer.parseInt(a);
            }catch (Exception e){
                System.out.println(errorMessage);
            }
        }
    }
}
