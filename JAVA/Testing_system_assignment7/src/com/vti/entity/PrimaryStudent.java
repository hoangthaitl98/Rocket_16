package com.vti.entity;

public class PrimaryStudent extends Student{
    public static int countPrimary = 0;

    public PrimaryStudent() {
    }

    public PrimaryStudent(int id, String name) {
        super(id, name);
        countPrimary++;
    }
}
