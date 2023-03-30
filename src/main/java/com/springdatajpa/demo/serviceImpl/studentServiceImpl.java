package com.springdatajpa.demo.serviceImpl;

import com.springdatajpa.demo.entity.Student;
import com.springdatajpa.demo.repo.studentRepo;
import com.springdatajpa.demo.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class studentServiceImpl implements studentService {

    @Autowired
    private studentRepo studentRepo;


    @Override
    public Student addStudent (Student student) {
        Student student1 = this.studentRepo.save (student);
        return student1;
    }

    @Override
    public Student getStudent (int id) {
        Student student = this.studentRepo.findById (id).orElseThrow (() -> new RuntimeException ("No student found with given id " + id));
        return student;
    }

    @Override
    public List<Student> getAllStudent () {
        List<Student> allStudents = this.studentRepo.findAll ();

        List<Student> students = new ArrayList<> ();

        for (Student s : allStudents) {
            students.add (s);
        }
        return students;
    }


    @Override
    public Student updateStudent (int id , Student student) {
        Student student1 = this.studentRepo.findById (id).orElseThrow (() -> new RuntimeException ("No student found with given id " + id));

        student1.setName (student.getName ());
        student1.setSurname (student.getSurname ());
        student1.setStandard (student.getStandard ());
        student1.setGrade (student.getGrade ());
        student1.setFeesPaid (student.getFeesPaid ());

        Student studentupdated = this.studentRepo.save (student1);

        return studentupdated;
    }

    @Override
    public void deleteStudent (int id) {
        Student student = this.studentRepo.findById (id).orElseThrow (() -> new RuntimeException ("No student found with given id " + id));

        this.studentRepo.delete (student);

        System.out.println ("Deleted student details are :\n" + student);
    }

    @Override
    public Student getStudentByName (String name) {
        Student byName = this.studentRepo.findByName (name);

        return byName;
    }

    @Override
    public double getSumOfAllFees () {
        double fees = this.studentRepo.sumOfFees ();
        return fees;
    }


}
