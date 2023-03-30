package com.springdatajpa.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator (
            name ="course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "course_sequence")
    private int courseId;
    private String title;
    private int credit;

   @OneToOne(
           cascade = CascadeType.ALL
   )
   @JoinColumn(
           name = "courseMaterial_id",
           referencedColumnName = "courseMaterialId"
   )
    private CourseMaterial courseMaterial;

   @ManyToOne(
           cascade = CascadeType.ALL
   )
   @JoinColumn(
           name = "teacher_id",
           referencedColumnName = "teacherId"
   )
   private Teacher teacher;

   @ManyToMany(
           cascade = CascadeType.ALL
   )
   @JoinTable(
           name = "student_course_mapping",
           joinColumns = @JoinColumn(
                   name = "course_id",
                   referencedColumnName = "courseId"
           ),inverseJoinColumns = @JoinColumn(
                   name = "student_id",
                    referencedColumnName = "studentId"
   )
   )
   private List<Student> student;

}
