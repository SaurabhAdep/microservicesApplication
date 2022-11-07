package com.cognizant.pas.quotes.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.pas.quotes.models.QuotesMaster;
import com.cognizant.pas.quotes.repository.QuotesMasterRepository;

import lombok.extern.slf4j.Slf4j;


@RestController
public class QuotesController {
	
static Logger log = Logger.getLogger(QuotesController.class);
	
	public QuotesController() {
		PropertyConfigurator.configure("src/main/java/log4j.properties");
	}
	@Autowired
	QuotesMasterRepository quotesMasterRepository;
	
	@GetMapping("/getQuotesForPolicy")
	public String getQuotesForPolicy
	(@Valid @RequestParam Long businessValue,@RequestParam Long propertyValue,@RequestParam String propertyType){
		log.info("Start");
		String quotes;
		try
        {
		QuotesMaster quotesMaster=quotesMasterRepository
				.findByBusinessValueAndPropertyValueAndPropertyType(businessValue, propertyValue, propertyType);
		if(quotesMaster != null)
			log.debug("QuotesMaster: {}"+ quotesMaster);
		quotes=quotesMaster.getQuotes();
        }catch(NullPointerException e) 
        { 
        	log.error("No Quotes, Contact Insurance Provider");
        	quotes= "No Quotes, Contact Insurance Provider";
        	return quotes;  
        } 
		log.info("End");
		return quotes; 
	}
	

}
