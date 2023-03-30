package com.springdatajpa.demo.service;

import com.springdatajpa.demo.entity.Student;

import java.util.List;

public interface studentService {
    public Student addStudent(Student student);

    public Student getStudent(int id);

    public List<Student> getAllStudent();

    public Student updateStudent(int id,Student student);

    public void deleteStudent(int id);

    public Student getStudentByName(String name);

    public double getSumOfAllFees();
}
