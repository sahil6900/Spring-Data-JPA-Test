package com.springdatajpa.demo.service;

import com.springdatajpa.demo.entity.Course;

import java.util.List;

public interface courseService {
    public Course createCourse(Course course);

    public Course updateCourse(int id,Course course);

    public Course getCourseById(Integer id);

    public List<Course> getAllCourses();

    public String deleteCourse(int id);

    public List<String> getStudentByCourseTitle(String name);
}
