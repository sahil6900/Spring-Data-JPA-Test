package com.springdatajpa.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @SequenceGenerator (
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                        generator = "student_sequence")
    private int studentId;
    private String name;
    private String surname;
    private String standard;
    private char grade;
    private double feesPaid;
//    private String guardianName;
//    private String guardianEmail;
//    private String guardianMobile;

    @Embedded
    private Guardian guardian;
}
