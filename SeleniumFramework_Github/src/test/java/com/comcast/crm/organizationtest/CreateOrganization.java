package com.comcast.crm.organizationtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class CreateOrganization extends BaseClass {

	@Test(groups = "SmokeTest")
	public void createOrganization() throws EncryptedDocumentException, IOException {
		// Read Data from Excel
		String ORGNAME = eu.getDataFromExcel("Organization", 1, 2) + ju.getRandomNumber();

		// Navigate and Create Contact
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();
		OrganizationPage cp = new OrganizationPage(driver);
		cp.getCreateOrganization().click();
		CreatingNewOrganizationPage cnc = new CreatingNewOrganizationPage(driver);
		cnc.createOrg(ORGNAME);

		// Verify Header
		OrganizationInfoPage cip = new OrganizationInfoPage(driver);
		String header = cip.getHeaderInfo().getText();
		Assert.assertEquals(header, ORGNAME);
	}

	@Test(groups = "RegressionTest")
	public void createOrganizationWithIndustry() throws EncryptedDocumentException, IOException {
		// Read Data from Excel
		String ORGNAME = eu.getDataFromExcel("Organization", 7, 2) + ju.getRandomNumber();
		String INDUSTRY = eu.getDataFromExcel("Organization", 7, 3);
		String TYPE = eu.getDataFromExcel("Organization", 7, 4);

		// Navigate and Create Organization
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganization().click();
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.handleDropdown(ORGNAME, INDUSTRY, TYPE);

		// Verify the Header
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderInfo().getText();
		Assert.assertEquals(actOrgName, ORGNAME);
		
		// Verify industry
		String actIndustry = oip.getIndustry().getText();
		SoftAssert assertobj = new SoftAssert();
		assertobj.assertEquals(actIndustry, INDUSTRY);

		// Verify type
		String actType = oip.getType().getText();
		assertobj.assertEquals(actType, TYPE);
		assertobj.assertAll();
	}

	@Test(groups = "RegressionTest")
	public void createOrganizationWithPhoneNumber() throws EncryptedDocumentException, IOException {
		// Read Data from Excel
		String ORGNAME = eu.getDataFromExcel("Organization", 4, 2) + ju.getRandomNumber();
		String PHONENUM = eu.getDataFromExcel("Organization", 4, 3);

		// Navigate and Create Contact
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();
		OrganizationPage cp = new OrganizationPage(driver);
		cp.getCreateOrganization().click();
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.getOrgname().sendKeys(ORGNAME);
		cnop.getPhoneNumber().sendKeys(PHONENUM);
		cnop.getSaveButton().click();

		// Verify Header
		OrganizationInfoPage cip = new OrganizationInfoPage(driver);
		String header = cip.getHeaderInfo().getText();
		Assert.assertEquals(header, ORGNAME);

		// Verify Phone Number
		String actPhoneNum = cip.getPhoneNum().getText();
		SoftAssert assertobj = new SoftAssert();
		assertobj.assertEquals(actPhoneNum, PHONENUM);
		assertobj.assertAll();
	}
}
