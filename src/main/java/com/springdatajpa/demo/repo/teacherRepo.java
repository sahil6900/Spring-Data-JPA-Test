package com.springdatajpa.demo.repo;

import com.springdatajpa.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface teacherRepo extends JpaRepository<Teacher,Integer> {
}
