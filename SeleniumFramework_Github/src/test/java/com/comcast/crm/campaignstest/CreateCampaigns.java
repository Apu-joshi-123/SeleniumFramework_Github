package com.comcast.crm.campaignstest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateCampaigns extends BaseClass {

	@Test
	public void createCampaigns () throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		WebDriverUtility wlib = new WebDriverUtility();
		wlib.mouseHover(driver, hp.getMoreLink());
		wlib.clickOnElement(driver, hp.getCampaignsLink());
		CampaignPage cp = new CampaignPage(driver);
		cp.getCreateCampaignBtn().click();
		String NAME = eu.getDataFromExcel("Campaigns", 1, 2);
		cp.getCampaignName().sendKeys(NAME);
		cp.getSaveBtn().click();
		
		System.out.println("Done done");
	}
	
}
