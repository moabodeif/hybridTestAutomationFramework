package reuse;

import org.openqa.selenium.WebDriver;

import base.Base;
import base.Constants;
import frameworkEngine.Engine;
import pages.HomePage;
import pages.SecondPage;
import pages.ThirdPage;

/**
 * It's used to Implement the Business Functions
 * 
 *
 */

public class BusinessFunctions {
	
	WebDriver driver;
	Engine aDriver;
	
	public BusinessFunctions() 
	{
		driver = Base.driver;
		aDriver = new Engine();
	}

	public void gotoApplication() throws Exception
	{
		aDriver.navigateToApp(Constants.url);
		
	}
	
	public void homePageActions() throws Exception 
	{
		
		aDriver.isElePresent(HomePage.textBar, Constants.searchBarElement);
		aDriver.type(HomePage.textBar, Constants.searchKeyword, Constants.searchBarElement);
		aDriver.selectByVisibleText(HomePage.searchSuggestions, Constants.searchKeyword);
		aDriver.click(HomePage.pageNumber2, Constants.pageNumber2);
	}
	
	public void secondPage() throws Exception {
		aDriver.isElePresent(SecondPage.pageNumber3, Constants.pageNumber3);
		aDriver.click(SecondPage.pageNumber3, Constants.pageNumber3);
	}
	public void thirdPage() throws Exception {
		aDriver.Validate(SecondPage.suggestionResults2, ThirdPage.suggestionResults3);
	}
}
