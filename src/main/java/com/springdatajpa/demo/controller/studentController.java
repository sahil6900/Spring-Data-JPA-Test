package com.springdatajpa.demo.controller;

import com.springdatajpa.demo.entity.Student;
import com.springdatajpa.demo.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class studentController {

    @Autowired
    private studentService studentService;

    @PostMapping("/add/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student student1 = this.studentService.addStudent (student);

        return new ResponseEntity<Student> (student1, HttpStatus.CREATED);
    }

    @GetMapping("/get/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer id){
        Student student = this.studentService.getStudent (id);

        return new ResponseEntity<Student> (student,HttpStatus.OK);
    }

    @PutMapping("/update/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id,@RequestBody Student student){
        Student student1 = this.studentService.updateStudent (id , student);

        return new ResponseEntity<Student> (student1,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/all/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> allStudent = this.studentService.getAllStudent ();

        return new ResponseEntity<List<Student>> (allStudent,HttpStatus.OK);
    }

    @DeleteMapping("/delete/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
        this.studentService.deleteStudent (id);

        return new ResponseEntity<> ("Student deleted successfully",HttpStatus.OK);
    }

    @GetMapping("/get/stud/{name}")
    public ResponseEntity<Student> findByName(@PathVariable String name){
        Student studentByName = this.studentService.getStudentByName (name);

        return new ResponseEntity<Student> (studentByName,HttpStatus.OK);
    }

    @GetMapping("/get/fees/total")
    public ResponseEntity<Double> getAllFees(){
        double sumOfAllFees = this.studentService.getSumOfAllFees ();

        return new ResponseEntity<Double> (sumOfAllFees,HttpStatus.OK);
    }
}
