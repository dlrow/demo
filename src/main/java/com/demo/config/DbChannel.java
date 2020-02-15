package com.demo.config;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.config.entity.Subject;
import com.demo.dao.SubjectRepository;


@Repository
public class DbChannel {
	@Autowired
    DataSource dataSource;
	
	@Autowired
	SubjectRepository subRepo;
	
	public void saveSubject(Subject s) {
		subRepo.save(s);		
	}
	
	

	public void deleteSubjectById(Integer subid) {
		subRepo.deleteById(subid);
	}
	
	public List<Subject> getAllSubjects() {
		return subRepo.findAll();
	}

	public Optional<Subject> getSubjectBySubId(Integer subid) {
		return subRepo.findById(subid);
	}
	
}
