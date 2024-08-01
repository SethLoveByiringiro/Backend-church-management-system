package com.Church.ChurchMgtSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "church_leader")
public class ChurchLeaders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String firstname;
    private String lastname;
    private String address;
    private String gender;

    public ChurchLeaders() {
    }

    public ChurchLeaders(int id, String title, String firstname, String lastname, String address, String gender) {
        this.id = id;
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
