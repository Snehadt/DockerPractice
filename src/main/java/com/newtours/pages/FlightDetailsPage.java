package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name ="passCount")
	private WebElement passengerCOunt;
	
	@FindBy(name ="findFlights")
	private WebElement continueBtn;
	
	
	
	public FlightDetailsPage(WebDriver driver){
	this.driver =driver;
	this.wait = new WebDriverWait(driver, 20);
	PageFactory.initElements(driver, this);
	}
	
	public void enterPassangerNum(String noOfPasseneger){
		this.wait.until(ExpectedConditions.elementToBeClickable(passengerCOunt));
		Select select =new Select(passengerCOunt);
		select.selectByVisibleText(noOfPasseneger);
		
	}
	
	public void gotoFlightSelectionPage(){
		this.continueBtn.click();
	}
}
