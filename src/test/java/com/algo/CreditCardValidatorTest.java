package com.algo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CreditCardValidatorTest {

    private CreditCardValidator validator;

    @Before
    public void setup() {
        validator = new CreditCardValidator();
    }

    @Test
    public void shouldPassValidNumber() {
    	
        assertEquals("0 is not a accetable card number", CardStatus.INVALIDFORMAT.getCode(), validator.validate("0"));
        assertEquals("1234 is not a accetable card number",CardStatus.INVALIDFORMAT.getCode(), validator.validate("1234"));
        assertEquals("abcd is not a accetable card number",CardStatus.ALPHAERROR.getCode(), validator.validate("abcd"));
        assertEquals("4525555544445555 must be valid card number",CardStatus.VALID.getCode(), validator.validate("4525555544445555"));
        assertEquals("4525555544445577 is invalid card number",CardStatus.INVALID.getCode(), validator.validate("4525555544445577"));
        assertEquals("Card must be of 16 digits only", CardStatus.INVALIDFORMAT.getCode(), validator.validate("452555554444557712212121"));
        assertEquals("1234-5678-9012-3452 must be valid card number",CardStatus.VALID.getCode(), validator.validate("1234-5678-9012-3452"));
        assertEquals("1234 5678 9012 3452 must be valid card number",CardStatus.VALID.getCode(), validator.validate("1234 5678 9012 3452"));
    }

}
