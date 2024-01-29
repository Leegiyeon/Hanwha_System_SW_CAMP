package com.ohgiraffers.assertions.section01.jupiter;

public class Person {


    private String firstName;
    private String lastName;

    public Person() {
    }
    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.lastName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String secondName) {
        this.lastName = secondName;
    }
}

