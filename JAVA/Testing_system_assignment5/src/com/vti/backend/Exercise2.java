package com.vti.backend;

import com.vti.entity.Student;

public class Exercise2 {
    public void question1() {
        Student[] students = new Student[10];
        students[0] = new Student(1, "Nguyen Van A", 1);
        students[1] = new Student(2, "Nguyen Van C", 1);
        students[2] = new Student(3, "Nguyen Van C", 1);
        students[3] = new Student(4, "Nguyen Van D", 1);
        students[4] = new Student(5, "Nguyen Van E", 2);
        students[5] = new Student(6, "Nguyen VAn F", 2);
        students[6] = new Student(7, "Nguyen Van G", 2);
        students[7] = new Student(8, "Nguyen VAn H", 3);
        students[8] = new Student(9, "Nguyen VAn I", 3);
        students[9] = new Student(10, "Nguyen Van K", 3);

        for (int i = 0; i < 10; i++) {
            students[i].diemDanh();
        }

        for (int i = 0; i < 10; i++) {
            if (students[i].getGroup() == 1){
                students[i].hocBai();
            }
        }

        for (int i = 0; i < 10; i++) {
            if (students[i].getGroup() == 2){
                students[i].veSinh();
            }
        }
    }

}
