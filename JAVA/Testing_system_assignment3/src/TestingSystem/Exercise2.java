package TestingSystem;

import java.time.LocalDate;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        final int NUM = 5;
        Account [] accounts = new Account[NUM];
        Scanner input = new Scanner(System.in);
        for(int i = 0 ; i < NUM; i++){
            accounts[i] = new Account();
            accounts[i].email = "Email ".concat(String.valueOf(i+1));
            accounts[i].userName = "Username ".concat(String.valueOf(i+1));
            accounts[i].fullName = "Full name ".concat(String.valueOf(i+1));
            accounts[i].createDate = LocalDate.now();
        }
        for (int i = 0; i < NUM; i++){
            System.out.println("Account " + (i + 1)+ "\n" +
                    "Email: " + accounts[i].email + "\n" +
                    "Username: " + accounts[i].userName + "\n" +
                    "Full name: " + accounts[i].fullName + "\n" +
                    "Create Date: " + accounts[i].createDate + "\n");
        }
    }
}
