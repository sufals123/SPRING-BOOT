package com.boot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{

}
