package com.newtours.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightCOnfirmationPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = ".//font[contains(text(),'Flight Itinerary Page')]")
	public WebElement fightItineryMsg;
	
	@FindBy(xpath = ".//font[contains(text(),'USD')]")
	public List<WebElement> flightPrice;
	
	
	public FlightCOnfirmationPage(WebDriver driver){
		
		this.driver =driver;
		this.wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
		
	}
	
	public void checkFLightCOnfirmationMsg(){
		this.fightItineryMsg.isDisplayed();
		String flightPrice = this.flightPrice.get(1).getText();
		System.out.println("The flight price is "+flightPrice);
	}
	
	

}
