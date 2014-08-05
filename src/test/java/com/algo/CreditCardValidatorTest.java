package com.algo;
import junit.framework.Assert;

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
        Assert.assertEquals("0 is not a accetable card number", "invalidFormat", validator.validate("0"));
        Assert.assertEquals("1234 is not a accetable card number","invalidFormat", validator.validate("1234"));
        Assert.assertEquals("abcd is not a accetable card number","alphaError", validator.validate("abcd"));
        Assert.assertEquals("4525555544445555 must be valid card number","valid", validator.validate("4525555544445555"));
        Assert.assertEquals("4525555544445577 is invalid card number","invalid", validator.validate("4525555544445577"));
        Assert.assertEquals("Card must be of 16 digits only", "invalidFormat", validator.validate("452555554444557712212121"));
    }

}
