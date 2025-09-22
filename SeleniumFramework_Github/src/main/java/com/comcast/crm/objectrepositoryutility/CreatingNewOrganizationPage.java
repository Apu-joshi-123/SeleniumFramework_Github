package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatingNewOrganizationPage {

	WebDriver driver;

	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement orgname;

	@FindBy(name = "industry")
	private WebElement industryDropdown;

	@FindBy(name = "accounttype")
	private WebElement typeDropdown;

	@FindBy(id = "phone")
	private WebElement phoneNumber;
	
	@FindBy (xpath = "//input[@class='crmbutton small save']")
	private WebElement saveButton;

	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}

	public void createOrg(String organizationName) {
		orgname.sendKeys(organizationName);
		saveButton.click();
	}
	
	public void handleDropdown(String organizationName, String idropdown, String tdropdown) {
		orgname.sendKeys(organizationName);
		WebDriverUtility wu = new WebDriverUtility();
		wu.select(industryDropdown, idropdown);
		wu.select(typeDropdown, tdropdown);
		saveButton.click();
	}
}
