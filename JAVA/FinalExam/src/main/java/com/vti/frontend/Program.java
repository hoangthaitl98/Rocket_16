package com.vti.frontend;

import com.vti.backend.presentationlayer.UserController;
import com.vti.utils.ScannerUtils;


public class Program {
    public static void main(String[] args) {
        int choice;
        question4();
        do {
            System.out.println("1. Find user by id");
            System.out.println("2. Get all manager");
            System.out.println("3. Quit");
            System.out.printf("Input choice: ");
            choice = ScannerUtils.inputInt("Invalid! Please input again");
            switch (choice) {
                case 1:
                    question2();
                    break;
                case 2:
                    quesiton3();
                    break;
                case 3:
                    break;
            }
        } while (choice >= 1 && choice <= 2);
    }

    public static void question2() {
        UserController controller = new UserController();
        System.out.println("Input id to find: ");
        int idFind = ScannerUtils.inputInt("Invalid! Please input again");
        System.out.println("id\tfullname\t\t\t\temail\t\t\t\tpassword");
        for (int i = 0; i < controller.getUserByProjectId(idFind).size(); i++) {
            System.out.println(controller.getUserByProjectId(idFind).get(i).getId()
                    + "\t" +  controller.getUserByProjectId(idFind).get(i).getFullName()
                    + "\t\t\t\t" + controller.getUserByProjectId(idFind).get(i).getEmail()
                    + "\t\t\t\t" + controller.getUserByProjectId(idFind).get(i).getPassword());
        }
    }

    public static void quesiton3() {
        UserController controller = new UserController();
        System.out.println("id\tFullname\t\t\t\tRole");
        for (int i = 0; i < controller.getAllMagager().size(); i++) {
            System.out.println(controller.getAllMagager().get(i).getId()
                    + "\t" + controller.getAllMagager().get(i).getFullName()
                    + "\t\t\t\tManager");
        }
    }

    public static void question4() {
        UserController controller = new UserController();
        System.out.println("Login \n------------");
        System.out.print("Email: ");
        String emailLogin = ScannerUtils.inputString("Invalid! Please input again");
        System.out.print("Password: ");
        String password = ScannerUtils.inputString("Invalid! Please input again");
        while (controller.login(emailLogin, password) == false) {
            System.out.println("Email or password is not correct");
            System.out.print("Email: ");
            emailLogin = ScannerUtils.inputString("Invalid! Please input again");
            System.out.print("Password: ");
            password = ScannerUtils.inputString("Invalid! Please input again");
        }
        if (controller.login(emailLogin, password) == true) {
            System.out.println("Login success");
        }
    }
}
