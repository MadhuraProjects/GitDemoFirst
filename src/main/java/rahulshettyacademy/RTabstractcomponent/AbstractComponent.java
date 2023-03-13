package rahulshettyacademy.RTabstractcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.RTpageobject.RTCheckout;

// base class for all the pageobject classes-- contains all the reusable stuffs like waits, jasacript required in pageobject classes

public class AbstractComponent {
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	// driver.findElement(By.id("minicartIcon")).click();
	@FindBy(id="minicartIcon")
	WebElement cartHeader;
	
	//		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".iconClassCommon.cc-icon.cc-icon-search")));
	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".iconClassCommon.cc-icon.cc-icon-search")));
	}
	
	public RTCheckout goToCartPage()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cartHeader);
		RTCheckout checkOut=new RTCheckout(driver);
		return checkOut;
	}
	
	
}
