package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PostpaidDashboard {

	WebDriver driver = null ;
	
	@FindBy(xpath="//a[@href='https://www.vodafone.ro/vfrointegration/appmanager/vfroportal/myvodafone?_nfpb=true&_nfxr=false&_pageLabel=cost-control'][contains(text(),'Serviciile tale')]") 
	WebElement serviciileTale_btn;
	
	public PostpaidDashboard (WebDriver driver) {
		this.driver=driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(factory, this);
	}
	
	public boolean getPostpaidDashboardElem() {
		System.out.println("Verify if dashboard has loaded");
		
		return serviciileTale_btn.isDisplayed();
		
	}
	
}
