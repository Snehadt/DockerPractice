package com.duckduckgo.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.Testbase.BaseClass;
import com.duckduckgo.pages.duckduckGoPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class duckDuckGoTest extends BaseClass {
	
	
	@Test
	@Parameters({"keyWord"})
	public void enterSearch(String keyWord ){
		duckduckGoPage du =new duckduckGoPage(driver);
		du.searchCriteria(keyWord);
	}
	
	

}
