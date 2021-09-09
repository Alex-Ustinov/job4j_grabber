package ru.job4j.design.srp;

public class User {

    private String name;

    private String lastName;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    User(String name, String lastName) {
        this.lastName = lastName;
        this.name = name;
    }

}