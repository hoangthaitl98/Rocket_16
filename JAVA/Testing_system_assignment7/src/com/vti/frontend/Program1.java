package com.vti.frontend;

import com.vti.backend.Exercise1;
import com.vti.entity.PrimaryStudent;
import com.vti.entity.SecondaryStudent;
import com.vti.entity.Student;

import java.util.ArrayList;

public class Program1 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Student student1 = new Student(1, "Nguyen Van A");
        Student student2 = new Student(2, "Nguyen Van B");
        Student student3 = new Student(3, "Nguyen Van C");
        Student student4 = new Student(3, "Nguyen Van C");
        Student student5 = new Student(3, "Nguyen Van C");
        Student student6 = new Student(3, "Nguyen Van C");
        Student student7 = new Student(3, "Nguyen Van C");

        Exercise1 exercise1 = new Exercise1();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        //exercise1.question1(students);

        //exercise1.question2(students);

        //exercise1.question5();

        //exercise1.question6();
    }
}
