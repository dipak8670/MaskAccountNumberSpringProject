package com.masked.MaskedAccountNumber.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.masked.MaskedAccountNumber.Model.AccountNumberResponse;
import com.masked.MaskedAccountNumber.Service.MaskedAccountNumberService;
import com.masked.MaskedAccountNumber.customException.CustomException;

@RestController
public class MaskedAccountNumberController {
	@Autowired
	private MaskedAccountNumberService maskedAccountNumberService;
	
	@GetMapping("/mask/{accountNumber}")
	public ResponseEntity<?> getMaskedAccountNumber(@PathVariable(required=false) String accountNumber){
		try{
			AccountNumberResponse response = maskedAccountNumberService.maskAccountNumber(accountNumber);
			System.out.println("Masked Account Number for operation1: "+response.getMaskedAccountNumber1());
			System.out.println("Masked Account Number for operation2: "+response.getMaskedAccountNumber2());
			return new ResponseEntity<AccountNumberResponse>(response,HttpStatus.OK);
		}catch(CustomException e) {
			System.out.println(e.getErrorString());
			return new ResponseEntity<CustomException>(e,HttpStatus.BAD_REQUEST);
		}
	}
}
