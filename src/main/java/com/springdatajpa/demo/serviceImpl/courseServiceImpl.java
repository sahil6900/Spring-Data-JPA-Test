package com.springdatajpa.demo.serviceImpl;

import com.springdatajpa.demo.entity.Course;
import com.springdatajpa.demo.entity.Student;
import com.springdatajpa.demo.repo.courseRepo;
import com.springdatajpa.demo.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class courseServiceImpl implements courseService {

    @Autowired
    private courseRepo courseRepo;

    @Override
    public Course createCourse (Course course) {
        Course course1 = this.courseRepo.save (course);
        return course1;
    }

    @Override
    public Course updateCourse (int id , Course course) {
        return null;
    }

    @Override
    public Course getCourse (int id) {
        return null;
    }

    @Override
    public List<Course> getAllCourses () {
        return null;
    }

    @Override
    public String deleteCourse (int id) {
        return null;
    }

    @Override
    public List<String> getStudentByCourseTitle (String name) {
        List<String> studentByCourseTitle = this.courseRepo.findStudentByCourseTitle (name);
        return studentByCourseTitle;
    }
}
