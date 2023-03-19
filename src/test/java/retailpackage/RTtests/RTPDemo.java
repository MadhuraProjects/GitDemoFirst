package retailpackage.RTtests;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RTPDemo {

	public static void main(String[] args) throws InterruptedException  {
		//System.setProperty("Webdriver.chrome.driver", "C:\\Users\\USER1\\AppData\\Local\\chromedriver_win32");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// explicit wait
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		String email="cmadhura22j2018@gmail.com";
		String pwd="MyBata@123";
		//String[] id={"5086343","5592343","5399084","6715769"};
		String id="5086343";
		String address="240 by 2 dharmatala road budge budge";
		driver.get("https://www.bata.in/login");
		driver.manage().window().maximize();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		// Javascript declaration
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		// Login
		driver.findElement(By.id("login-form-email")).sendKeys(email);
		driver.findElement(By.name("loginPassword")).sendKeys(pwd);
		js.executeScript("window.scroll(0,300)");
		driver.findElement(By.cssSelector(".cc-button-type-1.js-analytics-loginButton")).click();
		System.out.println(" You have successfully logged in !!!!");
		System.out.println(" Please wait while we load ");
		Thread.sleep(5000);
		// search items
		driver.findElement(By.id("search-input-top-bar")).sendKeys(id);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".iconClassCommon.cc-icon.cc-icon-search")));
		driver.findElement(By.cssSelector(".iconClassCommon.cc-icon.cc-icon-search")).click();
		Thread.sleep(5000);
		// scrolling to item image
		js.executeScript("window.scroll(0,500)");
		// select the product--if we see the entire image is going to next page we should choose the unique element
		WebElement pdt=driver.findElement(By.xpath("//a[@class='link js-analytics-productClick']"));
		pdt.click();
		//js.executeScript("argument[0].click();", pdt);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@data-value='DARKGREY']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("li[data-display-value='6']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".add-to-cart.cc-button-type-1")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("minicartIcon")).click();
		
		// proceed to check
		driver.findElement(By.id("cart-page-checkout-btn")).click();
		Thread.sleep(2000);
		
		// address input -- not required if already logged in
//		//driver.findElement(By.id("shippingEmaildefault")).sendKeys(email);
//		//driver.findElement(By.id("shippingPhoneNumberdefault")).sendKeys("9748403655");
//		driver.findElement(By.xpath("//label[@for='ms']")).click();
//		driver.findElement(By.id("shippingFirstNamedefault")).sendKeys("Madhura");
//		driver.findElement(By.id("shippingLastNamedefault")).sendKeys("Chatterjee");
//		driver.findElement(By.id("shippingAddressOnedefault")).sendKeys(address);
//		driver.findElement(By.id("shippingZipCodedefault")).sendKeys("700137");
//		driver.findElement(By.id("shippingAddressCitydefault")).sendKeys("Kolkata");
//		driver.findElement(By.id("shippingStatedefault")).sendKeys("West Bengal");
//		
		// proceed to payment
		driver.findElement(By.cssSelector("button[value='submit-shipping']")).click();
		Thread.sleep(2000);
		// proceed to check
		WebElement myCartIcon=driver.findElement(By.id("minicartIcon"));	
		js.executeScript("arguments[0].click()", myCartIcon);
		// delete the selected item
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".cc-icon.icon-close-remove")).click();
		
		
//		List<WebElement> finalItems=driver.findElements(By.cssSelector(".cc-icon.icon-close-remove"));
//		int noOfItems=finalItems.size();
//		for(int i=1; i<noOfItems; i++)
//		{
//			Thread.sleep(2000);
//			finalItems.get(i).click();
//			
//			//js.executeScript("argument[0].get(i).click();", finalItems);
//		}
		
		//sign out
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[class='cc-headerBar-link js-userIcon']")).click();
		driver.findElement(By.xpath("//div[@class='cc-header-userMenu-container js-userSubMenu']/a[4]")).click();
		System.out.println("You are logged out succesfully !!!");
		Thread.sleep(1000);
    	// closing browser
		driver.close();
	}
}

	
