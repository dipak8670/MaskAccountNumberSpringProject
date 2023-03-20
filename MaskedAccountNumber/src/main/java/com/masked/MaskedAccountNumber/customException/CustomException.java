package com.masked.MaskedAccountNumber.customException;

import org.springframework.stereotype.Component;

@Component
public class CustomException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorString;
	
	public String getErrorCode() {
		return errorCode;
	}
	
	public String getErrorString() {
		return errorString;
	}

	public CustomException(String code, String error) {
		super();
		this.errorCode=code;
		this.errorString=error;
	}
	public CustomException() {
		
	}


}
