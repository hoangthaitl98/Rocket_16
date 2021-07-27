package com.vti.backend;

import java.time.LocalDate;

public class Exercise1 {
    public static void question1(){
        Department department1 = new Department();
        Department department2 = new Department();
    }

    public static void question2(){
        Account account1 = new Account();
        Account account2 = new Account(2, "nguyenvana@gmail.com", "anguyenvan", "nguyen van a");
        Position position1 = new Position();
        Account account3 = new Account(3, "nguyenvanb@gmail.com", "bnguyenvan", "nguyen van b", position1);
        Position position2 = new Position();
        Account account4 = new Account(4, "nguyenvanc@gmail.com", "cnguyenvan", "nguyen van c", position2,
                LocalDate.now());
    }

    public static void question3(){

    }
}
