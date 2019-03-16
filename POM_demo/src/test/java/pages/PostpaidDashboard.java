package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostpaidDashboard {

	WebDriver driver = null ;
	
	public PostpaidDashboard (WebDriver driver) {
		this.driver=driver;
	}
	
	public String getFacturaPortlet() {
		return driver.findElement(By.xpath("span[contains(text(),'Abonamentul meu')]")).getText();
	}
	
}
