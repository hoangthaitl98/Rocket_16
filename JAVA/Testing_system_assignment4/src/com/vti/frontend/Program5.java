package com.vti.frontend;

import java.util.ArrayList;
import java.util.Scanner;

public class Program5 {
    public static void main(String[] args) {
        ArrayList<CanBo> canBoArrayList = new ArrayList<CanBo>();
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Them moi can bo");
            System.out.println("2. Tim kiem theo ho ten");
            System.out.println("3. Hien thi danh sach can bo");
            System.out.println("4. Xoa can bo");
            System.out.println("5. Thoat");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    addCanBo(canBoArrayList);
                    break;
                case 2:
                    searchCanBo(canBoArrayList);
                    break;
                case 3:
                    displayList(canBoArrayList);
                    break;
                case 4:
                    deleteCanBo(canBoArrayList);
                    break;
                default:
                    break;
            }
        } while (choice >= 1 && choice <= 4);
    }

    //a
    public static void addCanBo(ArrayList<CanBo> listCanBo) {
        Scanner input = new Scanner(System.in);
        CanBo canBo = new CanBo();
        System.out.print("Nhap ho ten: ");
        String name = input.nextLine();
        canBo.setHoTen(name);
        System.out.print("Nhap tuoi: ");
        int age = input.nextInt();
        canBo.setTuoi(age);
        System.out.print("Nhap gioi tinh: ");
        String sex = input.nextLine();
        CanBo.gioiTinh sexType = CanBo.gioiTinh.valueOf(sex);
        canBo.setSex(sexType);
        System.out.print("Nhap dia chi: ");
        String address = input.nextLine();
        canBo.setDiaChi(address);
        listCanBo.add(canBo);
        input.close();
    }

    //b
    public static void searchCanBo(ArrayList<CanBo> listCanBo) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ten can tim: ");
        String nameSearch = input.nextLine();
        for (int i = 0; i < listCanBo.size(); i++) {
            if (listCanBo.get(i).getHoTen() == nameSearch) {
                System.out.println("Tim thay");
                break;
            }
        }
    }

    //c
    public static void displayList(ArrayList<CanBo> listCanBo) {
        for (int i = 0; i < listCanBo.size(); i++) {
            System.out.println(listCanBo.get(i).toString());
        }
    }

    //d
    public static void deleteCanBo(ArrayList<CanBo> listCanBo) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ten can xoa: ");
        String nameSearch = input.nextLine();
        for (int i = 0; i < listCanBo.size(); i++) {
            if (listCanBo.get(i).getHoTen() == nameSearch) {
                listCanBo.remove(i);
                System.out.println("Da xoa");
                break;
            }
        }
    }
}
