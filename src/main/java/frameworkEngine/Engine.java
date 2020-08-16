package frameworkEngine;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.Base;

/**
 * used to Drive the Framework
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
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
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
	 * used to Get Text from Text box and Text area
	 * @param locator  
	 * @param testData 
	 * @throws Exception
	 */

	public String getText(By locator, String testData) throws Exception{
		try {
			testData = driver.findElement(locator).getText();
			Base.childTest.pass("Text is  :" +testData);
			return testData;

		} catch (Exception e) {
			Base.childTest.fail("Unable to return Text" ,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			Base.childTest.info(e);
			return null;
		}
	}
	
	/**
	 * Perform Mouse hover on given element
	 * @param Locator
	 * @param eleName  
	 * @throws Exception
	 */

	public void mouseHover(By Locator, String eleName) throws Exception{
		try {
			Actions act = new Actions(driver);
			WebElement ele = driver.findElement(Locator);
			act.moveToElement(ele).build().perform();
			Thread.sleep(2000);
			Base.childTest.pass("Successfully mouse hover on : "+eleName);

		} catch (Exception e) {
			Base.childTest.fail("Unable to mouse hover on : "+eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			Base.childTest.info(e);
			throw e;
		}
	}
	
	/**
	 * Perform Mouse hover and click on submenu
	 * @param menuLocator
	 * @param subMenuLocator  
	 * @param menu
	 * @param subMenu 
	 * @throws Exception
	 */

	public void mouseHoverAndClickSubMenu(By menuLocator, By subMenuLocator, String menu, String subMenu) throws Exception{
		try {
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(menuLocator);
			action.moveToElement(element).build().perform();
			Thread.sleep(2000);
			driver.findElement(subMenuLocator).click();
			Base.childTest.pass("Successfully mouse hover on Menu: "+menu+" and clicked on subMenu: "+subMenu);

		} catch (Exception e) {
			System.out.println("Element is not present");
			Base.childTest.fail("Unable to mouse hover on Menu: "+menu+" and Unable to click on subMenu: "+subMenu ,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			Base.childTest.info(e);
			throw e;
		}
	}
	
	/**
	 * return true if vsibleText From Dropdown Menu
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
	 * Select By Value From Dropdown Menu
	 * @param locator  - get it from Object Repository
	 * @param Value  
	 * @throws Exception
	 */

	public void selectByValue(By locator, String Value) throws Exception{
		try {
			WebElement element = driver.findElement(locator);
			Select select = new Select(element);
			select.selectByValue(Value);
			Base.childTest.pass("Selected :" +Value+ " from Suggestions");

		} catch (Exception e) {
			Base.childTest.pass("Unable to Selected :" +Value+ " from Suggestions" ,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			Base.childTest.info(e);
			throw e;
		}
	}
	/**
	 * Scroll By
	 * @param locator  - get it from Object Repository
	 * @param Value  
	 * @throws Exception
	 */

	public void scrollBy(String Value) throws Exception{
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver ;
			js.executeScript(Value);
			Base.childTest.pass("Scrolled " +Value);

		} catch (Exception e) {
			Base.childTest.pass("Unable to Scroll : " +Value,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			Base.childTest.info(e);
			throw e;
		}
	}
	/**
	 * HTTP Interceptor
	 * @throws Exception
	 */
	public void httpInterceptor() throws Exception{
		int status = -1;
		try {
	        String currentURL = driver.getCurrentUrl();
	        LogEntries logs = driver.manage().logs().get("performance");
	        for (Iterator<LogEntry> it = logs.iterator(); it.hasNext();)
	        {
	            LogEntry entry = it.next();
	            try
	            {
	                JSONObject json = new JSONObject(entry.getMessage());
	                System.out.println(json.toString());
	                JSONObject message = json.getJSONObject("message");
	                String method = message.getString("method");
	                if (method != null
	                        && "Network.responseReceived".equals(method))
	                {
	                    JSONObject params = message.getJSONObject("params");
	                    JSONObject response = params.getJSONObject("response");
	                    String messageUrl = response.getString("url");
	                    if (currentURL.equals(messageUrl))
	                    {
	                        status = response.getInt("status");

	                        System.out.println(
	                                "---------- bingo !!!!!!!!!!!!!! returned response for "
	                                        + messageUrl + ": " + status);
	                        System.out.println(
	                                "---------- bingo !!!!!!!!!!!!!! headers: "
	                                        + response.get("headers"));
	                    }
	                }
	            } catch (JSONException e)
	            {
	                e.printStackTrace();
	            }
	        }
			Base.childTest.pass("status code: " +status);
		} catch (Exception e) {
			Base.childTest.pass("Unable to response : " +status,
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
	 * @throws IOException
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
