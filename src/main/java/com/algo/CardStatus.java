package com.algo;

public enum CardStatus {

	//Here we can enter keys for message translation
	INVALID("invalid","Invalid card"),
	VALID("valid", "Valid card"),
	ALPHAERROR("alphaError","Alphabetic chars not allowed"),
	INVALIDFORMAT("invalidFormat", "Invalid card format entered");
	
	String code;
	String message;
	
	private CardStatus(String code, String message) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
