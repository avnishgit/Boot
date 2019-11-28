package com.ag.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ag.domain.EmployeeDetails;
import com.ag.entity.EmployeeEntity;
import com.ag.repositries.EmployeeRepositres;

@Service
public class EmployeeMgmt {
	
	@Autowired
	private EmployeeRepositres employeeRepositres;
	
	public EmployeeDetails getEmployeeDetail(Long eid){
		
	Optional<EmployeeEntity> optional=	employeeRepositres.findById(eid);
	if(optional.isPresent()) {
		EmployeeEntity employeeEntity = optional.get();
		EmployeeDetails details = new EmployeeDetails();
		BeanUtils.copyProperties(employeeEntity, details);
		
		return details;
	}
		return null;
	
		
	}
	public boolean saveEmployeeDetail(EmployeeDetails details) {
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(details, entity);
		EmployeeEntity saveEntity= employeeRepositres.save(entity);
		return saveEntity.getEid()>0;
	}
}
