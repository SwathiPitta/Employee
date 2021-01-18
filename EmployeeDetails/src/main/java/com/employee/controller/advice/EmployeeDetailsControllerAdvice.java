package com.employee.controller.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.employee.constant.EDErrorCode;
import com.employee.constant.EDErrorMessage;
import com.employee.response.EDResponse;
import com.employee.response.ErrorResponse;

@ControllerAdvice(basePackages = { "com.employee.controller" })

public class EmployeeDetailsControllerAdvice extends ResponseEntityExceptionHandler{

	public static final Logger LOG = LoggerFactory.getLogger(EmployeeDetailsControllerAdvice.class);

	@ResponseStatus(HttpStatus.ACCEPTED)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public EDResponse hadleException(Exception e) {
		LOG.error(e.getMessage(), e);
		EDResponse resp = new EDResponse();
		ErrorResponse errResp = generateErrorResponse(EDErrorCode.EMPLOYEE_EXCEPTION,
				EDErrorMessage.EMPLOYEE_EXCEPTION);
		resp.setError(errResp);
		return resp;
	}
	
	

	private ErrorResponse generateErrorResponse(String errorCode, String errorMessage) {
		ErrorResponse response = new ErrorResponse();
		response.setCode(errorCode);
		response.setMessage(errorMessage);
		return response;
	}
}
