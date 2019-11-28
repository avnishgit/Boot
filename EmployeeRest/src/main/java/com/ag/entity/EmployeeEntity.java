package com.ag.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_detail")
public class EmployeeEntity {
	@Id
	
	private Integer eid;
	private String name;
	private String desg;
	private String email;
	private String add;
	private float sal;
}
