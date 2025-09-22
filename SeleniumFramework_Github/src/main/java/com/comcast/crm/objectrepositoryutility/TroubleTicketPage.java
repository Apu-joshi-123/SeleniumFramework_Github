package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketPage {
	
	public TroubleTicketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//img[@alt='Create Ticket...']")
	private WebElement createTicketBtn;
	
	@FindBy(xpath="//input[@class='crmbutton small delete']")
	private WebElement deleteBtn;

	public WebElement getCreateTicketBtn() {
		return createTicketBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	
}
