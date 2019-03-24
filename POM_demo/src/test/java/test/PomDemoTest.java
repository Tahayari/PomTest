package test;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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
	PostpaidDashboard objPostpaidPage ;
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
		else System.out.println("Nu este definit OK browserul");

		driver.get("https://www.vodafone.ro/personal/campanii/superoferte-online/index.htm");
	}


	@Test(enabled=false)
	public void postpaidLogin() {

		//Create Login page object
		objAuthPage = new AuthenticationPage(driver);

		//Login
		objAuthPage.login(prop.getPostpaid_username(), prop.getPostpaid_password());

		objPostpaidPage = new PostpaidDashboard(driver);

		Assert.assertTrue(objPostpaidPage.getPostpaidDashboardElem(), "Dashboardul NU s-a incarcat cu success"); 
	}

	@Test
	public void LoginDinPrimaPagina() {
		//Create Login page object
		objFirstPage = new FirstPage(driver);
		
		//Login
		objFirstPage.BeginLogin(prop.getPostpaid_username(),prop.getPostpaid_password());
	}


	@AfterTest
	public void afterTest() {
		//driver.close();
		System.out.println("Testul s-a incheiat!");
	}

}
