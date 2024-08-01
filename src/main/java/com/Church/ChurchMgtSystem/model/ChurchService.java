package com.Church.ChurchMgtSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "church_service")
public class ChurchService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String day;
    private String starting_hour;
    private String ending_hour;

    public ChurchService() {
    }

    public ChurchService(int id) {
        this.id = id;
    }

    public ChurchService(int id, String day, String starting_hour, String ending_hour) {
        this.id = id;
        this.day = day;
        this.starting_hour = starting_hour;
        this.ending_hour = ending_hour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStarting_hour() {
        return starting_hour;
    }

    public void setStarting_hour(String starting_hour) {
        this.starting_hour = starting_hour;
    }

    public String getEnding_hour() {
        return ending_hour;
    }

    public void setEnding_hour(String ending_hour) {
        this.ending_hour = ending_hour;
    }
}
