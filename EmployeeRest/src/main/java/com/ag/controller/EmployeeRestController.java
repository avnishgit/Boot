package com.ag.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ag.domain.EmployeeDetails;

@RestController
public class EmployeeRestController {

	@GetMapping(value = "/getemp{/id}")
	public ResponseEntity<EmployeeDetails>getEmployee( @PathVariable("id")  Integer id){
		return  ;
		
	}
}
