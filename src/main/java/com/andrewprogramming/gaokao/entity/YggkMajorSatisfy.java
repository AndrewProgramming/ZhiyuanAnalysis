package com.andrewprogramming.gaokao.entity;

import javax.persistence.*;

@Entity
@Table(name = "yggk_school_major_satisfy")
public class YggkMajorSatisfy {

    public YggkMajorSatisfy() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String schoolName;

    private String majorName;
    private String totalSatisfy;
    private String hardwareSatisfy;
    private String teachQualitySatisfy;
    private String getJobSatisfy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getTotalSatisfy() {
        return totalSatisfy;
    }

    public void setTotalSatisfy(String totalSatisfy) {
        this.totalSatisfy = totalSatisfy;
    }

    public String getHardwareSatisfy() {
        return hardwareSatisfy;
    }

    public void setHardwareSatisfy(String hardwareSatisfy) {
        this.hardwareSatisfy = hardwareSatisfy;
    }

    public String getTeachQualitySatisfy() {
        return teachQualitySatisfy;
    }

    public void setTeachQualitySatisfy(String teachQualitySatisfy) {
        this.teachQualitySatisfy = teachQualitySatisfy;
    }

    public String getGetJobSatisfy() {
        return getJobSatisfy;
    }

    public void setGetJobSatisfy(String getJobSatisfy) {
        this.getJobSatisfy = getJobSatisfy;
    }
}
