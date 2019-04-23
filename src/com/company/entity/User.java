package com.company.entity;

public class User {

    private int id;
    private  String name;
    private String company;
    private  int salary;
    private Integer company_id;

    public User(String name, String company, int salary){
        this.name = name;
        this.company = company;
        this.salary = salary;
    }

    public User(int id, String name, String company, int salary){
        this.id = id;
        this.name = name;
        this.company = company;
        this.salary = salary;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCompany_id(){
        return company_id;
    }

    public String getCompany(){
        return company;
    }

    public int getSalary(){
        return salary;
    }
}
