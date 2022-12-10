package pages;

import org.openqa.selenium.By;

import base.Constants;

/**
 * It's used to Second Page Locators
 * 
 *
 */
public class SignUpPage {
	
	public static By firstNameField = By.name(Constants.firstNameFieldlocator);
	public static By lastNameField = By.name(Constants.lastNameFieldlocator);
	public static By mobileNumberField = By.name(Constants.mobileNumberFieldlocator);
	public static By emailField = By.name(Constants.emailFieldlocator);
	public static By passwordField = By.name(Constants.passwordFieldlocator);
	public static By confirmPasswordField = By.name(Constants.confirmPasswordFieldlocator);
	public static By signup = By.xpath(Constants.signuplocator);

}
