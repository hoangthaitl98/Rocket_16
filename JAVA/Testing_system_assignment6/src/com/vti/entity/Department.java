package com.vti.entity;

import com.vti.backend.ScannerUtils;

public class Department{
    private int id;
    private String name;

    public Department(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Department() {
        System.out.print("Input id: ");
        this.id = ScannerUtils.inputInt();
        System.out.print("Input name: ");
        this.name = ScannerUtils.inputString();
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

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
