package com.vti.frontend;

public class Program2 {
    public static void main(String[] args) {
        int [] numbers = {1, 2, 3};
        try {
            System.out.println(numbers[10]);
        }catch (Exception e){
            System.out.println("Chi so phan tu vuot qua chi so mang");
        }
    }
}
