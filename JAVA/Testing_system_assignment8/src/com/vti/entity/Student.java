package com.vti.entity;

public class Student<T> {
    private T id;
    private String name;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printInfo(T a){
        System.out.println(a.toString());
    }
}
