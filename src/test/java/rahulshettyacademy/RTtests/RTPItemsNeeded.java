package rahulshettyacademy.RTtests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RTPItemsNeeded {

		public static WebDriver driver;
//		String colour,id,size;
//		
//		RTPItemsNeeded(WebDriver driver,String id, String colour, String size)
//		{
//			this.driver=driver;
//			this.id=id;
//			this.colour=colour;
//			this.size=size;
//		}
		
//		public WebDriver getDriver() {
//			return driver;
//		}
//
//		public void setDriver(WebDriver driver) {
//			this.driver = driver;
//		}
//
//		public String getColour() {
//			return colour;
//		}
//
//		public void setColour(String colour) {
//			this.colour = colour;
//		}
//
//		public String getId() {
//			return id;
//		}
//
//		public void setId(String id) {
//			this.id = id;
//		}
//
//		public String getSize() {
//			return size;
//		}
//
//		public void setSize(String size) {
//			this.size = size;
//		}

		public void searchItem(String id) throws InterruptedException
		{
			// search
			driver.findElement(By.id("search-input-top-bar")).sendKeys(id);
			Thread.sleep(5000);
			// click on search icon
			driver.findElement(By.cssSelector(".iconClassCommon.cc-icon.cc-icon-search")).click();
			Thread.sleep(5000);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scroll(0,500)");
			WebElement pdt=driver.findElement(By.xpath("//a[@class='link js-analytics-productClick']"));
			pdt.click();
			Thread.sleep(4000);
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
			searchItem(id);
			searchColour(colour,id);
			searchSize(size,id);
			addToCart(id);
		}

//		public void proceedToCheck() throws InterruptedException
//		{
//			driver.findElement(By.id("minicartIcon")).click();
//			Thread.sleep(3000);
//			driver.findElement(By.id("cart-page-checkout-btn")).click();
//			Thread.sleep(2000);
//		}
		
		public void addAddress(String address)
		{
			//driver.findElement(By.id("shippingEmaildefault")).sendKeys(email);
			//driver.findElement(By.id("shippingPhoneNumberdefault")).sendKeys("9748403655");
			driver.findElement(By.xpath("//label[@for='ms']")).click();
			driver.findElement(By.id("shippingFirstNamedefault")).sendKeys("Madhura");
			driver.findElement(By.id("shippingLastNamedefault")).sendKeys("Chatterjee");
			driver.findElement(By.id("shippingAddressOnedefault")).sendKeys(address);
			driver.findElement(By.id("shippingZipCodedefault")).sendKeys("700137");
			driver.findElement(By.id("shippingAddressCitydefault")).sendKeys("Kolkata");
			driver.findElement(By.id("shippingStatedefault")).sendKeys("West Bengal");

		}
		
//		public void proceedToPayment() throws InterruptedException
//		{
//			driver.findElement(By.cssSelector("button[value='submit-shipping']")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.id("minicartIcon")).click();	
//
//		}
		
}
