package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {

	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Lead...']")
	private WebElement createLeadBtn;

	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteBtn;

	public WebElement getCreateLeadBtn() {
		return createLeadBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

}
