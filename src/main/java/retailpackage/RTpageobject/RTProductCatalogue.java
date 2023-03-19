package retailpackage.RTpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import retailpackage.RTabstractcomponent.AbstractComponent;

public class RTProductCatalogue extends AbstractComponent{

	WebDriver driver;
	By productBy=By.cssSelector(".iconClassCommon.cc-icon.cc-icon-search");
	public RTProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	// Page Factory
	
	@FindBy(css=".iconClassCommon.cc-icon.cc-icon-search")
	WebElement searchIcon;
	@FindBy(xpath="//a[@class='link js-analytics-productClick']")
	WebElement productIcon;
	
	public void searchProduct(String id) throws InterruptedException
	{
		driver.findElement(By.id("search-input-top-bar")).sendKeys(id);
		waitForElementToAppear(productBy);
		searchIcon.click();
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,500)");
		productIcon.click();
	}
	
	public void searchColour(String colour, String id) throws InterruptedException
	{
		String colourXpath="//button[@data-value='"+colour+"']";
		WebElement clr=driver.findElement(By.xpath(colourXpath));
		clr.click();
		System.out.println("The selected size for your shoe "+id+" is "+colour);
		Thread.sleep(3000);
	}
	
	public void searchSize(String size, String id) throws InterruptedException
	{
		WebElement sz=driver.findElement(By.xpath("//li[@data-display-value='"+size+"']"));
		sz.click();
		System.out.println("The selected size for your shoe "+id+" is "+size);
		Thread.sleep(2000);
	}
	public void addToCart(String id) throws InterruptedException
	{
		driver.findElement(By.cssSelector(".add-to-cart.cc-button-type-1")).click();
		Thread.sleep(2000);
		System.out.println("Your Item "+id+" is added to cart succesfully !!!");
	}
	public void commonObjectCalling(WebDriver driver, String id, String colour, String size) throws InterruptedException
	{
		searchProduct(id);
		searchColour(colour,id);
		searchSize(size,id);
		addToCart(id);
	}

}
