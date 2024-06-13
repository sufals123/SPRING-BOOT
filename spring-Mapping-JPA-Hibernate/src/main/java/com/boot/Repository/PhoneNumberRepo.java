package com.boot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.PhoneNumber;

public interface PhoneNumberRepo extends JpaRepository<PhoneNumber, Integer>{

}
