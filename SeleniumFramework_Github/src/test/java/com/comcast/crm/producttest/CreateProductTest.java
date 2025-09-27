package com.comcast.crm.producttest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewProduct;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.ProductInfoPage;
import com.comcast.crm.objectrepositoryutility.ProductPage;

/**
 * This Class is used to Create Products and Verify the information.
 * 
 * @author Apurva
 */

public class CreateProductTest extends BaseClass {

	/**
	 * This method is used to Create Products and Verify the information.
	 * 
	 * @throws Throwable
	 * @throws IOException
	 */
	@Test
	public void createProduct() throws Throwable, IOException {

		/* Read data from Excel */
		String PRONAME = eu.getDataFromExcel("Product", 1, 2) + ju.getRandomNumber();

		/* Create Product */
		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();
		ProductPage cp = new ProductPage(driver);
		cp.getCreateProductBtn().click();
		CreatingNewProduct cnc = new CreatingNewProduct(driver);
		cnc.createProduct(PRONAME);
		System.out.println("Product Created");

		/* Verify the Header */
		ProductInfoPage cip = new ProductInfoPage(driver);
		String header = cip.getHeaderInfo().getText();
		boolean status = header.contains(PRONAME);
		Assert.assertEquals(status, true);
		System.out.println("Product Verified");
	}
}
