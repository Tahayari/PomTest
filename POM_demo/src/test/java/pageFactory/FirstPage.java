package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FirstPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@id='identity-head']") WebElement MyVodafone_login;

	
	public FirstPage (WebDriver driver) {
		this.driver = driver ;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,20);
		PageFactory.initElements(factory, driver);
	}

	
	public void BeginLogin(String user,String pass) {
		Actions act = new Actions(driver);
		
		//Click on URL to go back to main page
		driver.findElement(By.xpath("//span[contains(text(),'< Înapoi la Vodafone.ro')]")).click();
		
		//Hover over MyVodafone button
		act.moveToElement(driver.findElement(By.xpath("//a[@id='identity-head']"))).perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Enter username
		act.moveToElement(driver.findElement(By.xpath("//label[@for='login-name']//following::input[1]"))).click().sendKeys(user).perform();
		
		//Enter password
		act.moveToElement(driver.findElement(By.xpath("//label[@for='login-name']//following::input[2]"))).click().sendKeys(pass).perform();
		
		//Click on Login Button
		act.moveToElement(driver.findElement(By.xpath("//label[@for='login-name']//following::button"))).click().perform();
		
		
	}

}
