package com.coats.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import coatsDigital.WebDriverSession;

public class SearchPage {
	
	public SearchPage() {
		PageFactory.initElements(WebDriverSession.getWebDriverSession(), this);
	}
//	@FindBy(xpath = "//div[@class=\"selectDropdown make_relative\"]")
//	public WebElement onewayDropDown;

	@FindBy(xpath="//div[@class=\"append_bottom20 fltOfferWrapper\"]")
	public WebElement searchResultContainer;
	
	@FindBy(xpath="//span[@class=\"actual-price\"]")
	public List<WebElement> flightPrices;
	
//	@FindBy(xpath = "//p[@class=\"filtersHeading append_bottom10 clearfix\" and contains(text(),'Stops From')]")
	public By stopsFromOnStopBy() {
		return By.xpath("//p[contains(text(),'Stops From')]/..//p[text()=\"1 Stop\"]/ancestor::label//span[@class=\"check\"]");
	}
	
	public WebElement stopsFromOneStop() {
		return WebDriverSession.getWebDriverSession().findElement(stopsFromOnStopBy());
	}
	
	@FindBy(xpath ="//p[contains(text(),'Stops From')]/..//p[text()=\"1 Stop\"]")
	public WebElement oneStop;
	
	@FindBy(xpath = "//p[contains(text(),'Stops From')]/..//p[text()=\"1 Stop\"]/../p[2]")
	public WebElement minPrice;
	
	@FindBy(xpath = "(//ul[@class='dropdown-menu Wcustom-scroll'])[1]")
	public WebElement priceDropDown;

	@FindBy(xpath = "//span[@data-filtertext=\"collapsed_stop_oneStop\"]")
	public WebElement checkBoxStop1;

	@FindBy(xpath = "//p[contains(text(), 'Stops From')]/..//p[text()='1 Stop']")
	public WebElement stop1;

	@FindBy(xpath = "(//span/label/div/div/p[2])[2]")
	public WebElement minimumPrice;

}
