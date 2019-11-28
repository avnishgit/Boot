package com.ag.repositries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ag.entity.EmployeeEntity;
@Repository
public interface EmployeeRepositres extends CrudRepository<EmployeeEntity, Long> {

}
