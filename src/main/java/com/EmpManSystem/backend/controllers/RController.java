package com.EmpManSystem.backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EmpManSystem.backend.entities.REntity;
import com.EmpManSystem.backend.services.RServicer;

@RestController
public class RController {
	public RController(RServicer serv) {
		super();
		this.serv = serv;
	}

	private RServicer serv;
	
	@GetMapping("/employees/{id}/{id1}")
    public List<REntity> getrepoerts(@PathVariable("id") int id,@PathVariable("id1") int id1) {
    	return serv.getings(id,id1);
    }
	@GetMapping("/employees/repo/{id}")
	public List<REntity> getingrepos(@PathVariable("id") int id){
		return serv.getallrepos(id);
	}
	@PostMapping("/employees/{id}/{id1}/{id2}")
	public void posting(@PathVariable("id") int id,@PathVariable("id1") int id1,@PathVariable("id2") int id2,@RequestBody REntity enti) {
		serv.posts(id,id1,id2,enti);
	}
}
