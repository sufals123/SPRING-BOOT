package com.boot;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.boot.entity.Student;
import com.boot.repository.StudentRepo;

@SpringBootApplication
public class SpringCardApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(SpringCardApplication.class, args);
		StudentRepo repo = context.getBean(StudentRepo.class);
		
		// create student object
		
		/*
		 * Student student = new Student(); student.setName("Jone");
		 * student.setAddress("India");
		 */
		
		// Student save Database......
		
		/*
		 * Student save = repo.save(student);
		 * System.out.println("student save successfully" + save);
		 */
		
		
		// save multiple object.......
		/*
		 * Student student1 = new Student(); student1.setName("sanam");
		 * student1.setAddress("India");
		 * 
		 * Student student2 = new Student(); student2.setName("Puri");
		 * student2.setAddress("Londan");
		 * 
		 * ArrayList<Student> list = new ArrayList<>(); list.add(student1);
		 * list.add(student2);
		 * 
		 * Iterable<Student> saveAll = repo.saveAll(list);
		 * System.out.println("Multiple students saved successfully: " + saveAll);
		 */
		
		// Get Single Student using studentId...
		
		/*
		 * Optional<Student> id = repo.findById(2); System.out.println(id);
		 */
		
		// Get Multiple students.......
		/*
		 * Iterable<Student> all = repo.findAll(); all.forEach(e->{
		 * System.out.println(e); });
		 */
		
		
		// Delete Single Student .....
		/*
		 * repo.deleteById(5); System.out.println("Delete SuccessFully....");
		 */	
	}

}
