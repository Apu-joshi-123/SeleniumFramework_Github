package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerInfo;
	
	@FindBy(id = "mouseArea_Industry")
	private WebElement industry;
	
	@FindBy (id="mouseArea_Phone")
	private WebElement phoneNum;
	
	@FindBy (id="mouseArea_Type")
	private WebElement type;

	public WebElement getHeaderInfo() {
		return headerInfo;
	}
	
	public WebElement getIndustry() {
		return industry;
	}
	
	public WebElement getType() {
		return type;
	}
	
	public WebElement getPhoneNum() {
		return phoneNum;
	}
}
