package com.comcast.crm.troubleticketstest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.baseclass.BaseClass_Parallel;
import com.comcast.crm.objectrepositoryutility.CreatingNewTroubleTicket;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.TroubleTicketPage;
import com.comcast.crm.objectrepositoryutility.TroubleTicketsInfoPage;

public class CreateTroubleTickets extends BaseClass_Parallel{

	@Test
	public void createTroubleTickets() throws EncryptedDocumentException, IOException {
		String LASTNAME = eu.getDataFromExcel("TroubleTickets", 1, 2) + ju.getRandomNumber();
		// Create Trouble Tickets
				HomePage hp = new HomePage(driver);
				hp.getTroubleTicketsLink().click();
				TroubleTicketPage cp = new TroubleTicketPage(driver);
				cp.getCreateTicketBtn().click();
				CreatingNewTroubleTicket cnc = new CreatingNewTroubleTicket(driver);
				cnc.createTickets(LASTNAME);

				// Verify the Header
				TroubleTicketsInfoPage cip = new TroubleTicketsInfoPage(driver);
				String header = cip.getHeaderInfo().getText();
				Assert.assertEquals(header, LASTNAME);
	}
}
