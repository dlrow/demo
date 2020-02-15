package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bo.SubjectBo;
import com.demo.config.DbChannel;
import com.demo.config.entity.Subject;

@Service
public class SubjectService {

	@Autowired
	DbChannel dbChannel;

	public List<SubjectBo> getAllSubject() {
		List<Subject> subjects = dbChannel.getAllSubjects();
		List<SubjectBo> sbos = new ArrayList<>();
		subjects.forEach(s -> {
			SubjectBo sb = new SubjectBo();
			sb.setDesc(s.getDesc());
			sb.setName(s.getName());
			sb.setSubid(s.getSubjectid());
			sbos.add(sb);
		});
		return sbos;
	}

	
	public void deleteSubid(Integer subid) {
		dbChannel.deleteSubjectById(subid);
	}

	// @Cacheable(cacheNames = "redisCacheManager", key = "#q.toString()")
	public void saveSubj(String name, String desc) {
		Subject s = new Subject(name, desc);
		dbChannel.saveSubject(s);
	}
}
