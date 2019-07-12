package com.andrewprogramming.gaokao.service;

import com.andrewprogramming.gaokao.dao.YggkSchoolRepository;
import com.andrewprogramming.gaokao.entity.School;
import com.andrewprogramming.gaokao.entity.YggkSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YggkSchoolService {

    @Autowired
    private YggkSchoolRepository yggkSchoolRepository;

    public YggkSchool getSchoolInfo(YggkSchool school) {
        return yggkSchoolRepository.findByName(school.getName());
    }

    public List<YggkSchool> getSchoolInfoByCity(String city) {
        return yggkSchoolRepository.findByCity(city);
    }

    public YggkSchool getSchoolInfoByName(String name) {
        return yggkSchoolRepository.findByName(name);
    }

    public List<YggkSchool> getSchoolsInfoByEntity(YggkSchool school) {
        return yggkSchoolRepository.findAll(Example.of(school));
    }

}
