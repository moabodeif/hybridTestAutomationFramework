package base;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilities.Helper;

/**
 * It's used to lunch the browser, reports and external files
 * 
 * @author Mohamed Gamal Abou-Daif
 *
 */
public class Base {
	public static WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;	
	String method;

	@BeforeClass
	@Parameters({"browser"})
	public static WebDriver startDriver(@Optional("chrome") String browser) {

		if(Constants.broswerName.equalsIgnoreCase(Constants.chrome)) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+Constants.chromePath);
			driver = new ChromeDriver();
		}
		else if (Constants.broswerName.equalsIgnoreCase(Constants.firefox)) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+Constants.firefoxPath);
			driver = new FirefoxDriver();
		}
		else if (Constants.broswerName.equalsIgnoreCase(Constants.ie)) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+Constants.iePath);
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		return driver;
	}

@BeforeTest
public void report() {
	htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + Constants.reportPath));
	extent = new ExtentReports();
	extent.attachReporter(htmlReporter);
}
@BeforeMethod
public void method(Method method) {
	parentTest = extent.createTest(method.getName());
}
@AfterClass
public void stopDriver() {
	driver.quit();
	extent.flush();
}
//take Screenshot when test case fail and add it to Screenshot folder
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed");
			System.out.println("Taking Screenshot...");
			Helper.captureScreenshot(driver, result.getName());

		}
	}
}
