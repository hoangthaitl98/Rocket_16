package com.vti.frontend;

import com.vti.entity.News;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.backend.Exercise1;

public class MyNews {
    public static void main(String[] args) {
        Exercise1 exercise1 = new Exercise1();
        Scanner input = new Scanner(System.in);
        ArrayList<News> news = new ArrayList<>();
        int choice;
        do {
            System.out.println("1.Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    exercise1.insertNews(news);
                    break;
                case 2:
                    exercise1.viewListNews(news);
                    break;
                case 3:
                    exercise1.averageRate(news);
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        } while (choice > 0 && choice < 4);
    }
}
