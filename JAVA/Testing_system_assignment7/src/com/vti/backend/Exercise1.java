package com.vti.backend;

import com.vti.entity.Student;

import java.util.ArrayList;

public class Exercise1 {
    public static void question1(ArrayList<Student> students){
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
        }
        Student.setCollege("Dai hoc cong nghe");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
        }
    }
}
