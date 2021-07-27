package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise1 {
    public void insertNews(ArrayList<News> news) {
        News news1 = new News();
        Scanner input = new Scanner(System.in);
        float[] rate = new float[3];
        System.out.print("Enter id: ");
        news1.setId(input.nextInt());
        input.nextLine();
        System.out.print("Enter title: ");
        news1.setTitle(input.nextLine());
        System.out.print("Enter publishDate: ");
        news1.setPublishDate(input.nextLine());
        System.out.print("Enter author: ");
        news1.setAuthor(input.nextLine());
        System.out.print("Enter content: ");
        news1.setContent(input.nextLine());
        System.out.print("Enter 3 rates: ");
        for (int i = 0; i < 3; i++) {
            rate[i] = input.nextFloat();
        }
        news1.setRates(rate);
        news.add(news1);
    }

    public void viewListNews(ArrayList<News> news) {
        for (int i = 0; i < news.size(); i++) {
            news.get(i).display();
        }
    }

    public void averageRate(ArrayList<News> news) {
        for (int i = 0; i < news.size(); i++) {
            news.get(i).calculate();
            news.get(i).display();
        }
    }
}
