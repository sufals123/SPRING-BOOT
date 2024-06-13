package com.boot.MobileRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Mobile;

public interface MobileRepo extends JpaRepository<Mobile, Integer> {
    
}
