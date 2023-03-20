package com.masked.MaskedAccountNumber.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.masked.MaskedAccountNumber.customException.CustomException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaskedAccountNumberServiceTest {
	@Autowired
	private MaskedAccountNumberService service;

	@Test
    public void testMaskAccountNumberOperation1() {
        String input = "123456AB78CD9012";
        String expectedOutput = "1234XXABXXCD9012";
        String actualOutput = service.maskAccountNumber(input, 4);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testMaskAccountNumberOperation2() {
        String input = "123456AB78CD9012";
        String expectedOutput = "123456ABXXCDXX12";
        String actualOutput = service.maskAccountNumber(input, 6);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testMaskAccountNumberNullInput() {
        String input = null;
        CustomException exception;
         exception = assertThrows(CustomException.class, () -> {
        	service.maskAccountNumber(input);
        });
         assertEquals("604", exception.getErrorCode());
        
    }
    
    @Test
    public void testMaskAccountNumberEmptyInput() {
        String input = "";
        CustomException exception;
        exception = assertThrows(CustomException.class, () -> {
       	service.maskAccountNumber(input);
       });
        assertEquals("604", exception.getErrorCode());
    }
    
    @Test
    public void testMaskAccountNumberNonNumericInput() {
        String input = "ABCDEFGHABCDEFGH";
        String expectedOutput = "ABCDEFGHABCDEFGH";
        String actualOutput = service.maskAccountNumber(input, 4);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testMaskAccountGreaterThan16() {
        String input = "1234-56-AB78CD9012";
        CustomException exception = assertThrows(CustomException.class, () -> {
           	service.maskAccountNumber(input);
           });
            assertEquals("602", exception.getErrorCode());
    }
    @Test
    public void testMaskAccountLesserThan16() {
        String input = "1234-56";
        CustomException exception = assertThrows(CustomException.class, () -> {
           	service.maskAccountNumber(input);
           });
            assertEquals("601", exception.getErrorCode());
    }
}
