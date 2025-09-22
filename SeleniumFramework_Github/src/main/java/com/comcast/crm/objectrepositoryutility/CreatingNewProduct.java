package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProduct {

	public CreatingNewProduct(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name="productname")
	private WebElement productNameField;

	@FindBy (xpath="//input[@class='crmbutton small save']")
	private WebElement saveBtn;

	public WebElement getProductNameField() {
		return productNameField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createProduct(String name) {
		productNameField.sendKeys(name);
		saveBtn.click();
	}
}
