package com.boot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.boot.EmpRepository.EmpRepo;
import com.boot.entity.Emp;

@SpringBootApplication
public class SpringFindByApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringFindByApplication.class, args);
		EmpRepo repo = context.getBean(EmpRepo.class);

		// Uncomment and modify the following lines to save some initial data if needed
		/*
		Emp emp = new Emp();
		emp.setName("SS");
		emp.setCompany("OXYGEN");
		emp.setAddress("WORLD");
		emp.setAge(32);
		
		Emp emp1 = new Emp();
		emp1.setName("LL");
		emp1.setCompany("OXYGEN");
		emp1.setAddress("WORLD");
		emp1.setAge(31);
		
		ArrayList<Emp> list = new ArrayList<>();
		list.add(emp);
		list.add(emp1);
		
		List<Emp> saveAll = repo.saveAll(list);
		System.out.println("save successfully... " + saveAll);
		*/

		// Spring Data JPA Find Methods && JPA Query Method
		Emp name = repo.findByName("LL");
		System.out.println(name);

		Emp nameAndAddress = repo.findByNameAndAddress("SS", "WORLD");
		System.out.println(nameAndAddress);

		List<Emp> list = repo.findByNameOrAddress("SS", "India");
		list.forEach(e -> System.out.println(e));

		List<Emp> list2 = repo.findByAddressIsNull();
		list2.forEach(e -> System.out.println(e));

		List<Emp> than = repo.findByAgeGreaterThan(29);
		than.forEach(e -> System.out.println(e));

		Emp byNameContaining = repo.findByNameContaining("Jone");
		System.out.println(byNameContaining);

		List<Emp> allEmp = repo.getAllEmp();
		allEmp.forEach(e -> System.out.println(e));
	}
}
