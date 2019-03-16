package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage {

	WebDriver driver;

	By username = By.xpath("//form[@name='LoginPortalDesktop_Authentication']//input[@name='IDToken1']");
	By password = By.xpath("//input[@id='PortalDesktop_Authenticationlogin-password']");
	By login_btn = By.xpath("//button[@id='PortalDesktop_Authenticationauthenticate']");
	/*
	 * Define By.
	 * Define By.
	 * */

	public AuthenticationPage(WebDriver driver) {
		this.driver=driver;
	}

	public void setUsername(String user) {
	
		driver.findElement(username).sendKeys(user);

	}

	public void setPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}

	public void clickLoginButton() {
		driver.findElement(login_btn).sendKeys(Keys.ENTER);
	}

	public void login(String username,String password) {
		
		this.setUsername(username);
		this.setPassword(password);
		this.clickLoginButton();
	}

}
