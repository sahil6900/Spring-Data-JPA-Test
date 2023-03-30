package com.springdatajpa.demo.repo;

import com.springdatajpa.demo.entity.Course;
import com.springdatajpa.demo.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class courseMaterialRepoTest {

    @Autowired
    private courseRepo courseRepo;

    @Test
    public void test(){
        CourseMaterial courseMaterial = CourseMaterial.builder ()
                .url ("www.goog.com")
                .build ();

        Course course = Course.builder ()
                .title ("JSP")
                .credit (5)
                .courseMaterial (courseMaterial)
                .build ();

        System.out.println (course);
    }

}