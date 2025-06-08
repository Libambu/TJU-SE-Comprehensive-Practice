package com.neusoft.elm.controller;

public class po {
    private String name;
    private int age;
    public po(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "po{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
