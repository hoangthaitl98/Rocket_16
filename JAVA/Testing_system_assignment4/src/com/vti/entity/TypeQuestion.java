package com.vti.entity;

public class TypeQuestion {
    private int id;
    private TypeName name;

    private enum TypeName {
        Essay, Multiple_Choice
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeName getName() {
        return name;
    }

    public void setName(TypeName name) {
        this.name = name;
    }
}