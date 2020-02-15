package com.demo.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.config.entity.Subject;


@Configuration
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
