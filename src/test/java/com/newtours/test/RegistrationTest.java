package com.newtours.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.Testbase.BaseClass;
//import com.beust.jcommander.Parameter;
import com.newtours.pages.FlightCOnfirmationPage;
import com.newtours.pages.FlightDetailsPage;
import com.newtours.pages.FlightSelectionPage;
import com.newtours.pages.RegistrationConfirmationPg;
import com.newtours.pages.RegistrationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationTest extends BaseClass{
	
	public RegistrationPage regPg;
	public String noOfPassangers  ;

	
	@Test
	public void RegistrationpageWork(){

		regPg = new RegistrationPage(driver);
		regPg.gotoSite();
		regPg.enterDetaisl("Sneha", "Dutta");
		regPg.enterCredentails("Snehadt", "abcd");
		regPg.clickSubmit();
	}

	@Test(dependsOnMethods = "RegistrationpageWork")
	
	public void RegistrationCOnfirmationPage(){
		RegistrationConfirmationPg regCon = new RegistrationConfirmationPg(driver);
		regCon.flightClick();
	}

	@Test(dependsOnMethods = "RegistrationCOnfirmationPage")
	@Parameters({"noOfPassangers"})
	public void flightDetails(String noOfPassangers){
		this.noOfPassangers=noOfPassangers;
		FlightDetailsPage flightDetail = new FlightDetailsPage(driver);
		flightDetail.enterPassangerNum(noOfPassangers);
		flightDetail.gotoFlightSelectionPage();

	}

	@Test(dependsOnMethods = "flightDetails")
	public void flightSelectionPage(){
		FlightSelectionPage flightSel  = new FlightSelectionPage(driver);
		flightSel.gotoBillingAddPage();
		flightSel.buyFlightPage();

	}

	@Test(dependsOnMethods = "flightDetails")
	public void flightCOnfirmPage(){
		FlightCOnfirmationPage flightConfirm = new FlightCOnfirmationPage(driver);
		flightConfirm.checkFLightCOnfirmationMsg();
	}

}
