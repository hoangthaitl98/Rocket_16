package com.vti.entity;

public class SecondaryStudent extends Student{
    public static int countSecondary = 0;
    public SecondaryStudent() {

    }

    public SecondaryStudent(int id, String name) {
        super(id, name);
        countSecondary++;
    }
}
