package com.andrewprogramming.gaokao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@ApiModel("阳光高考学校专业实体")
@Entity
@Table(name = "yggk_school_major")
public class YggkSchoolMajor {

    public YggkSchoolMajor() {
    }

    @ApiModelProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String majorName;
    private List<String> schoolNameList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public List<String> getSchoolNameList() {
        return schoolNameList;
    }

    public void setSchoolNameList(List<String> schoolNameList) {
        this.schoolNameList = schoolNameList;
    }
}
