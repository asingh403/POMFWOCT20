package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	WebDriver driver;
	public Properties prop;
	public ElementUtil elementUtil;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	/**
	 * this method is used to initialize the webdriver on basis of given browser
	 * 
	 * @param browserName
	 * @return
	 **/

	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver());

		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
		}

		else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			// driver = new InternetExplorerDriver();
			tlDriver.set(new InternetExplorerDriver());
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();

//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		getDriver().get(prop.getProperty("url"));

		return getDriver();

	}

	/**
	 * This is method is used to initialize the properties from the
	 * config.properties on the basis of given ENV variable
	 * 
	 * @return prop
	 */

	public Properties init_prop() {
		prop = new Properties();
		String path = null;
		String env = null;

		try {

			env = System.getProperty("env");
			System.out.println("env value is--->" + env);

			if (env == null) {
				path = ".\\src\\main\\java\\com\\qa\\hubspot\\config\\qa.config.properties";
			} else {

				switch (env) {
				case "qa":
					path = "";
					break;

				case "dev":
					path = ".\\src\\main\\java\\com\\qa\\hubspot\\config\\qa.config.properties";
					break;

				case "stage":
					path = ".\\src\\main\\java\\com\\qa\\hubspot\\config\\qa.config.properties";
					break;

				default:
					System.out.println("please pass the correct environment value ==>  " + env);
					break;

				}
			}

			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

	/**
	 * this method will take the screenShot
	 */

	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;

	}

	public void switchToFrame() {
		 tlDriver.set(driver.switchTo().frame(Constants.FRAME_NAME));
	}

}
