package com.base.Testbase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected WebDriver driver;
	@BeforeTest
	public void initializethis() throws MalformedURLException{
		
		String host ="localhost";
		DesiredCapabilities cap ;
		
		if(System.getProperty("BROWSER")!=null && System.getProperty("BROWSER").equalsIgnoreCase("FIREFOX")){
			cap = DesiredCapabilities.firefox();
		}
		else{
			cap = DesiredCapabilities.chrome();
		}
		
		if(System.getProperty("HUB_HOST")!=null ){
			host = System.getProperty("HUB_HOST");
		}
		
		String completeURL ="http://"+host+":4444/wd/hub";
		this.driver = new RemoteWebDriver(new URL(completeURL), cap);
		 //driver.manage().window().maximize();
	}
	
	@AfterTest
	public void tearDOwn(){
		this.driver.quit();
	}
}
