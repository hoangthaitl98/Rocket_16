package com.vti.entity;

public class Manager extends User{
    private int explnYear;

    public Manager(int id, int expInYear) {
    }

    public Manager(int id, String fullName, String email, String password, int explnYear) {
        super(id, fullName, email, password);
        this.explnYear = explnYear;
    }

    public int getExplnYear() {
        return explnYear;
    }

    public void setExplnYear(int explnYear) {
        this.explnYear = explnYear;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "explnYear=" + explnYear +
                '}';
    }
}
