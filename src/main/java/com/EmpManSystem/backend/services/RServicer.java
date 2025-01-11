package com.EmpManSystem.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.EmpManSystem.backend.entities.EEntity;
import com.EmpManSystem.backend.entities.ERepository;
import com.EmpManSystem.backend.entities.PEntity;
import com.EmpManSystem.backend.entities.PRepository;
import com.EmpManSystem.backend.entities.REntity;
import com.EmpManSystem.backend.entities.RRepository;

@Service
public class RServicer {

public RServicer(RRepository rrepo, ERepository erepo, PRepository prepo) {
		super();
		this.rrepo = rrepo;
		this.erepo = erepo;
		this.prepo = prepo;
	}
private RRepository rrepo;
private ERepository erepo;
private PRepository prepo;
    public Boolean checking(int id,int id1) {
    	 EEntity condi1 = erepo.findById(id).orElse(null);
  	   PEntity condi2 = prepo.findById(id1).orElse(null);
  	 if( condi1!=null && condi2!=null) {
  		 return true;
  	 }
		return false;
    	
    }
	public List<REntity> getings(int id, int id1) {
	 
	   if( checking(id,id1)) {
		   return  rrepo.findAll();
	   }
	return null;
		
	}
	public void posts(int id, int id1, int id2, REntity enti) {
     		if(checking(id, id1)) {
     			
     			enti.setEmpid(erepo.findById(id).orElse(null));
     			enti.setProjectid(prepo.findById(id1).orElse(null));
     			rrepo.save(enti);
     		}
	}
	public List<REntity> getallrepos(int id) {
		List<REntity> all = rrepo.findAll();
		all.stream().filter(a->a.getEmpid().getEmpid()==id);
		return all;
		
	}

}
