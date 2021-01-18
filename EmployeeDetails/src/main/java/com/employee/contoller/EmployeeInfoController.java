package com.employee.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.bean.EmployeeDetails;
import com.employee.bean.EmployeeInfo;
import com.employee.response.EDResponse;
import com.employee.service.EmployeeInfoService;

@RestController
@RequestMapping(value = "/emp/api/v1", produces = "application/json")
public class EmployeeInfoController {
	@Autowired
	EmployeeInfoService employeeInfoService;
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	private EDResponse saveEmployee(@Valid @RequestBody EmployeeDetails employeeDet, HttpServletRequest request)  {
		return employeeInfoService.saveEmployee(employeeDet,request);
	}
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	private EDResponse updateEmployee(@Valid @RequestBody EmployeeDetails employeeDet, HttpServletRequest request) {
		return employeeInfoService.updateEmployee(employeeDet,request);
	}
	
	@RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET)
	private Iterable<EmployeeInfo> getAllEmployee() {
		return employeeInfoService.getAllEmployee();
	}
	

	@RequestMapping(value = "/getEmployeeById", method = RequestMethod.GET)
	private EmployeeDetails getEmployeeById(@RequestParam("id") long id, HttpServletRequest request) {
		return employeeInfoService.getEmployeeById(id,request);
	}
	
	@RequestMapping(value="/deleteEmployeeById/{id}", method = RequestMethod.DELETE)
	private EDResponse deleteEmployee(@PathVariable long id, HttpServletRequest request) {
		return employeeInfoService.deleteEmployee(id, request);
	}
}
