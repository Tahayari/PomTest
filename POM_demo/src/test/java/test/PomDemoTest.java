package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import pages.*;

import pageFactory.AuthenticationPage;
import pageFactory.PostpaidDashboard;

public class PomDemoTest {

	WebDriver driver = null ;
	AuthenticationPage objAuthPage ;
	PostpaidDashboard objPostpaidPage ;

	@BeforeTest
	public void setup() {


		String projectLocation = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectLocation+"\\driver\\chromedriver\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://vodafone.ro/autentificare");
	}


	@Test(priority=0)
	public void postpaidLogin() {

		//Create Login page object
		objAuthPage = new AuthenticationPage(driver);

		//Login
		objAuthPage.login("tahayari", "vodafone");

		objPostpaidPage = new PostpaidDashboard(driver);

		Assert.assertTrue(objPostpaidPage.getPostpaidDashboardElem(), "Dashboardul NU s-a incarcat cu success"); 
	}


	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
