package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewTroubleTicket {

	public CreatingNewTroubleTicket(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name="ticket_title")
	private WebElement titleField;
	
	@FindBy (xpath="//input[@class='crmButton small save']")
	private WebElement saveBtn;

	public WebElement getTitleField() {
		return titleField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createTickets(String title) {
		titleField.sendKeys(title);
		saveBtn.click();
	}
}
