package com.boot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class PhoneNumber {

    @Id
    private int id;
    private String number;

    @OneToOne
    private Person person;

    public PhoneNumber(int id, String number, Person person) {
        this.id = id;
        this.number = number;
        this.person = person;
    }

    public PhoneNumber() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "PhoneNumber [id=" + id + ", number=" + number + ", person=" + person + "]";
    }
}
