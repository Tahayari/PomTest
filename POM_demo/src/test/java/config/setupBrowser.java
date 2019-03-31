package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class setupBrowser {
	
	PropertiesFile prop = new PropertiesFile();
	WebDriver driver = null;
	
	public setupBrowser(){
		
		String projectLocation = System.getProperty("user.dir");

		System.out.println("Running test in "+prop.getBrowser().toLowerCase()+" browser");

		if(prop.getBrowser().toLowerCase().contentEquals("firefox")){
			System.setProperty("webdriver.gecko.driver",projectLocation+"/driver/geckodriver/geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver();
		}
		else if (prop.getBrowser().toLowerCase().contentEquals("chrome")){
			System.setProperty("webdriver.chrome.driver",projectLocation+"/driver/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else System.out.println("Invalid browser defined in config.properties");
		driver.get(prop.getURL());
				
	}
	
	public WebDriver getDriver(){
		return this.driver;
	}
	

}
