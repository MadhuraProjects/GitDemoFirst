package rahulshettyacademy.RTtests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RTPDemoExtension {

	public static void main(String[] args) throws InterruptedException {
		RTPItemsNeeded item1=new RTPItemsNeeded(); // no constructor is created so default is called
		RTPItemsNeeded item2=new RTPItemsNeeded();
		RTPItemsNeeded item3=new RTPItemsNeeded();
		WebDriverManager.chromedriver().setup();
		// WebDriver driver is declared as static variable so we can directly call it using the classname and not obj of that class
		RTPItemsNeeded.driver = new ChromeDriver(); //RTOItemsNeeded.driver in other subclasses
		
		//String[][][] itemsNeeded= {{{"5086343", "DARKGREY", "6"},{"5592343","PEACH","4"},{"5399084","TURQBLUE","5"}}};
		
		String email="cmadhura22j2018@gmail.com";
		String pwd="MyBata@123";
		String address="240 by 2, Dharmatala Road, Bdg Bdg";
		RTPItemsNeeded.driver.get("https://www.bata.in/login");
		RTPItemsNeeded.driver.manage().window().maximize();
		// Javascript declaration
		JavascriptExecutor js=(JavascriptExecutor)RTPItemsNeeded.driver;
		// Implicit wait
		RTPItemsNeeded.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		// Login
		RTPItemsNeeded.driver.findElement(By.id("login-form-email")).sendKeys(email);
		RTPItemsNeeded.driver.findElement(By.name("loginPassword")).sendKeys(pwd);
		js.executeScript("window.scroll(0,300)");
		RTPItemsNeeded.driver.findElement(By.cssSelector(".cc-button-type-1.js-analytics-loginButton")).click();
		Thread.sleep(5000);
		// Add multiple items to cart
		//itemsDetails(driver,id,"colour",size);
		// Go to cart icon to check the items selected
		
		//Add items
		//itemsDetails(driver,"id","colour","size");
		
//		item.searchItem();
//		item.searchColour(item.getColour());
//		item.searchSize(item.getSize());
//		item.addToCart();
		item1.commonObjectCalling(RTPItemsNeeded.driver, "5086343", "DARKGREY", "6");
		item2.commonObjectCalling(RTPItemsNeeded.driver, "5592343", "PEACH", "4");
		item3.commonObjectCalling(RTPItemsNeeded.driver, "5399084", "TURQBLUE", "5");
		//item.proceedToCheck();
		//item.proceedToPayment();
		Thread.sleep(2000);
		RTPItemsNeeded.driver.findElement(By.id("minicartIcon")).click();
		// proceed to check
		RTPItemsNeeded.driver.findElement(By.id("cart-page-checkout-btn")).click();
		Thread.sleep(2000);
		// Add address
		item1.addAddress(address);
		// proceed to payment
		RTPItemsNeeded.driver.findElement(By.cssSelector("button[value='submit-shipping']")).click();
		Thread.sleep(2000);
		// proceed to check
		WebElement myCartIcon=RTPItemsNeeded.driver.findElement(By.id("minicartIcon"));
		js.executeScript("arguments[0].click()", myCartIcon);
		// delete the selected item
		Thread.sleep(2000);
		RTPItemsNeeded.driver.findElement(By.cssSelector(".cc-icon.icon-close-remove")).click();
		//sign out
		Thread.sleep(2000);
		RTPItemsNeeded.driver.findElement(By.cssSelector("div[class='cc-headerBar-link js-userIcon']")).click();
		RTPItemsNeeded.driver.findElement(By.xpath("//div[@class='cc-header-userMenu-container js-userSubMenu']/a[4]")).click();
		Thread.sleep(1000);
		// closing browser
		RTPItemsNeeded.driver.close();	
	}
		
	}




