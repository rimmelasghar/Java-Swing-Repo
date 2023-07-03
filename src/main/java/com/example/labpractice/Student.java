package com.example.labpractice;

public class Student {
    public String name;
    public int age;

    // Constructor without Params.
    public Student() {
    }

    // Constructor with Params.
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String displayInformation(){
        return String.format("Name : %s ,Age : %s ",this.name,this.age);
    }
}
