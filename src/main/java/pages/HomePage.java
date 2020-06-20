package pages;

import org.openqa.selenium.By;

import base.Constants;

/**
 * It's used to Home Page Locators
 * 
 *
 */

public class HomePage {
	
	public static By textBar = By.name(Constants.textBarlocator);
	public static By searchSuggestions = By.xpath(Constants.searchSuggestionslocator);
	public static By pageNumber2 = By.xpath(Constants.pageNumber2locator);
}
