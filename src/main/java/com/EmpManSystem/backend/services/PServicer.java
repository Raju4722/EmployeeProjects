package com.EmpManSystem.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.EmpManSystem.backend.entities.EEntity;
import com.EmpManSystem.backend.entities.ERepository;
import com.EmpManSystem.backend.entities.PEntity;
import com.EmpManSystem.backend.entities.PRepository;

@Service
public class PServicer {
	public PServicer(ERepository erepo, PRepository prepo) {
		super();
		this.erepo = erepo;
		this.prepo = prepo;
	}

	private ERepository erepo;
	private PRepository prepo;
	public List<PEntity> gettingall(int id) {
		List<PEntity> all = prepo.findAll();
		all.stream().filter(a->a.getEmppro().getEmpid()==id);
		return all;
	}
	public void pushs(int id, int id1, PEntity enti) {
		EEntity byId = erepo.findById(id).orElse(null);
		if(byId != null) {
			enti.setProjid(id1);
			enti.setEmppro(byId);
			prepo.save(enti);
		}
	}
	public void deletes(int id, int id1) {
     EEntity orElse = erepo.findById(id).orElse(null);		
     if(orElse!=null) {
    	 PEntity byId = prepo.findById(id1).orElse(null);
    	 if(byId.getEmppro().getEmpid()==id) {
    		 prepo.deleteById(id1);
    	 }
     }
	}
	public PEntity gettingones(int id, int id1) {
		  EEntity orElse = erepo.findById(id).orElse(null);		
		     if(orElse!=null) {
		    	 PEntity byId = prepo.findById(id1).orElse(null);
		    	 if(byId.getEmppro().getEmpid()==id) {
		    		return  prepo.findById(id1).orElse(null);
		    	 }		
	}
			return null;
}
}
