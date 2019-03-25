package test;

import java.io.IOException;

import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import config.PropertiesFile;
import pageFactory.AuthenticationPage;
import pageFactory.PostpaidDashboard;
import pageFactory.FirstPage;

public class PomDemoTest {

	WebDriver driver = null ;
	AuthenticationPage objAuthPage ;
	PostpaidDashboard objPostpaidDashboard ;
	FirstPage objFirstPage;
	PropertiesFile prop = new PropertiesFile();

	@BeforeTest
	public void setup() throws IOException {


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


	@Test(priority=1)
	public void postpaidLogin() {

		driver.get("https://vodafone.ro/autentificare");

		//Create Login page object
		objAuthPage = new AuthenticationPage(driver);

		//Login
		objAuthPage.login(prop.getPostpaid_username(), prop.getPostpaid_password());

		//Create Postpaid Dashboard page object
		objPostpaidDashboard = new PostpaidDashboard(driver);

		Assert.assertEquals("Abonamentul meu",objPostpaidDashboard.getPostpaidDashboardElem());
	}

	@Test(priority=0)
	public void HomepagePostpaidLogin() {
		//Create Login page object
		objFirstPage = new FirstPage(driver);

		//Login
		objFirstPage.BeginLogin(prop.getPostpaid_username(),prop.getPostpaid_password());

		//Create Postpaid Dashboard page object
		objPostpaidDashboard = new PostpaidDashboard(driver);

		Assert.assertEquals("Abonamentul meu",objPostpaidDashboard.getPostpaidDashboardElem());
	}


	@AfterMethod
	public void Logout(){
		//Create Postpaid Dashboard page object
		objPostpaidDashboard = new PostpaidDashboard(driver);
		//Create Login page object
		objFirstPage = new FirstPage(driver);
		objPostpaidDashboard.Logout();
		driver.get(prop.getURL());
		
	}

	@AfterTest
	public void afterTest() {
		driver.close();
		System.out.println("Testele s-au incheiat!");
	}

}
