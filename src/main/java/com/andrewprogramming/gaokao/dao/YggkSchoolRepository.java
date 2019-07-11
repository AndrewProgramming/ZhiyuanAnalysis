package com.andrewprogramming.gaokao.dao;

import com.andrewprogramming.gaokao.entity.YggkSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface YggkSchoolRepository extends JpaRepository<YggkSchool, Long> {
    YggkSchool findByName(String name);

    List<YggkSchool> findByCity(String city);
}

