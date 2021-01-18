package com.employee.response;

public class EDResponse {

	private ErrorResponse error;
	private EDResult result;
	
	public ErrorResponse getError() {
		return error;
	}
	public void setError(ErrorResponse error) {
		this.error = error;
	}
	public EDResult getResult() {
		return result;
	}
	public void setResult(EDResult result) {
		this.result = result;
	}
	
	

}
