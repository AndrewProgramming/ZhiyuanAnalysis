package com.andrewprogramming.gaokao.controller.grab;

import com.andrewprogramming.gaokao.service.GrabYggkService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "爬虫接口", description = "爬取阳关高考网上的院校信息Rest API")
@RestController
public class GrabYggkController {
    private static final Logger logger = LogManager.getLogger(GrabYggkController.class);

    @Autowired
    private GrabYggkService service;


    @ApiOperation("爬取阳光高考网的院校信息并存入数据库")
    @GetMapping("/grab/YggkSchoolInfo")
    public void grabYggkSchoolInfo() {
        service.grabYggkSchoolInfo();
    }

    @ApiOperation("爬取阳光高考网的院校满意度信息并存入数据库")
    @GetMapping("/grab/YggkSchoolSatisfyInfo")
    public void grabYggkSchoolSatisfy() {
        service.grabYggkSchoolSatisfy();
    }

    @ApiOperation("爬取阳光高考网的专业满意度信息并存入数据库")
    @GetMapping("/grab/YggkSchoolMajorInfo")
    public void gragSchoolMajorSatisfyInfo() {
        service.grabYggkMajorSatisfyInfo();
    }

}
