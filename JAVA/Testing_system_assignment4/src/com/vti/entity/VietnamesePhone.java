package com.vti.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class VietnamesePhone extends Phone{

    private ArrayList<Contact> contacts;
    @Override
    public void insertContact(String name, String phone) {
        Contact contact = new Contact();
        contact.setName(name);
        contact.setNumber(phone);
        contacts.add(contact);
    }

    @Override
    public void removeContact(String name) {
        for (int i = 0; i < contacts.size(); i++){
            if (name.equals(contacts.get(i).getName())){
                contacts.remove(i);
            }
        }
    }

    @Override
    public void updateContact(String name, String newPhone) {
        for (int i = 0; i < contacts.size(); i++){
            if (name.equals(contacts.get(i).getName())){
                contacts.get(i).setNumber(newPhone);
            }
        }
    }

    @Override
    public void searchContact(String name) {
        boolean found = false;
        for (int i = 0; i < contacts.size(); i++){
            if (name.equals(contacts.get(i).getName())){
                found = true;
            }
        }
        if (found == true)
            System.out.println("Tim Thay");
        else
            System.out.println("Khong tim thay");
    }
}
