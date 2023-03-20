package com.masked.MaskedAccountNumber.Service;

import org.springframework.stereotype.Service;

import com.masked.MaskedAccountNumber.Model.AccountNumberResponse;
import com.masked.MaskedAccountNumber.customException.CustomException;

@Service
public class MaskedAccountNumberService {

	public AccountNumberResponse maskAccountNumber(String accountNumber) {
		if(accountNumber==null || accountNumber.trim().length()==0) {
			throw new CustomException("604", "Account number is empty or null");
		}else if(accountNumber.length()< 16) {
			throw new CustomException("601","Account Number lesser than 16 digits");
			}else if(accountNumber.length()>16) {
				throw new CustomException("602","Account Number greater than 16 digits");
				}
		try {
			String maskedAccountNumber1 = maskAccountNumber(accountNumber,4);
			String maskedAccountNumber2 = maskAccountNumber(accountNumber, 6);
			return new AccountNumberResponse(maskedAccountNumber1, maskedAccountNumber2);
			}catch(Exception e) {
				throw new CustomException("603", "Something went wrong while masking account number");
				}
		}

	public String maskAccountNumber(String accountNumber, int firstMaskedDigits) {
		char ch[]=accountNumber.toCharArray();
		for(int i=firstMaskedDigits;i< 16-(8-firstMaskedDigits);i++) {
			if(Character.isDigit(ch[i])) {	
				ch[i]='X';
			}
		}
		return new String(ch);
	}

}
