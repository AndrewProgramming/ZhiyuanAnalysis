package com.andrewprogramming.gaokao.dao;

import com.andrewprogramming.gaokao.entity.YggkSchool;
import com.andrewprogramming.gaokao.entity.YggkSchoolSatisfy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface YggkSchoolSatisfyRepository extends JpaRepository<YggkSchoolSatisfy, Long> {
}
