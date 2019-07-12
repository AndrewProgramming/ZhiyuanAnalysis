package com.andrewprogramming.gaokao.service;

import com.andrewprogramming.gaokao.dao.YggkSchoolSatisfyRepository;
import com.andrewprogramming.gaokao.entity.YggkSchoolSatisfy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YggkSchoolSatisfyService {

    @Autowired
    private YggkSchoolSatisfyRepository yggkSchoolSatisfyRepository;

    public List<YggkSchoolSatisfy> getSchoolSatisfy(YggkSchoolSatisfy yggkSchoolSatisfy) {

        return yggkSchoolSatisfyRepository.findAll(Example.of(yggkSchoolSatisfy));

    }
}
