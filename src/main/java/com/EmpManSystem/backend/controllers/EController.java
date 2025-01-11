package com.EmpManSystem.backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EmpManSystem.backend.entities.EEntity;
import com.EmpManSystem.backend.services.EServicer;

@RestController
public class EController {
	private EServicer serv;
	public EController(EServicer serv) {
		super();
		this.serv = serv;
	}
	
    @GetMapping("/employees")
	public List<EEntity> getsall() {
        return serv.gettingall();
	}
    @PostMapping("/employee/{id}")
    public void putting(@RequestBody EEntity enti,@PathVariable("id") int id) {
    	enti.setEmpid(id);
    	serv.puts(enti);
    }
    @GetMapping("/employee/{id}")
    public EEntity getons(@PathVariable("id") int id) {
    	return serv.getsones(id);
    }
    @DeleteMapping("/employee/{id}")
    public void deleteons(@PathVariable("id") int id) {
    	 serv.delones(id);
    }
}
