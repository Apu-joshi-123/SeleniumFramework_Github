package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath ="//span[@class='dvHeaderText']")
	private WebElement headerInfo;
	
	@FindBy (xpath="//span[@id='dtlview_Last Name']")
	private WebElement lastnameInfo;
	
	@FindBy (xpath="//td[@id='mouseArea_Organization Name']")
	private WebElement orgInfo;
	
	@FindBy (id="dtlview_Support Start Date")
	private WebElement startDateInfo;
	
	@FindBy (id="dtlview_Support End Date")
	private WebElement endDateInfo;

	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getLastnameInfo() {
		return lastnameInfo;
	}

	public WebElement getOrgInfo() {
		return orgInfo;
	}

	public WebElement getStartDateInfo() {
		return startDateInfo;
	}

	public WebElement getEndDateInfo() {
		return endDateInfo;
	}
	
}
