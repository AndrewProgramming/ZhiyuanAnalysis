package com.andrewprogramming.gaokao.controller.grab;

import static org.assertj.core.api.Assertions.assertThat;

import com.andrewprogramming.gaokao.GaokaoApplication;
import com.andrewprogramming.gaokao.entity.YggkMajorSchool;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.List;


@ContextConfiguration(classes = GaokaoApplication.class)
@DataMongoTest
@ExtendWith(SpringExtension.class)
public class GrabYggkControllerTest {

    @DisplayName("Given object When save object using MongoDB template Then object can be found")
    @Test
    public void test(@Autowired MongoTemplate mongoTemplate) {
        // given
        DBObject objectToSave = BasicDBObjectBuilder.start()
                .add("key", "value")
                .get();

        // when
        mongoTemplate.save(objectToSave, "collection");

        // then
        assertThat(mongoTemplate.findAll(DBObject.class, "collection")).extracting("key")
                .containsOnly("value");
    }

    @Test
    public void writeEntityToMongoDB(@Autowired MongoTemplate mongoTemplate) {
        YggkMajorSchool yggkSchoolMajor = new YggkMajorSchool();
        yggkSchoolMajor.setMajor("法律");
        List<String> list = new ArrayList<>();
        list.add("清华大学");
        list.add("北京大学");
        yggkSchoolMajor.setSchools(list);

        DBObject objectToSave = BasicDBObjectBuilder.start()
                .add("法律", list)
                .get();


        mongoTemplate.save(objectToSave, "yggk_major_school");
        assertThat(assertThat(mongoTemplate.findAll(DBObject.class, "yggk_major_school")).extracting("法律").contains(list));


    }

}

