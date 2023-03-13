package rahulshettyacademy.RTtests;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.RTpageobject.RTCheckout;
import rahulshettyacademy.RTpageobject.RTLandingPage;
import rahulshettyacademy.RTpageobject.RTProductCatalogue;

public class SubmitShoeOrders {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		String email="cmadhura22j2018@gmail.com";
		String password="MyBata@123";
		//String[][][] itemsNeeded= {{{"5086343", "DARKGREY", "6"},{"5592343","PEACH","4"},{"5399084","TURQBLUE","5"}}};
		driver.manage().window().maximize();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);		
		// Login
		RTLandingPage landingPage=new RTLandingPage(driver);
		landingPage.goTo();
		RTProductCatalogue productCatalogue=landingPage.loginApplication(email,password);
		productCatalogue.commonObjectCalling(driver, id, colour, size);
		RTCheckout checkOut=productCatalogue.goToCartPage();
		checkOut.commonObjectCalling();
		driver.close();
	}
}
//		item1.commonObjectCalling(RTPItemsNeeded.driver, "5086343", "DARKGREY", "6");
//		item2.commonObjectCalling(RTPItemsNeeded.driver, "5592343", "PEACH", "4");
//		item3.commonObjectCalling(RTPItemsNeeded.driver, "5399084", "TURQBLUE", "5");
//		
		
	



