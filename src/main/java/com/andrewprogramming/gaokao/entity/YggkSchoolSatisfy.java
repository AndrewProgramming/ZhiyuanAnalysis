package com.andrewprogramming.gaokao.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "yggk_school_satisfy")
public class YggkSchoolSatisfy implements Serializable {
    public YggkSchoolSatisfy() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String city;

    private String totalSatisfy;
    private String envSatisfy;
    private String lifeSatisfy;


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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTotalSatisfy() {
        return totalSatisfy;
    }

    public void setTotalSatisfy(String totalSatisfy) {
        this.totalSatisfy = totalSatisfy;
    }

    public String getEnvSatisfy() {
        return envSatisfy;
    }

    public void setEnvSatisfy(String envSatisfy) {
        this.envSatisfy = envSatisfy;
    }

    public String getLifeSatisfy() {
        return lifeSatisfy;
    }

    public void setLifeSatisfy(String lifeSatisfy) {
        this.lifeSatisfy = lifeSatisfy;
    }
}
