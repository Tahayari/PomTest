package test;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

import config.PropertiesFile;
import config.setupBrowser;
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

		setupBrowser setup = new setupBrowser();
		driver = setup.getDriver();

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
