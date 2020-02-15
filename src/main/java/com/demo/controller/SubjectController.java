package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bo.SubjectBo;
import com.demo.service.SubjectService;

import io.swagger.annotations.Api;

@Api(value = "Subject")
@RestController
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	SubjectService subjectService;

	@RequestMapping(value = "/v1/saveSub", method = RequestMethod.POST)
	public String saveSubject(@RequestParam(value = "name") String name,
			@RequestParam(value = "description") String desc) throws InterruptedException {
		subjectService.saveSubj(name, desc);
		return "ok";
	}

	@RequestMapping(value = "/v1/deleteSubject", method = RequestMethod.DELETE)
	public String deleteSub(@RequestParam(name = "subid") Integer subid) throws InterruptedException {
		subjectService.deleteSubid(subid);
		return "Deleted";
	}
	
	@RequestMapping(value = "/v1/getAllSubjects", method = RequestMethod.GET)
	public ResponseEntity<List<SubjectBo>> findAll() throws InterruptedException {
		return ResponseEntity.ok().body(subjectService.getAllSubject());
	}


	
}
