package com.Church.ChurchMgtSystem.model;

import jakarta.persistence.*;


@Entity
@Table(name = "choir")
public class Choir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "choir_id")
    private int Id;
    @Column(name = "choir_name")
    private String Name;
    private String leader;
    private int nr_of_members;
    private String formed_date;

    public Choir() {
    }

    public Choir(int id, String name, String leader, int nr_of_members, String formed_date) {
        Id = id;
        Name = name;
        this.leader = leader;
        this.nr_of_members = nr_of_members;
        this.formed_date = formed_date;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public int getNr_of_members() {
        return nr_of_members;
    }

    public void setNr_of_members(int nr_of_members) {
        this.nr_of_members = nr_of_members;
    }

    public String getFormed_date() {
        return formed_date;
    }

    public void setFormed_date(String formed_date) {
        this.formed_date = formed_date;
    }
}
