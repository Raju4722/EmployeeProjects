package com.EmpManSystem.backend.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class EEntity {
	
	public EEntity(int empid, String empname, int salary, int experience, String location, List<PEntity> emptoproj,
			List<REntity> emptorep) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.salary = salary;
		this.experience = experience;
		this.location = location;
		this.emptoproj = emptoproj;
		this.emptorep = emptorep;
	}
	public EEntity() {
		super();
	}
	@Id
	private int empid;
	private String empname;
	private int salary;
	private int experience;
	private String location;
	
	@OneToMany(mappedBy ="emppro")
	@JsonIgnore
	private List<PEntity> emptoproj;
	@OneToMany(mappedBy = "empid")
	@JsonIgnore
	private List<REntity> emptorep;
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "EEntity [empid=" + empid + ", empname=" + empname + ", salary=" + salary + ", experience=" + experience
				+ ", location=" + location + ", emptoproj=" + emptoproj + ", emptorep=" + emptorep + "]";
	}
	public List<PEntity> getEmptoproj() {
		return emptoproj;
	}
	public void setEmptoproj(List<PEntity> emptoproj) {
		this.emptoproj = emptoproj;
	}
	public List<REntity> getEmptorep() {
		return emptorep;
	}
	public void setEmptorep(List<REntity> emptorep) {
		this.emptorep = emptorep;
	}
	
	
	

}
