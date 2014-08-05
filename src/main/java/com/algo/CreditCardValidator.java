package com.algo;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Ashutosh.Tripathi
 * @date Aug 5, 2014
 */

public class CreditCardValidator {
	
	/**
	 * This method validate the 16 digit credit card information
	 * @param cardNum is credit card number
	 * @return card validation status code
	 */
    public String validate(String cardNum) {
    	
    	CardStatus status = isValidCardNumber(cardNum);
    	if(status != CardStatus.VALID){
    		return status.getCode();//Can return code or error message
    	}
    	cardNum = cardNumberTrimmer(cardNum);
    	int sumOfDigits = 0;
		for (int i = cardNum.length()-1;  i>= 0 ; i=i-1) {
			int value = Integer.valueOf(cardNum.substring(i, i+1));
			
			//Since we are not reversing so we need to double each odd index value(to acheive alternate doubling)
			if(i % 2 == 0 ){	
				value = value*2;	
			}
			sumOfDigits = sumOfDigits + sumValues(value);
		}
		
		if(sumOfDigits % 10 == 0){
			return CardStatus.VALID.getCode();
		}
		
		return CardStatus.INVALID.getCode();
    }
    
    /**
     * This method returns digit sum i.e. 15 = 1+5=6
     * @param values
     * @return
     */
	private int sumValues(int values){
		if(values <= 9){
			return values;
		}
		int digitValue = 0;
		while(values != 0){
			digitValue = digitValue + (values % 10);
			values = values /10;			
		}	
		return digitValue;
	}
    
    /**
     * This method checks for card number validity (format)
     * @param cardNumber
     * @return
     */
    private CardStatus isValidCardNumber(String cardNumber){
    	if(cardNumber == null || cardNumber.isEmpty()){
    		return CardStatus.INVALIDFORMAT;
    	}
 
    	cardNumber = cardNumberTrimmer(cardNumber);
		if(StringUtils.isAlpha(cardNumber)){
    		return CardStatus.ALPHAERROR;
    	}else if(cardNumber.length() != 16){
			return CardStatus.INVALIDFORMAT;
		}
    	return CardStatus.VALID;
    }

    /**
     * This method trims and removes spaces and '-' from cardNumber
     * @param cardNumber
     * @return
     */
	private String cardNumberTrimmer(String cardNumber) {
		//Replace all spaces and '-'
		cardNumber = cardNumber.replaceAll(" ", "");
		cardNumber = cardNumber.replaceAll("-", "");
		return cardNumber;
	}
}
