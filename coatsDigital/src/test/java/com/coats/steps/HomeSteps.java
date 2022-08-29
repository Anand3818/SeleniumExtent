package com.coats.steps;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.coats.page.HomePage;

import coatsDigital.BaseStep;


public class HomeSteps extends BaseStep {
	
		public static HomePage homePage = new HomePage();
		
	public static void selectOneWayTrip() {
		try {
		BaseStep.Clicks.clickElement(homePage.oneWayTrip);
		} catch(Exception e) {
			BaseStep.Clicks.clickElement(homePage.account);
			BaseStep.Clicks.clickElement(homePage.oneWayTrip);
		}
	}
	
	public static void handleAdvertisementBanner() throws InterruptedException {
		try {
		BaseStep.Waits.waitForElementToPresent(homePage.bannerFrame());
		BaseStep.Iframes.switchToiFrame(homePage.frame);
		BaseStep.Clicks.clickElement(homePage.closeBanner);
		} catch(Exception e) {
			System.out.println("no Banner came");
		} finally {
			BaseStep.Iframes.switchBackToDefaultContent();
			Thread.sleep(1000);
		}
	}

	public static void setToDestination(String to) {
		
//		BaseStep.Clicks.clickElement(homePage.toCity);
		BaseStep.SendKeys.sendKey(homePage.inputToCity,  to);
		BaseStep.SendKeys.sendKey(homePage.inputToCity,  Keys.ARROW_DOWN);
		BaseStep.SendKeys.sendKey(homePage.inputToCity,  Keys.ENTER);
	}

	public static void setFromDestination(String from) {
		BaseStep.Clicks.clickElement(homePage.fromCity);
		BaseStep.SendKeys.sendKey(homePage.inputFromCity,  from);
		BaseStep.SendKeys.sendKey(homePage.inputFromCity,  Keys.ARROW_DOWN);
		BaseStep.SendKeys.sendKey(homePage.inputFromCity,  Keys.ENTER);
	}
	
	public static void setDepartureDateAuto() {
		Date today = new Date();
//		BaseStep.Clicks.clickElement(homePage.departure);
		System.out.println("******" + String.valueOf(today.getDate()));
		BaseStep.Clicks.clickElement(homePage.selectNextMonthDate(String.valueOf(today.getDate())));
	}
	
	public static void search() {
		BaseStep.Clicks.clickElement(homePage.search);		
	}

}
