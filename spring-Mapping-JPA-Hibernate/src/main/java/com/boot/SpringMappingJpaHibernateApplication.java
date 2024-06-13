package com.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.boot.Repository.*;
import com.boot.entity.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringMappingJpaHibernateApplication implements CommandLineRunner {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private PhoneNumberRepo phoneNumberRepo;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private EmpRepository empRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringMappingJpaHibernateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // OneToOne relationship
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setNumber("987655789");

        Person person = new Person();
        person.setName("sun");
        person.setPhoneNumber(phoneNumber);
        phoneNumber.setPerson(person);

        personRepo.save(person);
        System.out.println("Person and PhoneNumber saved successfully");

        List<Person> list = personRepo.findAll();
        list.forEach(e -> System.out.println(e.getName() + ": " + e.getPhoneNumber().getNumber()));

        // ManyToOne relationship
        Student student = new Student();
        student.setName("S%L");

        Address address1 = new Address();
        address1.setCity("USA");
        address1.setStudent(student);

        Address address2 = new Address();
        address2.setCity("INDIA");
        address2.setStudent(student);

        Address address3 = new Address();
        address3.setCity("JAPAN");
        address3.setStudent(student);

        student.setAddresses(List.of(address1, address2, address3));

        studentRepository.save(student);
        System.out.println("Student and Addresses saved successfully");

        List<Student> students = studentRepository.findAll();
        students.forEach(s -> {
            System.out.println(s.getName() + ": ");
            s.getAddresses().forEach(a -> System.out.println(a.getCity()));
        });

     // ManyToMany relationship
        Emp emp1 = new Emp("Rum");
        Emp emp2 = new Emp("Sham");

        // Create projects
        Project project1 = new Project("ChatBot");
        Project project2 = new Project("Hotel Management");

        // Associate employees with projects
        emp1.addProject(project1);
        emp2.addProject(project2);

        // Save employees (which will cascade to projects due to CascadeType.ALL)
        empRepository.save(emp1);
        empRepository.save(emp2);

        System.out.println("Employees and Projects saved successfully");
    }
}
           