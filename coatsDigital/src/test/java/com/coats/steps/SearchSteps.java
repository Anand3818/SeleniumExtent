package com.coats.steps;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import com.coats.page.SearchPage;

import coatsDigital.BaseStep;

public class SearchSteps {
	
	public static SearchPage searchPage = new SearchPage();
	
	private static void waitForPageLoad() {
		BaseStep.Waits.waitForElementVisibility(searchPage.searchResultContainer);
	}
	
	private static void scrollThePage() {
		for (int i = 1; i < 100; i++) {
			BaseStep.Debugs.scrollToBottom();
		}
	}
	
	public static void setFilterOneStop() {
		BaseStep.Waits.waitForElementToPresent(searchPage.stopsFromOnStopBy());
//		BaseStep.Clicks.clickElement(searchPage.stopsFromOneStop());
	}
	
	public static String minPrice() {
		String price = searchPage.minPrice.getText();
		return price.substring(2, price.length());
	}
	
	public static String flightCount() {
		return searchPage.oneStop.getText().replace(" ", "")
				.replace("1Stop", "")
				.replace("(", "")
				.replace(")", "");
	}
	
	public static ArrayList<Integer> getFlightPrice() {
		ArrayList<Integer> prices = new ArrayList<Integer>();
		
		waitForPageLoad();
		scrollThePage();
		for(WebElement flights : searchPage.flightPrices) {
			String price = flights.getText();
			System.out.println("&&&&" + price);
			String pr = price.substring(2, price.length()).replace(",", "");
			System.out.println("&&&&" + pr);
			int pric = Integer.parseInt(pr);
			System.out.println("****" + pric);
			prices.add(pric);
		}
		System.out.println(prices);
		return prices;
	}
	

}
