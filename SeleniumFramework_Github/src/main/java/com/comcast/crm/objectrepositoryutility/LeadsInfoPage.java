package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsInfoPage {

	public LeadsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerInfo;

	@FindBy(id = "mouseArea_Last Name")
	private WebElement lastnameInfo;

	@FindBy(id = "mouseArea_Company")
	private WebElement company;

	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getLastnameInfo() {
		return lastnameInfo;
	}

	public WebElement getCompany() {
		return company;
	}

}
