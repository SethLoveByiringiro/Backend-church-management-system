package com.Church.ChurchMgtSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "group_table")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private int Id;
    private String group_name;
    private String group_leader;
    private String role;
    private String secretary;

    public Group() {
    }

    public Group(int id, String group_name, String group_leader, String role, String secretary) {
        Id = id;
        this.group_name = group_name;
        this.group_leader = group_leader;
        this.role = role;
        this.secretary = secretary;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getGroup_leader() {
        return group_leader;
    }

    public void setGroup_leader(String group_leader) {
        this.group_leader = group_leader;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSecretary() {
        return secretary;
    }

    public void setSecretary(String secretary) {
        this.secretary = secretary;
    }
}
