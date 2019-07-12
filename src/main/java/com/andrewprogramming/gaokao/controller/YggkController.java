package com.andrewprogramming.gaokao.controller;

import com.andrewprogramming.gaokao.entity.YggkSchool;
import com.andrewprogramming.gaokao.entity.YggkSchoolSatisfy;
import com.andrewprogramming.gaokao.service.YggkSchoolSatisfyService;
import com.andrewprogramming.gaokao.service.YggkSchoolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "阳光高考", description = "获取阳光高考信息接口")
@RestController
public class YggkController {

    @Autowired
    private YggkSchoolService yggkService;

    @Autowired
    private YggkSchoolSatisfyService yggkSchoolSatisfyService;

    @ApiOperation("根据school实体获取学校信息")
    @PostMapping("/school/find")
    public YggkSchool getSchoolInfo(@RequestBody YggkSchool school) {

        return yggkService.getSchoolInfo(school);
    }

    @ApiOperation("根据城市查询高校信息")
    @GetMapping("/school/find/city/{name}")
    public List<YggkSchool> getSchoolsByCity(@PathVariable String name) {
        return yggkService.getSchoolInfoByCity(name);
    }

    @ApiOperation("根据高校名字查询高校信息")
    @GetMapping("/school/find/{name}")
    public YggkSchool getSchoolByName(@PathVariable String name) {
        return yggkService.getSchoolInfoByName(name);
    }

    @ApiOperation("根据实体查询高校信息")
    @PostMapping("/school/find/entity")
    public List<YggkSchool> getSchoolByEntity(@RequestBody YggkSchool school) {
        return yggkService.getSchoolsInfoByEntity(school);
    }

    @ApiOperation("根据实体查询高校满意度信息")
    @PostMapping("/school_satisfy/find/entity")
    public List<YggkSchoolSatisfy> getSchoolSatisfy(@RequestBody YggkSchoolSatisfy yggkSchoolSatisfy) {
        return yggkSchoolSatisfyService.getSchoolSatisfy(yggkSchoolSatisfy);
    }
}
