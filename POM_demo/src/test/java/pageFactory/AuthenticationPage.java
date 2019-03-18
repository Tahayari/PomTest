package pageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AuthenticationPage {

	WebDriver driver;

	@FindBy(xpath="//form[@name='LoginPortalDesktop_Authentication']//input[@name='IDToken1']")	WebElement username;
	@FindBy(xpath="//input[@id='PortalDesktop_Authenticationlogin-password']") WebElement password;
	@FindBy(xpath="//button[@id='PortalDesktop_Authenticationauthenticate']") WebElement login_btn;

	public AuthenticationPage(WebDriver driver) {
		this.driver=driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(factory, this);
	}

	public void setUsername(String user) {
	
		username.sendKeys(user);

	}

	public void setPassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickLoginButton() {
		login_btn.sendKeys(Keys.ENTER);
	}

	public void login(String username,String password) {
		
		this.setUsername(username);
		this.setPassword(password);
		this.clickLoginButton();
	}

}
