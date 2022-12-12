package com.cognizant.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
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
