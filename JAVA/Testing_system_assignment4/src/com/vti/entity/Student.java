package com.vti.entity;

public class Student {
    private int id;
    private String name;
    private String homeTown;
    private double gpa;

    public Student() {
    }

    public Student(int id, double gpa) {
        this.id = id;
        this.gpa = gpa;
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

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void addGpa(double add) {
        this.gpa = this.gpa + add;
    }

    public String printInfo(){
        String typeGpa = "";
        if (gpa >= 0 && gpa < 4)
            typeGpa = "Yeu";
        else if (gpa >= 4 && gpa < 6)
            typeGpa = "Trung binh";
        else if (gpa >= 6 && gpa < 8)
            typeGpa = "Kha";
        else if (gpa >=8 && gpa <= 10)
            typeGpa = "Gioi";

        return ("Id: " + id + "\n" +
                "Ten: " + name + "\n" +
                "Home town: " + homeTown + "\n" +
                "GPA: " + gpa + "\n" +
                "Xep loai: " + typeGpa + "\n");
    }
}
