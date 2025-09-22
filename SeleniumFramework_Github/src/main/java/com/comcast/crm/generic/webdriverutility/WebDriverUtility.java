package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is used to perform WebDriver related actions
 * 
 * @author Apurva
 */
public class WebDriverUtility {

	/**
	 * This method is used for Implicit wait (wait for page to get loaded)
	 * 
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	/**
	 * This method is used to maximize the browser
	 * 
	 * @param driver
	 */
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used for Explicit Wait(wait till the element loads)
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to switch the driver control by verifying URL
	 * 
	 * @param driver
	 * @param partialURL
	 */
	public void switchToTabOnURL(WebDriver driver, String partialURL) {
		Set<String> child = driver.getWindowHandles();
		Iterator<String> it = child.iterator();
		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actURL = driver.getCurrentUrl();
			if (actURL.contains(partialURL)) {
				break;
			}
		}
	}

	/**
	 * This method is used to switch the driver control by verifying Title
	 * 
	 * @param driver
	 * @param partialTitle
	 */
	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> child = driver.getWindowHandles();
		Iterator<String> it = child.iterator();
		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actTitle = driver.getTitle();
			if (actTitle.contains(partialTitle)) {
				break;
			}
		}
	}

	/**
	 * This method is used to switch the frame by using index method
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switch the frame by using Name/ID method
	 * 
	 * @param driver
	 * @param nameID
	 */
	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}

	/**
	 * This method is used to switch the frame by using WebElement method
	 * 
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method is used to switch to Alert and accept the Pop-up
	 * 
	 * @param driver
	 */
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to switch to Alert and dismiss the Pop-up
	 * 
	 * @param driver
	 */
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method is used to handle drop down by using selectByVisibleText Method
	 * 
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * This method is used to handle drop down by using selectByValue Method
	 * 
	 * @param element
	 * @param value
	 */
	public void selectByValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * This method is used to handle drop down by using selectByIndex Method
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * This method is used to perform mouse-hover action
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * This method is used to click on an element using Actions class
	 * @param driver
	 * @param element
	 */
	public void clickOnElement (WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.click(element).perform();
	}
	
	/**
	 * This method is used to close the browser
	 * 
	 * @param driver
	 */
	public void closeTheBrowser(WebDriver driver) {
		driver.quit();
	}

}
