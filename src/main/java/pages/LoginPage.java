package pages;

import org.openqa.selenium.By;

import base.Constants;

/**
 * It's used to Login Page Locators
 * 
 *
 */
public class LoginPage {
	
	public static By emailField2 = By.name(Constants.emailField2locator);
	public static By passwordField2 = By.name(Constants.passwordField2locator);
	public static By login = By.xpath(Constants.loginlocator);
}
