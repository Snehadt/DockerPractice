package com.duckduckgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class duckduckGoPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(id="search_form_input_homepage")
	private WebElement serachThis;
	
	@FindBy(id="search_button_homepage")
	private WebElement searchBtn;
	
	public duckduckGoPage(WebDriver driver){
		this.driver =driver;
		this.wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
		
	}
	
	public void searchCriteria(String serachWhat){
		this.driver.get("https://duckduckgo.com/");
		this.wait.until(ExpectedConditions.elementToBeClickable(serachThis));
		this.serachThis.sendKeys(serachWhat);
		this.searchBtn.click();
		
	}

}
