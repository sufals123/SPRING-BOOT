package com.boot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
