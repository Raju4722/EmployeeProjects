package com.EmpManSystem.backend.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class REntity {
	

	public REntity() {
		super();
	}

	public REntity(int reportno, EEntity empid, PEntity projectid, LocalDateTime createdAt, String description) {
		super();
		this.reportno = reportno;
		this.empid = empid;
		this.projectid = projectid;
		this.createdAt = createdAt;
		Description = description;
	}

	@Id
	
	private int reportno;
	
	@ManyToOne
	@JsonIgnore
	private EEntity empid;
	
	@ManyToOne
	@JsonIgnore
	private PEntity projectid;
	
	private LocalDateTime createdAt;
private String Description;
	public int getReportno() {
		return reportno;
	}

	public void setReportno(int reportno) {
		this.reportno = reportno;
	}

	public EEntity getEmpid() {
		return empid;
	}

	public void setEmpid(EEntity empid) {
		this.empid = empid;
	}

	public PEntity getProjectid() {
		return projectid;
	}

	public void setProjectid(PEntity projectid) {
		this.projectid = projectid;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	
	@PrePersist
	public void prepersis() {
		this.createdAt=LocalDateTime.now();
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "REntity [reportno=" + reportno + ", empid=" + empid + ", projectid=" + projectid + ", createdAt="
				+ createdAt + ", Description=" + Description + "]";
	}

}
