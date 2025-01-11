package com.EmpManSystem.backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EmpManSystem.backend.entities.PEntity;
import com.EmpManSystem.backend.services.PServicer;

@RestController
public class PController {

	public PController(PServicer serv) {
		super();
		this.serv = serv;
	}

	private PServicer serv;

	@GetMapping("/employee/{id}/projects")
	public List<PEntity> getsall(@PathVariable("id") int id) {
		return serv.gettingall(id);
	}
	@GetMapping("/employee/{id}/project/{id1}")
	public PEntity getones(@PathVariable("id") int id,@PathVariable("id1") int id1) {
		 return serv.gettingones(id,id1);
	}
	@PostMapping("/employee/{id}/project/{id1}")
	public void pushs(@PathVariable("id") int id,@PathVariable("id1") int id1,@RequestBody PEntity enti) {
		serv.pushs(id,id1,enti);
	}
	@DeleteMapping("/employee/{id}/project/{id1}")
	public void delete(@PathVariable("id") int id,@PathVariable("id1") int id1) {
		serv.deletes(id,id1);
}
}
