package com.springdatajpa.demo.controller;

import com.springdatajpa.demo.entity.Course;
import com.springdatajpa.demo.entity.Student;
import com.springdatajpa.demo.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class courseController {

    @Autowired
    private courseService courseService;

    @PostMapping ("/add")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        Course course1 = this.courseService.createCourse (course);

        return new ResponseEntity<> (course1, HttpStatus.CREATED);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<String>> findStudentByCourseTitle(@RequestParam String name){
        List<String> allStudentsByCourseName =
                this.courseService.getStudentByCourseTitle (name);

        return new ResponseEntity<List<String>> (allStudentsByCourseName,HttpStatus.OK);
    }
}
