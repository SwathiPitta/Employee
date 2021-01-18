package com.employee.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.bean.EmployeeDetails;
import com.employee.bean.EmployeeInfo;
import com.employee.constant.EDSuccessCode;
import com.employee.constant.EDSuccessMessage;
import com.employee.repository.EmployeeInfoRepo;
import com.employee.response.EDResponse;
import com.employee.response.EDResult;
import com.employee.service.EmployeeInfoService;
@Service
@Transactional
public class EmployeeInfoServiceImpl implements EmployeeInfoService{

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeInfoServiceImpl.class);

	@Autowired
	EmployeeInfoRepo employeeInfoRepo;
	
	@Override
	public EDResponse saveEmployee(EmployeeDetails employeeDet, HttpServletRequest request) {
		LOG.info("Request Body"+employeeDet);
		EDResponse response = new EDResponse();
		EDResult result = new EDResult();
		EmployeeInfo empInfo = new EmployeeInfo();
		try {
		empInfo.setFirstName(employeeDet.getFirstName());
		empInfo.setLastName(employeeDet.getLastName());
		empInfo.setEmailId(employeeDet.getEmailId());
		empInfo.setAddress(employeeDet.getAddress());
		empInfo.setAge(employeeDet.getAge());
		empInfo.setGender(employeeDet.getGender());
		employeeInfoRepo.save(empInfo);
		result.setCode(EDSuccessCode.EMPLOYEE_ADDED);
		result.setMessage(EDSuccessMessage.EMPLOYEE_ADDED);
		response.setResult(result);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			LOG.error("Error occured in service impl ====="+ex);
		}
		
		return response;
	}

	@Override
	public EDResponse updateEmployee(EmployeeDetails employeeDet, HttpServletRequest request) {
		EDResponse response = new EDResponse();
		EDResult result = new EDResult();
		try {
		EmployeeInfo details = employeeInfoRepo.findById(employeeDet.getId());
		details.setFirstName(employeeDet.getFirstName());
		details.setLastName(employeeDet.getLastName());
		details.setEmailId(employeeDet.getEmailId());
		details.setAge(employeeDet.getAge());
		details.setAddress(employeeDet.getAddress());
		details.setGender(employeeDet.getGender());
		employeeInfoRepo.save(details);
		result.setCode(EDSuccessCode.EMPLOYEE_UPDATED);
		result.setMessage(EDSuccessMessage.EMPLOYEE_UPDATED);
		response.setResult(result);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			LOG.error("Error occured in service impl ====="+ex);
		}
		return response;
	}

	@Override
	public Iterable<EmployeeInfo> getAllEmployee() {
		Iterable<EmployeeInfo> details=null;
		try {
		 details = employeeInfoRepo.findAll();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			LOG.error("Error occured in service impl ====="+ex);
		}
		return details;

	}

	@Override
	public EmployeeDetails getEmployeeById(long id, HttpServletRequest request) {
		LOG.info("id : "+id);
		EmployeeDetails empDet =null;
		try {
		EmployeeInfo details = employeeInfoRepo.findById(id);
			
				empDet = new EmployeeDetails();
				empDet.setId(details.getId());
				empDet.setFirstName(details.getFirstName());
				empDet.setLastName(details.getLastName());
				empDet.setEmailId(details.getEmailId());
				empDet.setAge(details.getAge());
				empDet.setAddress(details.getAddress());
				empDet.setGender(details.getGender());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			LOG.error("Error occured in service impl ====="+ex);
		}
		return empDet;
		
	}

	@Override
	public EDResponse deleteEmployee(long id, HttpServletRequest request) {
		EDResponse response = new EDResponse();
		EDResult result = new EDResult();
		try {
		 employeeInfoRepo.deleteById(id);
		result.setCode(EDSuccessCode.EMPLOYEE_DELETED);
		result.setMessage(EDSuccessMessage.EMPLOYEE_DELETED);
		response.setResult(result);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			LOG.error("Error occured in service impl ====="+ex);

		}
		return response;
	}

}
