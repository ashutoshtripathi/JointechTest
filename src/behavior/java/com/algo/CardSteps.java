package com.algo;

import junit.framework.Assert;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class CardSteps {

		private CreditCardValidator cardValidator;
		private String cardNum;
		private String result;

		@Given("a card number $cardNum")
		public void acardNum(String cardNum) {
			cardValidator = new CreditCardValidator();
			this.cardNum = cardNum; 
		}

		@When("we find whether is valid or not $cardNum")
		public void validateCard(String cardNum) {
			result = cardValidator.validate(cardNum);
		}

	
		@Then("the card is $result")
		public void assertResult(String cardNum) {
			Assert.assertEquals("Card Validation failed", cardNum, result);
		}
}
