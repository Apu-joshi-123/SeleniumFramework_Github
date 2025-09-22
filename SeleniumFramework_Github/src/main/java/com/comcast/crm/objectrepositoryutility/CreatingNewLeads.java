package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewLeads {

	public CreatingNewLeads(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement lastnameField;

	@FindBy(name = "company")
	private WebElement companyField;

	@FindBy(xpath = "//input[@class='crmButton small save']")
	private WebElement saveBtn;

	public WebElement getLastnameField() {
		return lastnameField;
	}

	public WebElement getCompanyField() {
		return companyField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createLeads(String lastname, String company) {
		lastnameField.sendKeys(lastname);
		companyField.sendKeys(company);
		saveBtn.click();
	}

}
