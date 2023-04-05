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
	@FindBy(css="button[class='add-to-cart cc-button-type-1']")
	WebElement addToCartButton;
	@FindBy(css="button[class='add-to-wish-list cc-add-to-wish-list to-add']")
	WebElement addToWishListButton;
	@FindBy(css="button[class='remove-btn remove-from-wishlist cc-remove-from-wishlist btn btn-light']")
	WebElement removeFromWishList;
	
	public void searchProduct(String id) throws InterruptedException
	{
		driver.findElement(By.id("search-input-top-bar")).sendKeys(id);
		waitForElementToAppear(productBy);
		searchIcon.click();
		Thread.sleep(3000);
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,300)");
		productIcon.click();
	}
	
	public void searchColour(String colour, String id) throws InterruptedException
	{
		String colourXpath="//button[@data-value='"+colour+"']";
		WebElement clr=driver.findElement(By.xpath(colourXpath));
		clr.click();
		System.out.println("The selected colour for your shoe "+id+" is "+colour);
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
		//driver.findElement(By.cssSelector(".add-to-cart.cc-button-type-1")).click();
		addToCartButton.click();
		Thread.sleep(2000);
		System.out.println("Your Item "+id+" is added to cart succesfully !!!");
	}
	public void addToWishList(String id) throws InterruptedException
	{
		js.executeScript("window.scroll(0,400)");
		addToWishListButton.click();
		Thread.sleep(2000);
		//System.out.println("You item "+id+" is added to WishList successfully !!!" );
	}
	public void removeFromWishList(String id)
	{
		js.executeScript("window.scroll(0,300)");
		removeFromWishList.click();
		System.out.println("The element "+id+" is removed from wishlist!!!");
		
	}
	public void commonWishList(WebDriver driver, String id, String colour, String size) throws InterruptedException 
	{
		searchProduct(id);
		searchColour(colour,id);
		searchSize(size,id);
		addToWishList(id);
		System.out.println("You item "+id+" of colour "+colour+" of size "+size+" is added to WishList successfully !!!" );
		goToWishList();
		Thread.sleep(1000);
		removeFromWishList(id);
	}
	public void commonObjectCalling(WebDriver driver, String id, String colour, String size) throws InterruptedException
	{
		searchProduct(id);
		searchColour(colour,id);
		searchSize(size,id);
		addToCart(id);
	}

}
