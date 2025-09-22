package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createProductBtn;

	@FindBy(xpath = "//input[@class='crmbutton small delete']")
	private WebElement deleteBtn;

	public WebElement getCreateProductBtn() {
		return createProductBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

}
