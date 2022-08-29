package com.coats.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import coatsDigital.WebDriverSession;

public class HomePage{
	
	public HomePage() {
		PageFactory.initElements(WebDriverSession.getWebDriverSession(), this);
	}
	@FindBy(xpath= "//li[@data-cy='account']")
	public WebElement account;
	
	@FindBy(id = "webklipper-publisher-widget-container-notification-close-div")
	public WebElement closeBanner;
	
	@FindBy(id = "webklipper-publisher-widget-container-notification-frame")
	public WebElement frame;
	
	public By bannerFrame() {
		return By.id("webklipper-publisher-widget-container-notification-frame");
	}
	
	public By banner() {
		return By.id("second-img");
	}
	
	@FindBy(xpath = "//li[@data-cy='oneWayTrip']")
	public WebElement oneWayTrip ;

	@FindBy(xpath = "//span[text()='DEPARTURE']")
	public WebElement selectDate;
	
	@FindBy(id= "fromCity")
	public WebElement fromCity ;
	
	@FindBy(xpath= "//input[@placeholder=\"From\"]")
	public WebElement inputFromCity;
	
	@FindBy(id= "toCity")
	public WebElement toCity ;
	
	@FindBy(xpath= "//input[@placeholder=\"To\"]")
	public WebElement inputToCity;
		
	@FindBy(xpath = "//p[text()='Delhi, India']")
	public WebElement selectDelhi ;
	
	@FindBy(xpath = "//p[text()='Bengaluru, India']")
	public WebElement selectBangaluru ;
	
	@FindBy(xpath = "//label[@for=\"departure\"]")
	public WebElement departure ;
	
	@FindBy(xpath = "//label[@for=\"return\"]")
	public WebElement Return ;
	
	@FindBy(xpath = "//p[@data-cy=\"submit\"]")
	public WebElement search ;
	
	public WebElement selectNextMonthDate(String date) {
		return WebDriverSession.getWebDriverSession().findElement(By.xpath("//div[@class=\"DayPicker-Month\"][2]//p[text()='"+ date +"']"));
	}
	
	@FindBy(xpath = "//p[@data-cy=\"departureDate\"]")
	public WebElement departureDate;

}
