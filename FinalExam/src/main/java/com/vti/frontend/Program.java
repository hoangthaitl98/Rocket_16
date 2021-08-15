package com.vti.frontend;

import com.vti.backend.presentationlayer.AccountController;

import javax.swing.*;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        AccountController controller;
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Hien thi account");
            System.out.println("2. Them account moi");
            System.out.println("3. Tim account theo id");
            System.out.println("4. Kiem tra account co ton tai");
            System.out.println("5. Cap nhat account");
            System.out.println("6. Xoa account");
            System.out.printf("Nhap lua chon: ");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    controller = new AccountController();
                    for (int i = 0; i < controller.getListAccount().size(); i++) {
                        System.out.println(controller.getListAccount().get(i).toString());
                    }
                    input.nextLine();
                    break;
                case 2:
                    input.nextLine();
                    controller = new AccountController();
                    System.out.print("Nhap ten: ");
                    String nameCreate = input.nextLine();
                    System.out.print("Nhap email: ");
                    String emailCreate = input.nextLine();
                    System.out.print("Nhap username: ");
                    String usernameCreate = input.nextLine();
                    if (controller.createAccount(nameCreate, emailCreate, usernameCreate) == true)
                        System.out.println("Them thanh cong");
                    else
                        System.out.println("Khong them duoc");
                    break;
                case 3:
                    controller = new AccountController();
                    System.out.print("Nhap id can tim: ");
                    int id = input.nextInt();
                    System.out.println(controller.getAccountById(id).toString());
                    input.nextLine();
                    break;
                case 4:
                    input.nextLine();
                    controller = new AccountController();
                    System.out.print("Nhap username: ");
                    String username = input.nextLine();
                    if (controller.isAccountExist(username) == true){
                        JOptionPane.showMessageDialog(null, "Account Exist");
                    }else JOptionPane.showMessageDialog(null,"Account does not exist");
                    break;
                case 5:
                    controller = new AccountController();
                    System.out.print("Nhap id account: ");
                    int idUpdate = input.nextInt();
                    System.out.print("Nhap ten: ");
                    input.nextLine();
                    String fullnameUpdate = input.nextLine();
                    System.out.print("Nhap email: ");
                    String emailUpdate = input.nextLine();
                    System.out.print("Nhap username: ");
                    String usernameUpdate = input.nextLine();
                    System.out.println(controller.updateAccountById(idUpdate, emailUpdate, fullnameUpdate, usernameUpdate).toString());
                    break;
                case 6:
                    controller = new AccountController();
                    System.out.print("Nhap id: ");
                    int idDelete = input.nextInt();
                    if (controller.deleteAccount(idDelete))
                        JOptionPane.showMessageDialog(null, "Xoa thanh cong");
                    else JOptionPane.showMessageDialog(null, "Khong thanh cong");
            }
        }while (choice >= 1 && choice <= 6);
    }
}
