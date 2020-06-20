package frameworkEngine;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.Base;

/**
 * It's used to Drive the Framework
 * 
 *
 */

public class Engine {

	WebDriver driver;
	public Engine() {
		driver = Base.driver;
	}

	/**
	 * used to Navigate to Application
	 * @param url URL is reading from config.properties file
	 * @throws Exception
	 */

	public void navigateToApp(String url) throws Exception{
		try {
			driver.get(url);
			Base.childTest.pass("Successfully navigate to App :" +url);

		} catch (Exception e) {
			Base.childTest.fail("Unable to navigate to App :");
			throw e;
		}
	}

	/**
	 * used to perform click on Buttons, Links, RB, Check boxes
	 * @param locator  - get it from Object Repository
	 * @param eleName   - Name of the Element
	 * @throws Exception
	 */

	public void click(By locator, String eleName) throws Exception{
		try {
			driver.findElement(locator).click();
			Base.childTest.pass("Successfully performed click on :" +eleName);

		} catch (Exception e) {
			Base.childTest.fail("Unable to performed click on :" +eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			Base.childTest.info(e);
			throw e;
		}
	}

	/**
	 * used to perform type Action in Text box and Text area
	 * @param locator  
	 * @param testData 
	 * @throws Exception
	 */

	public void type(By locator, String testData, String eleName) throws Exception{
		try {
			driver.findElement(locator).sendKeys(testData);
			Base.childTest.pass("Performed type in  :" +eleName+ " with data : "+testData);

		} catch (Exception e) {
			System.out.println("Element is not present");
			Base.childTest.fail("Unable to Performed type in  :" +eleName+ " with data : "+testData ,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			Base.childTest.info(e);
			throw e;
		}
	}

	/**
	 * it will return true if vsibleText From Dropdown Menu
	 * @param locator  - get it from Object Repository
	 * @param vsibleText  
	 * @throws Exception
	 */

	public void selectByVisibleText(By locator, String vsibleText) throws Exception{
		try {
			List<WebElement> options = driver.findElements(locator);
			for(int i=0;i<options.size();i++) {
				String listItems = options.get(i).getText();
				if(listItems.contentEquals(vsibleText)) {
					options.get(i).click();
					break;
				}
			}
			Base.childTest.pass("Selected :" +vsibleText+ " from Suggestions");

		} catch (Exception e) {
			Base.childTest.pass("Unable to Selected :" +vsibleText+ " from Suggestions" ,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			Base.childTest.info(e);
			throw e;
		}
	}

	/**
	 * used to Assert Expected Value Equal Actual Value or not
	 * @param locator  
	 * @param fristValue
	 * @param secondValue 
	 * @throws Exception
	 */

	public void Validate(By fristLocator,By secondLocator) throws Exception{

		int fristValue = driver.findElements(fristLocator).size();
		int secondValue = driver.findElements(secondLocator).size();
		
		if(fristValue == secondValue) 
		{
			Base.childTest.pass("Second Value "+secondValue+" is equal to Frist Value : "+fristValue);
		}
		else
		{
			Base.childTest.fail("Second Value "+secondValue+" is not equal to Frist Value :" +fristValue,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			throw new Exception();
		}
	}

	/**
	 * it will return true if Element is the present otherwise false
	 * @param locator  - get it from Object Repository
	 * @param eleName   - Name of the Element
	 * @throws Exception
	 */

	public boolean isElePresent(By locator, String eleName) throws IOException{
		try {
			driver.findElement(locator);
			Base.childTest.pass("Element :" +eleName+ " is present");
			return true;

		} catch (Exception e) {
			System.out.println("Element is not present");
			Base.childTest.pass("Element :" +eleName+ " is not present" ,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			return false;
		}
	}

	public String screenShot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
}
