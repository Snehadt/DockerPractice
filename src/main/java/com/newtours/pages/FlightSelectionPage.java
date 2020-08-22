package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightSelectionPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	@FindBy(name="reserveFlights")
	public WebElement reserveFLight_continue;
	
	@FindBy(name="buyFlights")
	public WebElement buyFlights_continue;
	
	
	public FlightSelectionPage(WebDriver driver){
		this.driver=driver;
		this.wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void gotoBillingAddPage(){
		this.wait.until(ExpectedConditions.visibilityOf(reserveFLight_continue));
		this.reserveFLight_continue.click();
	}
	
	public void buyFlightPage(){
		this.wait.until(ExpectedConditions.visibilityOf(buyFlights_continue));
		this.buyFlights_continue.click();
	}

}
