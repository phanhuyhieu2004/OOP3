package com.example.oop3;

public class Student {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private Integer id;
    private String name;
    private int age;

    public Student(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}


