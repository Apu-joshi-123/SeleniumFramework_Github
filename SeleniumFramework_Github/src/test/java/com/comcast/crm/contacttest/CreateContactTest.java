package com.comcast.crm.contacttest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContact;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

/**
 * This Class is used to Create Contacts using Date and after creating the
 * Organization and Verify the information.
 * 
 * @author Apurva
 */

public class CreateContactTest extends BaseClass {

	/**
	 * This method is used to Create Contacts and Verify the information.
	 * 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	@Test(groups = "SmokeTest")
	public void createContact() throws EncryptedDocumentException, IOException {

		/* Read Data from Excel */
		String LASTNAME = eu.getDataFromExcel("Contacts", 1, 2) + ju.getRandomNumber();

		/* Navigate and Create Contact */
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContact().click();
		CreatingNewContact cnc = new CreatingNewContact(driver);
		cnc.createContact(LASTNAME);
		System.out.println("Contact created");

		/* Verify Header */
		ContactInfoPage cip = new ContactInfoPage(driver);
		String header = cip.getHeaderInfo().getText();
		boolean status = header.contains(LASTNAME);
		Assert.assertEquals(status, true);
		System.out.println("Contact Verified");
	}

	/**
	 * This method is used to Create Contacts after creating Organization and Verify
	 * the information.
	 * 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(groups = "RegressionTest")
	public void createContactWithOrganization() throws EncryptedDocumentException, IOException, InterruptedException {

		/* Read Data from Excel */
		String LASTNAME = eu.getDataFromExcel("Contacts", 7, 2) + ju.getRandomNumber();
		String ORGNAME = eu.getDataFromExcel("Contacts", 7, 3) + ju.getRandomNumber();

		/* Navigate and Create Organization */
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganization().click();
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(ORGNAME);
		Thread.sleep(2000);
		System.out.println("Organization created");

		/* Navigate and Create Contact */
		hp.getContactsLink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContact().click();
		CreatingNewContact cnc = new CreatingNewContact(driver);
		cnc.searchOrganization(LASTNAME, ORGNAME);
		driver.findElement(By.xpath("//a[contains(text(),'" + ORGNAME + "')]")).click();

		/* Switch to Parent Window */
		wu.switchToTabOnURL(driver, "module=Contacts");
		cnc.getSaveBtn().click();
		System.out.println("Contact created");

		/* Verify Header */
		ContactInfoPage cip = new ContactInfoPage(driver);
		String header = cip.getHeaderInfo().getText();
		boolean status = header.contains(LASTNAME);
		Assert.assertEquals(status, true);
		System.out.println("Contact Verified");

		/* Verify the Organization */
		String org = cip.getOrgInfo().getText();
		SoftAssert assertobj = new SoftAssert();
		assertobj.assertEquals(org.trim(), ORGNAME);
		assertobj.assertAll();
		System.out.println("Organization Verified");
	}

	/**
	 * This method is used to Create Contact with Support Date and Verify the
	 * information.
	 * 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	@Test(groups = "RegressionTest")
	public void createContactWithDate() throws EncryptedDocumentException, IOException {

		/* Read Data from Excel */
		String LASTNAME = eu.getDataFromExcel("Contacts", 1, 2) + ju.getRandomNumber();

		/* Navigate and Create Contact */
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContact().click();
		String STARTDATE = ju.getSystemDateYYYYDDMM();
		String ENDDATE = ju.getRequiredDateYYYYMMDD(30);
		CreatingNewContact cnc = new CreatingNewContact(driver);
		cnc.createContactWithSupportDate(LASTNAME, STARTDATE, ENDDATE);
		System.out.println("Contact created");

		/* Verify Header */
		ContactInfoPage cip = new ContactInfoPage(driver);
		String header = cip.getHeaderInfo().getText();
		boolean status = header.contains(LASTNAME);
		Assert.assertEquals(status, true);
		System.out.println("Contact Verified");

		/* Verify Support Date */
		String supportStartDate = cip.getStartDateInfo().getText();
		SoftAssert assertobj = new SoftAssert();
		assertobj.assertEquals(supportStartDate, STARTDATE);
		System.out.println("Support Start Date Verified");

		String supportEndDate = cip.getEndDateInfo().getText();
		assertobj.assertEquals(supportEndDate, ENDDATE);
		assertobj.assertAll();
		System.out.println("Support End Date Verified");
	}
}
