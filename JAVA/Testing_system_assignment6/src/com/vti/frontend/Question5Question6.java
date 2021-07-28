package com.vti.frontend;

import java.util.Scanner;

public class Question5Question6 {
    public static void main(String[] args) {
        inputAge();
    }

    public static void inputAge(){
        int stop = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("Nhap 1 so: ");
            String age = input.nextLine();
            try{
                Integer.parseInt(age);
                if (Integer.parseInt(age) < 0){
                    System.out.println("Wrong inputing! The age must be greater than 0, please input again.");
                }
                else stop++;
            }catch (Exception e){
                System.out.println("wrong inputing! Please input an age as int, input again.");
            }
        }while (stop == 0);
    }

}
