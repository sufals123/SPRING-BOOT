package com.boot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
