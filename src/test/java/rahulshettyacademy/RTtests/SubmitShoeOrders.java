package rahulshettyacademy.RTtests;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.RTpageobject.RTCheckout;
import rahulshettyacademy.RTpageobject.RTLandingPage;
import rahulshettyacademy.RTpageobject.RTProductCatalogue;
import rahulshettyacademy.testcomponents.BaseTest;

public class SubmitShoeOrders extends BaseTest{

	@Test
	public void submitShoeOrder() throws IOException, InterruptedException
	{
		String email="cmadhura22j2018@gmail.com";
		String password="MyBata@123";
		//String[][][] itemsNeeded= {{{"5086343", "DARKGREY", "6"},{"5592343","PEACH","4"},{"5399084","TURQBLUE","5"}}};
		// launchApplication() will point to RTLandingPage class so it should return landingPage object
		launchApplication(); // we are calling the method of parent class directly
		RTLandingPage landingPage=new RTLandingPage(driver);
		RTProductCatalogue productCatalogue=landingPage.loginApplication(email,password);
		productCatalogue.commonObjectCalling(driver, "5086343", "DARKGREY", "6");
		//productCatalogue.commonObjectCalling(driver, id, colour, size);
		RTCheckout checkOut=productCatalogue.goToCartPage();
		checkOut.commonObjectCalling();
		driver.close();
		System.out.println("Need to implement BaseTest.java code 1st");
		System.out.println("Need to implement tetsNg framework 2nd");
		System.out.println("Need to implement Hashmap conept 3rd");
		System.out.println("Git repo renaming - checked");
		System.out.println("Need to implement pasting changes in UI concept");
	}
}
//		item1.commonObjectCalling(RTPItemsNeeded.driver, "5086343", "DARKGREY", "6");
//		item2.commonObjectCalling(RTPItemsNeeded.driver, "5592343", "PEACH", "4");
//		item3.commonObjectCalling(RTPItemsNeeded.driver, "5399084", "TURQBLUE", "5");
//		
		
	



