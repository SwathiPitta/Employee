package com.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.bean.EmployeeInfo;

@Repository
public interface EmployeeInfoRepo extends CrudRepository<EmployeeInfo, Long>{

	EmployeeInfo findById(@Param("id") long id);

	void deleteById(@Param("id") long id);
	
}
