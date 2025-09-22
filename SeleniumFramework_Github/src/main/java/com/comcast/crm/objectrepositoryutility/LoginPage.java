package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { // Rule-1: Create a separate java class
							// Rule-2: Object Creation
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Rule-3: Object Initialization
	@FindBy(name = "user_name")
	private WebElement usernameField;

	@FindBy(name = "user_password")
	private WebElement passwordField;

	@FindBy(id = "submitButton")
	private WebElement login;

	// Rule-4: Object Encapsulation
	public WebElement getUsername() {
		return usernameField;
	}

	public WebElement getPassword() {
		return passwordField;
	}

	public WebElement getLogin() {
		return login;
	}

	// Rule-5: Provide action
	public void loginToApp(String username, String password) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		Actions action = new Actions(driver);
		action.click(login).perform();
	}

}
