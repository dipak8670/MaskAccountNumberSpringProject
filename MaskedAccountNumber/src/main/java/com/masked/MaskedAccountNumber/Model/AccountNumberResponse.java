package com.masked.MaskedAccountNumber.Model;

public class AccountNumberResponse {
	    private String maskedAccountNumber1;
	    private String maskedAccountNumber2;

	    public AccountNumberResponse(String maskedAccountNumber1, String maskedAccountNumber2) {
	        this.maskedAccountNumber1 = maskedAccountNumber1;
	        this.maskedAccountNumber2 = maskedAccountNumber2;
	    }

	    public String getMaskedAccountNumber1() {
	        return maskedAccountNumber1;
	    }

	    public String getMaskedAccountNumber2() {
	        return maskedAccountNumber2;
	    }	

}
		