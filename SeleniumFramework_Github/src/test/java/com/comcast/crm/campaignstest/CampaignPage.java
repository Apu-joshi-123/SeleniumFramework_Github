package com.comcast.crm.campaignstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement createCampaignBtn;

	@FindBy(name = "campaignname")
	private WebElement campaignName;

	@FindBy(xpath = "//input[@class='crmButton small save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//input[@value='Mass Edit']")
	private WebElement massEditBtn;

	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getMassEditBtn() {
		return massEditBtn;
	}

}
