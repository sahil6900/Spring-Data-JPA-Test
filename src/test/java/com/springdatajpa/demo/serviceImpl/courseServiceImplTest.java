package com.springdatajpa.demo.serviceImpl;

import com.springdatajpa.demo.entity.Course;
import com.springdatajpa.demo.entity.CourseMaterial;
import com.springdatajpa.demo.entity.Student;
import com.springdatajpa.demo.entity.Teacher;
import com.springdatajpa.demo.repo.courseRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class courseServiceImplTest {

    @Mock
    private courseRepo courseRepo;

    @InjectMocks
    private courseServiceImpl courseService;

    @Test
    @DisplayName("should create and save a new course successfully")
    void createCourseSuccessfully () {

        Teacher teacher = new Teacher ();
        teacher.setFirstName ("Ashu");
        teacher.setLastName ("Nagargoje");
        teacher.setTeacherId (2);

        Student student = new Student ();
        student.setStudentId (7);
        student.setName ("Avinash");
        student.setSurname ("gote");
        student.setGrade ('A');
        student.setFeesPaid (100000);
        student.setStandard ("12th");

        List<Student> students = new ArrayList<> ();
        students.add (student);

        CourseMaterial courseMaterial = new CourseMaterial ();
        courseMaterial.setCourseMaterialId (4);
        courseMaterial.setUrl ("www.spring.docs.com");

        Course course = new Course ();
        course.setCourseId (1);
        course.setTitle ("Java");
        course.setCredit (3);
        course.setTeacher (teacher);
        course.setCourseMaterial (courseMaterial);
        course.setStudent (students);

        when (courseRepo.save (course)).thenReturn (course);

        Course course1 = courseService.createCourse (course);

        assertEquals (course , course1);
        verify (courseRepo , times (1)).save (course);
    }
}