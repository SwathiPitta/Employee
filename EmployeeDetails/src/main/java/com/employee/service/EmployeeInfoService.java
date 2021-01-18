package com.employee.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.employee.bean.EmployeeDetails;
import com.employee.bean.EmployeeInfo;
import com.employee.response.EDResponse;

@Service
public interface EmployeeInfoService {

	EDResponse saveEmployee(EmployeeDetails employeeDet, HttpServletRequest request);

	EDResponse updateEmployee(EmployeeDetails employeeDet, HttpServletRequest request);

	Iterable<EmployeeInfo> getAllEmployee();

	EmployeeDetails getEmployeeById(long id, HttpServletRequest request);

	EDResponse deleteEmployee(long id, HttpServletRequest request);

}
