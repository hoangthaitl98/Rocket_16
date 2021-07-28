package com.vti.entity;

import com.vti.backend.ScannerUtils;

public class Position {
    private int id;
    private PositionName name;
    private enum PositionName {
        Dev, Test, Scrum_Master, PM
    }

    public Position() {
        int stop = 0;
        System.out.print("Input id: ");
        this.id = ScannerUtils.inputInt();
        System.out.print("Input name: ");
        do {
            String choice = ScannerUtils.inputString();
            switch (choice){
                case "Dev":
                    this.name = PositionName.Dev;
                    stop++;
                    break;
                case "Test":
                    this.name = PositionName.Test;
                    stop++;
                    break;
                case "Scrum_Master":
                    this.name = PositionName.Scrum_Master;
                    stop++;
                    break;
                case "PM":
                    this.name = PositionName.PM;
                    stop++;
                    break;
                default:
                    System.out.println("Input again: ");
                    break;
            }
        }while (stop == 0);
    }

    public Position(int id, PositionName name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PositionName getName() {
        return name;
    }

    public void setName(PositionName name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
