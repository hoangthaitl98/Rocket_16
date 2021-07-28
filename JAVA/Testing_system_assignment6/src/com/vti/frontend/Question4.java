package com.vti.frontend;

import com.vti.entity.Department;

import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Department [] departments = new Department[3];
        departments[0] = new Department(1, "Sale");
        departments[1] = new Department(2, "Nhan su");
        departments[2] = new Department(3, "Bao ve");
        System.out.println("Nhap index: ");
        int index = input.nextInt();
        getIndex(departments, index - 1);
    }

    public static void getIndex(Department[] departments, int index){
        try{
            System.out.println(departments[index].toString());
        }catch (Exception e){
            System.out.println("Cannot find department.");
        }
    }
}
