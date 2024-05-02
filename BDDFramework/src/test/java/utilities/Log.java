package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

public class Log {
	public static String fullClassName, className, methodName;

	public static String environment;
	public static int genericNumber, lineNumber;

	/*** Purpose - To create log folder day wise for each run & to set the values in log4j.properties file***/

	static {
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy_MM_dd");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String date = dateFormat1.format(new Date());
		String dateTime = dateFormat2.format(new Date());
		String currentDayLogFolder = "Logs_" + date;
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(Constants.CONFIG_FILE);
			prop.load(fis);
			System.out.println("Configuration file is loaded");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		environment = prop.getProperty("environment");
		String currentRunLogFolder = currentDayLogFolder + "\\Log_" + environment + "_" + dateTime;
		String currentDayLogFolderPath = Constants.LOGS_PATH + currentDayLogFolder;

		File file1 = new File(currentDayLogFolderPath);
		boolean folderGenerated = file1.mkdir();
		try {
			if (!file1.exists()) {
				if (folderGenerated) {
					System.out.println("Log folder for day created successfully " + currentDayLogFolderPath);
				} else {
					System.out.println("Couldn't create new log folder of a day " + currentDayLogFolderPath);
				}
			} else {
				System.out.println("Log folder for day already exists" + currentDayLogFolderPath);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String fName = dateTime + ".log";
		System.setProperty("LOG_FOLDER", currentRunLogFolder);
		System.setProperty("current.date.time", dateTime);
		System.setProperty("LogFileName", fName);
		try {
			String log4jConfigFile = System.getProperty("user.dir") + "\\src\\test\\resources\\" + "log4j2.xml";
			ConfigurationSource source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
			Configurator.initialize(null, source);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/************************
	 * @Purpose- Handling logs
	 *******************************/

	public static void logInfo(String message) {
		fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
		className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
		lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
		Logger logger = LogManager.getLogger(className);
		String print = lineNumber + " - " + message;
		logger.info(print);
	}

	public static void logError(String message) {
		fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
		className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
		lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
		Logger logger = LogManager.getLogger(className);
		String print = lineNumber + " - " + message;
		logger.error(print);
	}

	public static void logWarn(String message) {
		fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
		className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
		lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
		Logger logger = LogManager.getLogger(className);
		String print = lineNumber + " - " + message;
		logger.warn(print);
	}

	public static void logDebug(String message) {
		fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
		className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
		lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
		Logger logger = LogManager.getLogger(className);
		String print = lineNumber + " - " + message;
		logger.debug(print);
	}

	public static void logFatal(String message) {
		fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
		className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
		lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
		Logger logger = LogManager.getLogger(className);
		String print = lineNumber + " - " + message;
		logger.fatal(print);
	}

}
