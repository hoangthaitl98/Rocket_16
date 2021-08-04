package com.vti.entity;

public class Student {
    private int id;
    private String name;
    private static String college = "Dai hoc bach khoa";
    private static int moneyGroup = 0;
    public static int countStudent = 0;

    public Student() {
        countStudent++;
        if(countStudent > 7){
            System.err.println("Số lượng sinh viên đã vượt quá 7, không thể tạo thêm sinh viên");
        }
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        countStudent++;
        if(countStudent > 7){
            System.err.println("Số lượng sinh viên đã vượt quá 7, không thể tạo thêm sinh viên");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getCollege() {
        return college;
    }

    public static void setCollege(String college) {
        Student.college = college;
    }

    public static int getMoneyGroup() {
        return moneyGroup;
    }

    public static void setMoneyGroup(int moneyGroup) {
        Student.moneyGroup = moneyGroup;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name +
                ", college=" + college + '\'' +
                '}';
    }
}
