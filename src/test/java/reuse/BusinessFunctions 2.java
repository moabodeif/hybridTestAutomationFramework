package reuse;

import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

import base.Base;
import base.Constants;
import frameworkEngine.Engine;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.SignUpPage;

/**
 * used to Implement the Business Functions
 * 
 *
 */

public class BusinessFunctions {
	
	WebDriver driver;
	Engine aDriver;
	Faker fakeData = new Faker();
	String name = fakeData.name().firstName();
	String email = name + Constants.emailData;
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
		aDriver.click(HomePage.myAccountButton, Constants.myAccount);
		aDriver.click(HomePage.signupButton, Constants.signUp);
	}
	
	public void signUpPageActions() throws Exception {
		aDriver.type(SignUpPage.firstNameField, Constants.firstNameData, Constants.firstName);
		aDriver.type(SignUpPage.lastNameField, Constants.lastNameData, Constants.lastName);
		aDriver.type(SignUpPage.mobileNumberField, Constants.mobileNumberData, Constants.mobileNumber);
		aDriver.type(SignUpPage.emailField, email, Constants.email);
		aDriver.type(SignUpPage.passwordField, Constants.passwordData, Constants.password);
		aDriver.type(SignUpPage.confirmPasswordField, Constants.passwordData, Constants.confirmPassword);
		aDriver.scrollBy(Constants.scrollBy);
		aDriver.click(SignUpPage.signup, Constants.signUp);
	}
	public void myAccountPageActions() throws Exception{
		aDriver.httpInterceptor();
		aDriver.isElePresent(HomePage.myAccountButton, Constants.myAccount);
		aDriver.click(HomePage.myAccountButton, Constants.myAccount);
		aDriver.click(MyAccountPage.logout, Constants.logout);
	}
	public void loginPageActions() throws Exception {
		aDriver.type(LoginPage.emailField2, email, Constants.email);
		aDriver.type(LoginPage.passwordField2, Constants.passwordData, Constants.password);
		aDriver.click(LoginPage.login, Constants.login);
	}
}
