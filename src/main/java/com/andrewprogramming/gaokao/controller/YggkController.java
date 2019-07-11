package com.andrewprogramming.gaokao.controller;

import com.andrewprogramming.gaokao.entity.YggkSchool;
import com.andrewprogramming.gaokao.service.YggkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "阳光高考", description = "获取阳光高考信息接口")
@RestController
public class YggkController {

    @Autowired
    private YggkService yggkService;

    @ApiOperation("根据school实体获取学校信息")
    @PostMapping("/school/find")
    public YggkSchool getSchoolInfo(@RequestBody YggkSchool school) {

        return yggkService.getSchoolInfo(school);
    }

//    @ApiOperation("根据城市查询高校信息")
//    @GetMapping("/school/find/{city}")
//    public List<YggkSchool> getSchoolsByCity(@PathVariable String city) {
//        return yggkService.getSchoolInfoByCity(city);
//    }

    @ApiOperation("根据高校名字查询高校信息")
    @GetMapping("/school/find/{name}")
    public YggkSchool getSchoolByName(@PathVariable String name) {
        return yggkService.getSchoolInfoByName(name);
    }
}
