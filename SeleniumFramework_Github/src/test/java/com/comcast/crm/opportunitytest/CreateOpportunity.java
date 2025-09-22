package com.comcast.crm.opportunitytest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.baseclass.BaseClass_Parallel;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContact;
import com.comcast.crm.objectrepositoryutility.CreatingNewOpportunity;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OpportunitiesInfoPage;
import com.comcast.crm.objectrepositoryutility.OpportunityPage;

public class CreateOpportunity extends BaseClass_Parallel {

	@Test
	public void createOpportunity() throws Throwable, IOException {
		String OPPORTUNITY = eu.getDataFromExcel("Opportunity", 1, 2) + ju.getRandomNumber();
		String CONTACTS = eu.getDataFromExcel("Opportunity", 1, 3) + ju.getRandomNumber();

		// Create Contacts
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContact().click();
		CreatingNewContact cnc = new CreatingNewContact(driver);
		cnc.createContact(CONTACTS);

		// Navigate and create Opportunity Using Company
		hp.getOpportunitiesLink().click();
		OpportunityPage op = new OpportunityPage(driver);
		op.getCreateOpportunityBtn().click();
		CreatingNewOpportunity cno = new CreatingNewOpportunity(driver);
		cno.createOpportunity(OPPORTUNITY, CONTACTS);
		driver.findElement(By.xpath("//a[contains(text(),'" + CONTACTS + "')]")).click();

		// Switch to Parent Window
		wu.switchToTabOnURL(driver, "module=Potentials");
		cno.getSaveBtn().click();

		// Verify the Header
		OpportunitiesInfoPage oip = new OpportunitiesInfoPage(driver);
		String header = oip.getHeaderInfo().getText();
		Assert.assertEquals(header, OPPORTUNITY);

		// Verify the Contacts
		String contactname = oip.getRelatedToInfo().getText();
		SoftAssert assertobj = new SoftAssert();
		assertobj.assertEquals(contactname, CONTACTS);
		assertobj.assertAll();

	}
}
