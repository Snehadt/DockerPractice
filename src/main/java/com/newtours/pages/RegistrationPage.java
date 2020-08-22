package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name="firstName")
	private WebElement firstname;
	
	@FindBy(name="lastName")
	private WebElement lastName;
	
	@FindBy(name="email")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement passWord;
	
	@FindBy(name="confirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(name="register")
	private WebElement reg_submit;
	
	
	
	public RegistrationPage(WebDriver driver){
		
		this.driver =driver;
		this.wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
		
	}
	
	public void gotoSite(){
		this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html#");
		this.wait.until(ExpectedConditions.visibilityOf(this.firstname));
	}
	
	public void enterDetaisl(String firstName ,String lastName){
		this.firstname.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		
	}
	
	public void enterCredentails(String username,String Password){
		this.userName.sendKeys(username);
		this.passWord.sendKeys(Password);
	}
	
	public void clickSubmit(){
		this.reg_submit.click();
	}

}
