package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPg {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(partialLinkText = "Flights")
	private WebElement FlightsLink;
	
	
	
	public RegistrationConfirmationPg(WebDriver driver){
		this.driver =driver;
		this.wait = new WebDriverWait(driver, 20);
		
		PageFactory.initElements(driver, this);
	}
	public void flightClick(){
		this.wait.until(ExpectedConditions.visibilityOf(FlightsLink));
		this.FlightsLink.click();
	
		
	}
}
