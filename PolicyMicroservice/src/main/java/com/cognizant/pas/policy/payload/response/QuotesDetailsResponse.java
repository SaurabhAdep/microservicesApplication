package com.cognizant.pas.policy.payload.response;

/**
 * Quotes Details Response POJO Class
 */
public class QuotesDetailsResponse {
	
	private String quotes;

	public QuotesDetailsResponse() {
		super();
	}

	public QuotesDetailsResponse(String quotes) {
		super();
		this.quotes = quotes;
	}

	public String getQuotes() {
		return quotes;
	}

	public void setQuotes(String quotes) {
		this.quotes = quotes;
	}

	@Override
	public String toString() {
		return "QuotesDetailsResponse [quotes=" + quotes + "]";
	}

	
}
