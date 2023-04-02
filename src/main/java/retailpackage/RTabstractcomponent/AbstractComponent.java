package retailpackage.RTabstractcomponent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import retailpackage.RTpageobject.RTCheckout;

// base class for all the pageobject classes-- contains all the reusable stuffs like waits, jasacript required in pageobject classes

public class AbstractComponent {
	WebDriver driver;
	//WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	public static WebDriverWait w;
	public static JavascriptExecutor js;
	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		w=new WebDriverWait(driver,Duration.ofSeconds(5));
		js=(JavascriptExecutor)driver;
	}
	@FindBy(id="minicartIcon")
	WebElement cartHeader;
	//@FindBy(css=".iconClassCommon.cc-headerBar-icon")
	@FindBy(css="a[class='cc-headerBar-link wishlistLink']")
	WebElement wishListHeader;
	@FindBy(css=".ls-is-cached.b-lazyload_loaded")
	List<WebElement> itemsWishList;
	
	//		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".iconClassCommon.cc-icon.cc-icon-search")));
	public void waitForElementToAppear(By findBy)
	{
		//WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".iconClassCommon.cc-icon.cc-icon-search")));
	}
	
	public void waitForWebElementToAppear(WebElement ele)
	{
		//WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public RTCheckout goToCartPage()
	{
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cartHeader);
		RTCheckout checkOut=new RTCheckout(driver);
		return checkOut;
	}
	
	public void goToWishList()
	{
		wishListHeader.click();
		//WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfAllElements(itemsWishList));	
		System.out.println("Your wishlist menu is opened !!!!");
	}
	
}
