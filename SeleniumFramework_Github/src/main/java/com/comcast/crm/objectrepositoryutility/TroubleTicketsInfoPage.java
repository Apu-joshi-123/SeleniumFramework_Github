package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketsInfoPage {

	public TroubleTicketsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//span[@class='dvHeaderText']")
	private WebElement headerInfo;
	
	public WebElement getHeaderInfo() {
		return headerInfo;
	}
}
