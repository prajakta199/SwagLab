package Pages;

import java.time.Duration;

import org.openqa.selenium.By; 
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ControlActions_Android;

import io.appium.java_client.android.AndroidDriver; 

public class SwagLabPage {
	WebDriverWait wait;
	AndroidDriver driver;
	ControlActions_Android androidControlActions;

	public SwagLabPage(AndroidDriver driver) {
		this.driver = driver;
		androidControlActions = new ControlActions_Android(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	public By SwagLabIcon = By.xpath(SwagLabPageLocators.SWAGLABS_LOGO);
	public By UserName = By.xpath(SwagLabPageLocators.USERNAME_TXTBX);
	public By Password = By.xpath(SwagLabPageLocators.PSWD_TXTBX);
	public By LogInBtn = By.xpath(SwagLabPageLocators.LOGIN_BTN);
	public By UserNameReqError = By.xpath(SwagLabPageLocators.USERNAME_REQ);
	
	public By PswdReqError = By.xpath(SwagLabPageLocators.PSWD_REQ);
	public By ErrorMsg = By.xpath(SwagLabPageLocators.ERROR_MSG);
	public By Product = By.xpath(SwagLabPageLocators.PRODUCTS);


	/**
	 * This method is used to enter credentials
	 *
	 * @param field : WebElement to which value is to be sent
	 * @param value : Value
	 * @return true if credentials are entered successfully else false
	 */
	public boolean enterCredential(By field, String value) {
		try { 
			androidControlActions.sendKeys(field, value); 
			androidControlActions.pressEnterKey();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * This method is used to click button
	 *
	 * @param field : WebElement to be clicked
	 * @return true if element is clicked successfully else false
	 */
	public boolean clickButton(By field) {
		return androidControlActions.click(field);
	}

	/**
	 * This method is used to check for visibility of element
	 *
	 * @param field : WebElement to be checked
	 * @return true if element is visible else false
	 */
	public boolean checkVisibility(By field) {
		return androidControlActions.waitForVisibility(field, Duration.ofSeconds(20));
	}

}