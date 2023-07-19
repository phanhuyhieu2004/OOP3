package com.example.oop3;

public class Students {
    private int id;
    private String name;
    private String className;
    private String gender;
    private String address;
    private double score;

    public Students(int id, String name, String className, String gender, String address, double score) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.gender = gender;
        this.address = address;
        this.score = score;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
