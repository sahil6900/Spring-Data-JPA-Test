package com.springdatajpa.demo.repo;

import com.springdatajpa.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface studentRepo extends JpaRepository<Student,Integer> {

    public Student findByName(String name);

    final String GET_SUM_OF_FEES="select sum(fees_Paid) as TotalFees from student";
    @Query(value = GET_SUM_OF_FEES ,nativeQuery = true)
    public double sumOfFees();
}
