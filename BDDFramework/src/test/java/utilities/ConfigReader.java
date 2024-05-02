package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	static Properties prop;

	public ConfigReader() {
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream(
					System.getProperty("user.dir") + "//src//test//resources//config//config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *     This method is used to load properties from
	 *         config.properties file
	 * @return properties file
	 */
	public Properties loadConfigFile() {
		try {
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "//src//test//resources//config//config.properties");

			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	/**
	 *     This method is used to get value of property from
	 *         config.properties file
	 * @param Property : Name of property
	 * @return value of property
	 * 
	 */
	public String getProperty(String Property) {
		return loadConfigFile().getProperty(Property);
	}

	/**
	 *     This method is used to get value of property from
	 *         config.properties file
	 * @param Property     : Name of property
	 * @param DefaultValue : Default value to be assigned
	 * @return value of property
	 */
	public String getProperty(String Property, String DefaultValue) {
		return loadConfigFile().getProperty(Property);
	}
}
