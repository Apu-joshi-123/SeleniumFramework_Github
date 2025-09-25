package com.comcast.crm.troubleticketstest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewTroubleTicket;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.TroubleTicketPage;
import com.comcast.crm.objectrepositoryutility.TroubleTicketsInfoPage;

/**
 * This Class is used to Create Tickets and Verify the information.
 * 
 * @author Apurva
 */
public class CreateTroubleTickets extends BaseClass {

	/**
	 * This method is used to Create Tickets and Verify the information.
	 * 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	@Test
	public void createTroubleTickets() throws EncryptedDocumentException, IOException {

		/* Read data from Excel */
		String LASTNAME = eu.getDataFromExcel("TroubleTickets", 1, 2) + ju.getRandomNumber();

		/* Create Trouble Tickets */
		HomePage hp = new HomePage(driver);
		hp.getTroubleTicketsLink().click();
		TroubleTicketPage cp = new TroubleTicketPage(driver);
		cp.getCreateTicketBtn().click();
		CreatingNewTroubleTicket cnc = new CreatingNewTroubleTicket(driver);
		cnc.createTickets(LASTNAME);

		/* Verify the Header */
		TroubleTicketsInfoPage cip = new TroubleTicketsInfoPage(driver);
		String header = cip.getHeaderInfo().getText();
		boolean status = header.contains(LASTNAME);
		Assert.assertEquals(status, true);
	}
}
