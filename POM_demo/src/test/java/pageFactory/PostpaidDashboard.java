package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PostpaidDashboard {

	WebDriver driver = null ;
	
	@FindBy(xpath="//span[contains(text(),'Abonamentul meu')]") WebElement AbonamentlMeu ;
	WebElement serviciileTale_btn;
	
	public PostpaidDashboard (WebDriver driver) {
		this.driver=driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(factory, this);
	}
	
	public String getPostpaidDashboardElem() {
		return AbonamentlMeu.getText();
		
	}
	
	public void Logout(){
		Actions act = new Actions(driver);
		
		act.moveToElement(driver.findElement(By.xpath("//a[@id='identity-head']"))).perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'din cont')]"))).click().perform();
	}
	
}
