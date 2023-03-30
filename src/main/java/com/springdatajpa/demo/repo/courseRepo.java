package com.springdatajpa.demo.repo;

import com.springdatajpa.demo.entity.Course;
import com.springdatajpa.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface courseRepo extends JpaRepository<Course, Integer> {

// *****************Used for @PathVariable********************
//    @Query(value = "select student.name from ((student_course_mapping Inner JOIN course " +
//            "ON course.course_id = student_course_mapping.course_id) " +
//            "Inner JOIN student ON student.student_id = student_course_mapping.student_id) " +
//            "WHERE course.title = ?1",nativeQuery = true)
//    public List<String> findStudentByCourseTitle(String name);


    @Query(value = "select student.name from ((student_course_mapping Inner JOIN course " +
            "ON course.course_id = student_course_mapping.course_id) " +
            "Inner JOIN student ON student.student_id = student_course_mapping.student_id) " +
            "WHERE course.title = :name",nativeQuery = true)
    public List<String> findStudentByCourseTitle(@Param("name") String name);
}
