package driverFactory;

import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import utilities.ConfigReader;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidDriverFactory {

	public static AndroidDriver driver;
	Properties prop;
//	String PlatformName, String androidPlatformVersion,
//	String androidDeviceName, String androidAutomationName, String androidAppLocation, String appiumURL
	public AndroidDriverFactory() {
		System.out.println("Instantiating Android Mobile App Driver");
		ConfigReader config = new ConfigReader();
		prop = config.loadConfigFile();
		try {
			UiAutomator2Options caps = new UiAutomator2Options();
			caps.setApp(prop.getProperty("androidAppLocation"));
			caps.setAppWaitActivity("*");
			caps.setPlatformName(prop.getProperty("PlatformName"));
			caps.setPlatformVersion(prop.getProperty("androidPlatformVersion"));
			caps.setDeviceName(prop.getProperty("androidDeviceName"));
			caps.autoGrantPermissions();
			caps.setAutomationName(prop.getProperty("androidAutomationName"));
			caps.setNewCommandTimeout(Duration.ofSeconds(300));
			caps.setNoReset(true);
			caps.setFullReset(false);
			URL url = new URL(prop.getProperty("appiumURL"));
			driver = new AndroidDriver(url, caps);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		} catch (Exception e) {
			System.out.println("Failed to instantiate Appium Driver" + e.getMessage());
			e.printStackTrace();
		} 
	}

	public  AndroidDriver getMobileDriver() {
		return driver;
	}
}
