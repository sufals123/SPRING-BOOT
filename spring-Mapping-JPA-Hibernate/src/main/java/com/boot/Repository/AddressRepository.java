package com.boot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}