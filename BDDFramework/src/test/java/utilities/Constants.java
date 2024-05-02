package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import utilities.Constants;

public class Constants {

	Properties prop = new Properties();

	final public static String RESULT_TAB = "Execution_Result";
	public static String Execution_REPORT_PATH, SCREENSHOT_PATH_FAIL, SCREENSHOT_PATH_PASS, Execution_REPORT_PATH_API,
			Execution_REPORT_PATH_RULESAPI_CSV;

	/****************** LogFiles and folders********************/

	final public static String CONFIG_FILE = System.getProperty("user.dir")
			+ "//src//test//resources//config//config.properties";
	final public static String LOG_CONFIG_FILE = System.getProperty("user.dir")
			+ SetPathForPlatform("\\src\\test\\resources\\log4j.properties");
	final public static String LOGS_PATH = System.getProperty("user.dir") + "\\log\\RunLogs\\";
	
	/**
	 * @param Path : File Path
	 * @return path in windows or Mac supporting format
	 */
	public static String SetPathForPlatform(String Path) {
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(Constants.CONFIG_FILE);
		} catch (FileNotFoundException e) {
//			logError("Exception caught in SetPathForPlatform - " + e.getMessage());
		}
		try {
			prop.load(fis);
		} catch (Exception e) {

		}
		if (prop.getProperty("isIOS").equalsIgnoreCase("Y")) {
			String iosPath = Path.replace("\\", "//");
			if (iosPath.contains(".exe")) {
				String exeFilePath = iosPath.replace(".exe", "");
				return exeFilePath;
			} else {
				return iosPath;
			}
		}

		else {
			return Path;
		}

	}

}
