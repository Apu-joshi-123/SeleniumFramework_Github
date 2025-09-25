package com.comcast.crm.campaignstest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;

/**
 * This class is used to create the campaigns.
 * @author Apurva
 */
public class CreateCampaigns extends BaseClass {

	/**
	 * This method is used to create the campaigns by entering the details.
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
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
		
	}
	
}
