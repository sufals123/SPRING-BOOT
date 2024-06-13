package com.boot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer>{

}
