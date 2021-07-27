package com.vti.frontend;

import java.util.Scanner;

public class Program4 {
    public static void main(String[] args) {
        // a, b
        Scanner scanner = new Scanner(System.in);
        Student student1 = new Student(1, 0);
        System.out.print("Nhap ten: ");
        String name1 = scanner.nextLine();
        student1.setName(name1);
        System.out.print("Nhap hometown: ");
        String hometown1 = scanner.nextLine();
        student1.setHomeTown(hometown1);
        System.out.println(student1.printInfo());

        // c
        Student student2 = new Student();
        System.out.println("Nhap diem: ");
        int diem = scanner.nextInt();
        student2.setGpa(diem);
        System.out.println("Diem: " + student2.getGpa());

        //d
        System.out.println("Nhap diem cong: ");
        int diemCong = scanner.nextInt();
        student2.addGpa(diemCong);
        System.out.println("Diem sau cong: " + student2.getGpa());

        //e
        System.out.println(student1.printInfo());
    }
}
