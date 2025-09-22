package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatingNewContact {

	WebDriver driver;
	
	public CreatingNewContact(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name="lastname")
	private WebElement lastnameField;
	
	@FindBy (xpath="//input[@name='account_name']/..//img")
	private WebElement organizationFieldBtn;
	
	@FindBy (id="search_txt")
	private WebElement searchField;
	
	@FindBy (xpath="//input[@name='search']")
	private WebElement searchBtn;
	
	@FindBy(id ="jscal_field_support_end_date")
	private WebElement supportEndDateField;
	
	@FindBy (id ="jscal_field_support_start_date")
	private WebElement supportStarDateField;
	
	@FindBy (xpath="//input[@class='crmbutton small save']")
	private WebElement saveBtn;

	public WebElement getLastnameField() {
		return lastnameField;
	}

	public WebElement getOrganizationFieldBtn() {
		return organizationFieldBtn;
	}

	public WebElement getSearchField() {
		return searchField;
	}
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public WebElement getSupportEndDateField() {
		return supportEndDateField;
	}

	public WebElement getSupportStarDateField() {
		return supportStarDateField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createContact(String lastname) {
		lastnameField.sendKeys(lastname);
		saveBtn.click();
	}
	
	public void createContactWithSupportDate(String lastname, String startDate, String endDate) {
		lastnameField.sendKeys(lastname);
		supportStarDateField.clear();
		supportStarDateField.sendKeys(startDate);
		supportEndDateField.clear();
		supportEndDateField.sendKeys(endDate);
		saveBtn.click();
	}
	
	public void searchOrganization (String lastname, String orgname) {
		lastnameField.sendKeys(lastname);
		organizationFieldBtn.click();
		WebDriverUtility wu = new WebDriverUtility();
		wu.switchToTabOnURL(driver, "module=Accounts");
		searchField.sendKeys(orgname);
		searchBtn.click();
	}
}
