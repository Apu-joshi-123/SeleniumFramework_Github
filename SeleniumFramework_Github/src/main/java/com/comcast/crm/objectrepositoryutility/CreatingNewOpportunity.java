package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatingNewOpportunity {

	WebDriver driver;
	public CreatingNewOpportunity(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name="potentialname")
	private WebElement opportunityNameField;
	
	@FindBy (id="related_to_type")
	private WebElement relatedTodd;
	
	@FindBy (xpath="//input[@id='related_to_display']/..//img")
	private WebElement contactsSelectBtn;
	
	@FindBy(name="search_text")
	private WebElement searchField;
	
	@FindBy (name="search")
	private WebElement searchBtn;
	
	@FindBy (xpath = "//input[@class='crmbutton small save']")
	private WebElement saveBtn;

	public WebElement getOpportunityNameField() {
		return opportunityNameField;
	}

	public WebElement getRelatedTodd() {
		return relatedTodd;
	}

	public WebElement getContactsSelectBtn() {
		return contactsSelectBtn;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOpportunity(String opportunityName, String name) {
		opportunityNameField.sendKeys(opportunityName);
		WebDriverUtility wdu = new WebDriverUtility();
		wdu.selectByValue(relatedTodd, "Contacts");
		contactsSelectBtn.click();
		wdu.switchToTabOnURL(driver, "module=Contacts");
		searchField.sendKeys(name);
		searchBtn.click();
	}
}
