package com.EmpManSystem.backend.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PEntity {
	
	public PEntity(int projid, String projname, int alloteddays, String description, EEntity emppro) {
		super();
		this.projid = projid;
		this.projname = projname;
		this.alloteddays = alloteddays;
		this.description = description;
		this.emppro = emppro;
	}
	public PEntity() {
		super();
	}
	
	
	@Id
	private int projid;
	private String projname;
	private int alloteddays;
	private String description;
	@ManyToOne
	@JsonIgnore
	private EEntity emppro;
	public int getProjid() {
		return projid;
	}
	public void setProjid(int projid) {
		this.projid = projid;
	}
	public String getProjname() {
		return projname;
	}
	public void setProjname(String projname) {
		this.projname = projname;
	}
	public int getAlloteddays() {
		return alloteddays;
	}
	public void setAlloteddays(int alloteddays) {
		this.alloteddays = alloteddays;
	}
	
	public EEntity getEmppro() {
		return emppro;
	}
	public void setEmppro(EEntity emppro) {
		this.emppro = emppro;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ProjectEntity [projid=" + projid + ", projname=" + projname + ", alloteddays=" + alloteddays
				+ ", description=" + description + ", emppro=" + emppro + "]";
	}

}
	