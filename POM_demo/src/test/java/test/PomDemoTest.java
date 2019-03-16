package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.AuthenticationPage;
import pages.PostpaidDashboard;

public class PomDemoTest {

	WebDriver driver = null ;
	AuthenticationPage objAuthPage ;
	PostpaidDashboard objPostpaidPage ;

	@BeforeTest
	public void setup() {


		String projectLocation = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectLocation+"\\driver\\chromedriver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://vodafone.ro/autentificare");
	}


	@Test(priority=0)
	public void testLogin() {

		//Create Login page object
		objAuthPage = new AuthenticationPage(driver);

		//Login
		objAuthPage.login("tahayari", "vodafone");

		objPostpaidPage = new PostpaidDashboard(driver);

		Assert.assertTrue(objPostpaidPage.getFacturaPortlet().toLowerCase().contains("factura mea"));


	}


	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
