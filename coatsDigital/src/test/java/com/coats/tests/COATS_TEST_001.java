package com.coats.tests;

import java.util.ArrayList;

import org.testng.annotations.*;

import com.coats.steps.HomeSteps;
import com.coats.steps.SearchSteps;

import coatsDigital.BaseTest;
import coatsDigital.WebDriverSession;
import coatsDigital.WebDriverSession.WebDriverSteps;

public class COATS_TEST_001 extends BaseTest{
	
	@BeforeTest
	public void openApplication() {
		WebDriverSteps.openApplication("https://www.makemytrip.com/");
	}
	
	@Test
	public void coats_test_001() throws InterruptedException {
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		HomeSteps.selectOneWayTrip();
		HomeSteps.handleAdvertisementBanner();
		HomeSteps.setFromDestination("Delhi");
		HomeSteps.setToDestination("Bangalore");
		HomeSteps.setDepartureDateAuto();
		HomeSteps.search();
		
		SearchSteps.setFilterOneStop();
		String FlightCount = SearchSteps.flightCount();
		String MinimumPrice = SearchSteps.minPrice();
		
		System.out.println("Flight Count : " + FlightCount);
		System.out.println("MinimumPrice : " + MinimumPrice);
	}
	
	@AfterTest
	public void closeSession() {
		WebDriverSteps.closeBrowser();
	}

}
