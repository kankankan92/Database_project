package com.company.entity;

public class Company {

    private int id;
    private String name;

    public Company(String name) {
        this.name = name;
    }

    public Company(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

}
