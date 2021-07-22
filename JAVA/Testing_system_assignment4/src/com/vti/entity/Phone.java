package com.vti.entity;

import java.util.ArrayList;

public abstract class Phone {
    public class Contact{
        private String name;
        private String number;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }

    private ArrayList<Contact> contacts;

    public abstract void insertContact(String name, String phone);

    public abstract void removeContact(String name);

    public abstract void updateContact(String name, String newPhone);

    public abstract void searchContact(String name);
}
