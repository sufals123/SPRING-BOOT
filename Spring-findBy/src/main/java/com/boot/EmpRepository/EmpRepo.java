package com.boot.EmpRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.boot.entity.Emp;

public interface EmpRepo extends JpaRepository<Emp, Integer> {
	
	Emp findByName(String name);
	Emp findByNameAndAddress(String name, String address);
	List<Emp> findByNameOrAddress(String name, String address);
	List<Emp> findByAddressIsNull();
	List<Emp> findByAgeGreaterThan(int age);
	Emp findByNameContaining(String name);
	
	@Query("Select u from Emp u")
	List<Emp> getAllEmp();
}
