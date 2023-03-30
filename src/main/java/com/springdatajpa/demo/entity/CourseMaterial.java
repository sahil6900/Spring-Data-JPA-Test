package com.springdatajpa.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "course")
@Builder
public class CourseMaterial {

    @Id
    @SequenceGenerator (
            name = "courseMaterial_sequence",
            sequenceName = "courseMaterial_sequence"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                                generator = "courseMaterial_sequence")
    private int courseMaterialId;
    private String url;

    @OneToOne(
            mappedBy = "courseMaterial"
    )
    private Course course;
}
