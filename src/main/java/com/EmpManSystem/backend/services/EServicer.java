package com.EmpManSystem.backend.services;

import java.util.List;

import com.EmpManSystem.backend.entities.EEntity;
import com.EmpManSystem.backend.entities.ERepository;
import org.springframework.stereotype.Service;
@Service
public class EServicer {
	private ERepository repo;
	public EServicer(ERepository repo) {
		super();
		this.repo = repo;
	}

	

	public List<EEntity> gettingall() {
		
        return repo.findAll();
        
	}



	public void puts(EEntity enti) {
      repo.save(enti);		
	}



	public EEntity getsones(int id) {
		return repo.findById(id).orElse(null);
		
	}



	public void delones(int id) {
		repo.deleteById(id);
		
	}
    
}
