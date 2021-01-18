package com.employee.response;

import java.util.List;

import com.employee.bean.EmployeeDetails;

public class EmployeeResponse {

	private ErrorResponse error;
	private List<EmployeeDetails> result;
	public ErrorResponse getError() {
		return error;
	}
	public void setError(ErrorResponse error) {
		this.error = error;
	}
	public List<EmployeeDetails> getResult() {
		return result;
	}
	public void setResult(List<EmployeeDetails> result) {
		this.result = result;
	}
	
	
}
