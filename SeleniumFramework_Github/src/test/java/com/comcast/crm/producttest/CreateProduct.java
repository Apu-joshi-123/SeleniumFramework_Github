package com.comcast.crm.producttest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.baseclass.BaseClass_Parallel;
import com.comcast.crm.objectrepositoryutility.CreatingNewProduct;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.ProductInfoPage;
import com.comcast.crm.objectrepositoryutility.ProductPage;

public class CreateProduct extends BaseClass_Parallel {

	@Test
	public void createProduct() throws Throwable, IOException {

		String PRONAME = eu.getDataFromExcel("Product", 1, 2) + ju.getRandomNumber();
		// Create Product
		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();
		ProductPage cp = new ProductPage(driver);
		cp.getCreateProductBtn().click();
		CreatingNewProduct cnc = new CreatingNewProduct(driver);
		cnc.createProduct(PRONAME);

		// Verify the Header
		ProductInfoPage cip = new ProductInfoPage(driver);
		String header = cip.getHeaderInfo().getText();
		Assert.assertEquals(header, PRONAME);
	}
}
