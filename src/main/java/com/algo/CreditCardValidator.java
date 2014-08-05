package com.algo;

/**
 * 
 * @author Ashutosh.Tripathi
 * @date Aug 5, 2014
 */

public class CreditCardValidator {
	
    public String validate(String input) {
    	
    	CardStatus status = isValidCardNumber(input);
    	if(status != CardStatus.VALID){
    		return status.getCode();
    	}
    	
    	//TODO: Write logic here
		return isValidCardNumber(input).getCode();
    }
    
    
    private CardStatus isValidCardNumber(String cardNumber){
    	//TODO:
    	return CardStatus.INVALID;
    }
}
