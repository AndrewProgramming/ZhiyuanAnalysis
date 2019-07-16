package com.andrewprogramming.gaokao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.util.List;

@ApiModel("阳光高考学校专业实体")
@Document(collection = "yggk_major_school")
public class YggkMajorSchool {

    public YggkMajorSchool() {
    }

    //    @ApiModelProperty("id")
    @Id
    private String id;

    @Field("major")
    private String major;
    @Field("schools")
    private List<String> schools;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public List<String> getSchools() {
        return schools;
    }

    public void setSchools(List<String> schools) {
        this.schools = schools;
    }

    @Override
    public String toString() {
        return "YggkMajorSchool{" +
                "id=" + id +
                ", major='" + major + '\'' +
                ", schools=" + schools +
                '}';
    }
}
