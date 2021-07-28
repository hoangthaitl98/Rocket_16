package com.vti.frontend;

public class Question1Question2 {
    public static void main(String[] args) {
        try {
            float result = divide(7,1);
            System.out.println(result);
        }catch (Exception e){
            System.out.println("Khong the chia cho 0");
        }finally {
            System.out.println("Divide complete");
        }
    }

    private static float divide(int a, int b) {
        return a / b;
    }
}
