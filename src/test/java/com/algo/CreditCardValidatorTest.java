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
        Assert.assertFalse("0 is not a accetable card number", validator.validate("0"));
        Assert.assertFalse("1234 is not a accetable card number", validator.validate("1234"));
        Assert.assertFalse("abcd is not a accetable card number", validator.validate("abcd"));
        Assert.assertTrue("4525555544445555 must be valid card number", validator.validate("4525555544445555"));
        Assert.assertFalse("4525555544445577 is invalid card number", validator.validate("4525555544445577"));
        Assert.assertFalse("Card must be of 16 digits only", validator.validate("452555554444557712212121"));
    }

}
