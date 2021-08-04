package com.vti.backend;

import com.vti.entity.PrimaryStudent;
import com.vti.entity.SecondaryStudent;
import com.vti.entity.Student;

import java.util.ArrayList;

public class Exercise1 {
    public void question1(ArrayList<Student> students){
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
        }
        Student.setCollege("Dai hoc cong nghe");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
        }
    }

    public void question2(ArrayList<Student> students){
        for (int i = 0; i < students.size(); i++) {
            Student.setMoneyGroup(students.size()*100);
        }
        System.out.println("Group money: " + Student.getMoneyGroup() + "K");
        System.out.println("Student 1 mua bim bim 50k");
        Student.setMoneyGroup(Student.getMoneyGroup() - 50);
        System.out.println("Group money: " + Student.getMoneyGroup() + "K");
        System.out.println("Student 2 mua banh mi 20k");
        Student.setMoneyGroup(Student.getMoneyGroup() - 20);
        System.out.println("Group money: " + Student.getMoneyGroup() + "K");
        System.out.println("Student 3 mua do dung 150k");
        Student.setMoneyGroup(Student.getMoneyGroup() - 150);
        System.out.println("Group money: " + Student.getMoneyGroup() + "K");
    }

    public void question5(){
        System.out.println("So student: " + Student.countStudent);
    }

    public void question6(){
        System.out.println("So Primary Student: " + PrimaryStudent.countPrimary);
        System.out.println("So Secondary Student: " + SecondaryStudent.countSecondary);
    }

}
