package StepDefinition;

import org.testng.Assert;

import Pages.SwagLabPage;
import driverFactory.AndroidDriverFactory;
import utilities.ConfigReader;
import utilities.Log;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	ConfigReader config;
	Log log;
	SwagLabPage login;
	AndroidDriver driver;

	public Steps() {
		AndroidDriverFactory ad=new AndroidDriverFactory();
		driver = ad.getMobileDriver();
		login = new SwagLabPage(driver);
		config = new ConfigReader(); 
	}

	@Given("^User opened mobile application$")
	public void open_mobile_application() throws InterruptedException { 
		Log.logInfo("User has opened mobile application)"); 
	}
	
	@Given("^user is on LoginScreen$")
	public void user_is_on_login_screen() throws InterruptedException { 
		Log.logInfo("User is on login screen)"); 
	}
	
	@Given("^user has logged in with username and password as \"(.*)\" and \"(.*)\"$")
	public void user_is_on_home_screen(String username, String pswd) throws InterruptedException { 
		Assert.assertTrue(login.enterCredential(login.UserName, username),
				"Username entered"); 
		Assert.assertTrue(login.enterCredential(login.Password,pswd),
				"Password entered");
		Assert.assertTrue(login.clickButton(login.LogInBtn), "Clicked on Login Button");
		
		Log.logInfo("User has successfully logged in)"); 
	}

	@When("^user is present on Home page$")
	public void navigated_to_home_page() throws InterruptedException {
		Log.logInfo("Landed on Home page of mobile application");
	}
	
	@When("^user enters username as \"(.*)\"$")
	public void user_enters_username(String username) throws InterruptedException {
		Assert.assertTrue(login.enterCredential(login.UserName, username),
				"Username entered"); 
	}
	
	@When("^user wants to view elements$")
	public void view_elements() throws InterruptedException {
		Log.logInfo("Viewing all web elements present on Login page");
	}
	
	@When("^user enters password as \"(.*)\"$")
	public void user_enters_password(String pswd) throws InterruptedException {
		Assert.assertTrue(login.enterCredential(login.Password,pswd),
				"Password entered");
	}

	@When("^clicks on login button$")
	public void clicks_on_login_button() {
		Assert.assertTrue(login.clickButton(login.LogInBtn), "Clicked on Login Button");
	}
	
	
	@Then("^Logo is displayed$")
	public void is_logo_displayed()
	{
		Assert.assertTrue(login.checkVisibility(login.SwagLabIcon),
				"Logo is displayed");
	}
	
	
	@Then("^User Name is displayed$")
	public void is_username_field_displayed()
	{
		Assert.assertTrue(login.checkVisibility(login.UserName),
				"User Name field is displayed");
	}
	
	@Then("^Password is displayed$")
	public void is_password_field_displayed()
	{
		Assert.assertTrue(login.checkVisibility(login.Password),
				"Password field is displayed");
	}
	
	@Then("^Login button is displayed$")
	public void is_login_btn_displayed()
	{
		Assert.assertTrue(login.checkVisibility(login.LogInBtn),
				"Login button is displayed");
	}
	@Then("^Username error message is displayed$")
	public void username_error_displayed()
	{
		Assert.assertTrue(login.checkVisibility(login.UserNameReqError),
				"Username required error message is displayed");
	}
	@Then("^password error message is displayed$")
	public void pswd_error_displayed()
	{
		Assert.assertTrue(login.checkVisibility(login.PswdReqError),"Password required Error message is displayed");
	}
	@Then("^error message is displayed$")
	public void error_msg_displayed()
	{
		Assert.assertTrue(login.checkVisibility(login.ErrorMsg),"Invalid credentials error message is displayed");
	}

	@Then("^Products is displayed$")
	public void searchbox_is_visible() {
		Assert.assertTrue(login.checkVisibility(login.Product), "Products text is visible");
	}
	
	@Then("^Products is not displayed$")
	public void searchbox_is_not_visible() {
		Assert.assertFalse(login.checkVisibility(login.Product), "Products is not visible");
	}
	

}
