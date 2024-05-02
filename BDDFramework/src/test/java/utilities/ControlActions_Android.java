package utilities;

import java.time.Duration; 
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;  
import org.openqa.selenium.support.ui.ExpectedConditions; 
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait; 
import io.appium.java_client.android.AndroidDriver;

public class ControlActions_Android {
	AndroidDriver driver;
	static WebDriverWait wait;
	static Wait<AndroidDriver> fluentWait;
	public static Actions action;

	public ControlActions_Android(AndroidDriver driver) {
		this.driver = driver; 
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		action = new Actions(driver);
	}

	/**
	 * This method is used to wait till the given element is visible
	 * 
	 * 
	 * @param e [WebElement] : The element for which wait needs to be performed
	 * @return [WebElement] : The element once it is visible
	 */
	public WebElement waitForVisibility(WebElement e) {
		WebElement element = null;
		try {
			element = wait.until(ExpectedConditions.visibilityOf(e));
			Log.logInfo("Retrived element - " + element + " after waiting for element to be visible");
		} catch (Exception ex) {
			Log.logError("Error while waiting for visibility of element " + ex.getMessage());
		}
		return element;
	}

	/**
	 * This method is used to wait till visibility of element for given amount of
	 * time (in seconds)
	 * 
	 * 
	 * @param e        [WebElement] : The element for which wait needs to be
	 *                 performed
	 * @param waitTime [long] : Time in seconds
	 * @return [WebElement] : The element once it is visible
	 */
	public boolean waitForVisibility(By e, Duration waitTime) {
		WebElement element = null;
		boolean flag=false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(e)));
			flag= true;
			Log.logInfo("Retrived element - " + element + " after waiting for "+ waitTime +" seconds, element to be visible");
		} catch (Exception ex) {
			flag= false;
			Log.logError("Error while waiting for visibility of element for " +waitTime +" seconds " + ex.getMessage());
		}
		return flag;
	}

	/**
	 * This method is used to wait for element to be clickable
	 *
	 * @param e : WebElement to wait for being clickable
	 * @return true if element is clickable else false
	 */
	public WebElement waitForElementToBeClickable(WebElement e) {
		WebElement element = null;
		try {
			element = wait.until(ExpectedConditions.elementToBeClickable(e));
		} catch (Exception ex) {
			Log.logError("Error while waiting for element to be clickable" + ex.getMessage());
		}
		return element;
	}

	/**
	 * This method is used to send keys for element having 'by' locating mechanism
	 *
	 * @param element : Element to which value is to be send
	 * @param txt : value
	 * @return true if value is entered successfully else false
	 */
	public boolean sendKeys(By element, String txt) {
		try {
			int f=3;
			Log.logInfo("A"+click(element));
			if (waitForElementToBeClickable(driver.findElement(element)) == null)
				return false;
			Log.logInfo("Element - " + element + " is interactable");

			driver.findElement(element).sendKeys(txt);
			Log.logInfo("Send Keys on element - " + element);
			return true;
		} catch (Exception ex) {
			Log.logError("Could not send keys on element - " + element + ex.getMessage());
			return false;
		}
	}
	/**
	 * This method is used to press Enter key 
	 *
	 * @param element : Element to which Enter key should be pressed
	 * @return true if value is entered successfully else false
	 */
	public boolean pressEnterKey() {
		try {
			action.sendKeys(Keys.ENTER);
			action.build().perform();
			Log.logInfo("Pressed Enter key ");
			return true;
		} catch (Exception ex) {
			Log.logError("Could not press Enter key"  + ex.getMessage());
			return false;
		}
	}

	/**
	 * This method is used to click on given element
	 * 
	 * 
	 * @param element [WebElement] : The element on which 'click' is to be performed
	 * @return [boolean] : True after clicking on the element, false otherwise
	 */
	public boolean click(By element) {
		try {
			if (waitForElementToBeClickable(driver.findElement(element)) == null)
				return false;
			Log.logInfo("Element - " + element + " is clickable");

			driver.findElement(element).click();
			Log.logInfo("Clicked on element - " + element);
			return true;
		} catch (Exception ex) {
			Log.logError("Could not click on element - " + element + ex.getMessage());
			return false;
		}
	}

}
