package base;

import java.net.MalformedURLException;
import java.net.URL;

import data.LoadProperties;

/**
 * used to Constans Variables
 * 
 *
 */

public class Constants {

	//Config
	public static String broswerName = LoadProperties.config.getProperty("broswer");
	public static String url = LoadProperties.config.getProperty("url");
	public static String scrollBy = LoadProperties.config.getProperty("scrollBy");
	public static String parallel = LoadProperties.config.getProperty("parallel");
	public static String grid = LoadProperties.config.getProperty("grid");
	public static URL gridHubURL() {
		try {
			return new URL(LoadProperties.config.getProperty("gridHubURL"));
		} catch (MalformedURLException e) {
			throw new RuntimeException("Invalid hub url, please correct hub url and run again",e);
		}
	}
	public static boolean isParallelSelected() {
		try {
			String parallel = Constants.parallel;
			return Boolean.parseBoolean(parallel);
		}
		catch (Exception e) {
			return false;
		}
	}
	public static boolean isGridSelected() {
		try {
			String grid = Constants.grid;
			return Boolean.parseBoolean(grid);
		}
		catch (Exception e) {
			return false;
		}
	}
	
	//Homepage
	public static String myAccountButtonlocator = LoadProperties.objectRepo.getProperty("myAccountButton_ID");
	public static String signupButtonlocator = LoadProperties.objectRepo.getProperty("signupButton_xpath");
	
	//Sign Up Page
	public static String firstNameFieldlocator = LoadProperties.objectRepo.getProperty("firstNameField_name");
	public static String lastNameFieldlocator = LoadProperties.objectRepo.getProperty("lastNameField_name");
	public static String mobileNumberFieldlocator = LoadProperties.objectRepo.getProperty("mobileNumberField_name");
	public static String emailFieldlocator = LoadProperties.objectRepo.getProperty("emailField_name");
	public static String passwordFieldlocator = LoadProperties.objectRepo.getProperty("passwordField_name");
	public static String confirmPasswordFieldlocator = LoadProperties.objectRepo.getProperty("confirmPasswordField_name");
	public static String signuplocator = LoadProperties.objectRepo.getProperty("signup_xpath");

	//My Account Page
	public static String myAccountButton2locator = LoadProperties.objectRepo.getProperty("myAccountButton2_xpath");
	public static String logoutlocator = LoadProperties.objectRepo.getProperty("logout_xpath");

	//Login Page
	public static String emailField2locator = LoadProperties.objectRepo.getProperty("emailField2_name");
	public static String passwordField2locator = LoadProperties.objectRepo.getProperty("passwordField2_name");
	public static String loginlocator = LoadProperties.objectRepo.getProperty("login_xpath");

	//Paths
	public static String configPath = LoadProperties.config.getProperty("configPropertiesFilePath");
	public static String objectRepositoryPath = LoadProperties.config.getProperty("objectRepositoryFilePath");
	public static String chromePath = LoadProperties.config.getProperty("chromeDriverPath");
	public static String firefoxPath = LoadProperties.config.getProperty("firefoxDriverPath");
	public static String iePath = LoadProperties.config.getProperty("ieDriverPath");
	public static String reportPath = LoadProperties.config.getProperty("reportPath");
	public static String downloadPath = System.getProperty("user.dir")+LoadProperties.config.getProperty("downloadPath");

	//Keywords
	public static String chrome = LoadProperties.config.getProperty("chrome");
	public static String firefox = LoadProperties.config.getProperty("firefox");
	public static String ie = LoadProperties.config.getProperty("ie");
	public static String node = LoadProperties.config.getProperty("node");
	public static String myAccount = LoadProperties.config.getProperty("myAccount");
	public static String signUp = LoadProperties.config.getProperty("signUp");
	public static String firstName = LoadProperties.config.getProperty("firstName");
	public static String lastName = LoadProperties.config.getProperty("lastName");
	public static String mobileNumber = LoadProperties.config.getProperty("mobileNumber");
	public static String email = LoadProperties.config.getProperty("email");
	public static String password = LoadProperties.config.getProperty("password");
	public static String confirmPassword = LoadProperties.config.getProperty("confirmPassword");
	public static String logout = LoadProperties.config.getProperty("logout");
	public static String login = LoadProperties.config.getProperty("login");
	
	//Test Data
	public static String firstNameData = LoadProperties.testData.getProperty("firstName");
	public static String lastNameData = LoadProperties.testData.getProperty("lastName");
	public static String mobileNumberData = LoadProperties.testData.getProperty("mobileNumber");
	public static String emailData = LoadProperties.testData.getProperty("email");
	public static String passwordData = LoadProperties.testData.getProperty("password");

}
