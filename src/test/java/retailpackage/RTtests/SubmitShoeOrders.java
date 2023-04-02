package retailpackage.RTtests;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import retailpackage.RTpageobject.RTCheckout;
import retailpackage.RTpageobject.RTLandingPage1;
import retailpackage.RTpageobject.RTProductCatalogue;
import retailpackage.testcomponents.BaseTest;

public class SubmitShoeOrders extends BaseTest{
	public String wishListid="5615602";
	public String email="cmadhura22j2018@gmail.com";
	public String password="MyBata@123";
	public RTProductCatalogue productCatalogue;
 
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitShoeOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{
		
		//String email="cmadhura22j2018@gmail.com";
		//String password="MyBata@123";
//		RTLandingPage landingPage= new RlTLandingPage(driver);
//		landingPage.goTo();
		productCatalogue=landingPage.loginApplication(email,password);
		//we can use landingPage object directly since it is declared public in parent class
		productCatalogue.commonObjectCalling(driver, input.get("id"),input.get("colour"),input.get("size"));
		RTCheckout checkOut=productCatalogue.goToCartPage();
		checkOut.commonObjectCalling();
	}
////		item1.commonObjectCalling(RTPItemsNeeded.driver, "5086343", "DARKGREY", "6");
////		item2.commonObjectCalling(RTPItemsNeeded.driver, "5592343", "PEACH", "4");
////		item3.commonObjectCalling(RTPItemsNeeded.driver, "5399084", "TURQBLUE", "5") 5515913;
//

@Test
public void wishListOrder() throws InterruptedException
{
	productCatalogue=landingPage.loginApplication(email,password);
	//RTProductCatalogue productCatalogue=new RTProductCatalogue(driver);
	productCatalogue.commonWishList(driver, "6612079", "GREY", "4");
	//productCatalogue.commonWishList(driver, "5515913", "RED", "4");
	RTCheckout checkOut=new RTCheckout(driver);
	checkOut.signOut();
	}
	
//	@Test
//	public void SampleCheck() throws InterruptedException
//	{
//		String email="cmadhura22j2018@gmail.com";
//		String password="MyBata@123";
//		String id=" 6610912";
//		String colour="NUDE";
//		String size="4";
//		RTLandingPage1 lp=new RTLandingPage1(driver);
//		lp.loginApplication(email, password);
//		RTProductCatalogue pc=new RTProductCatalogue(driver);
//		pc.searchProduct(id);
//		pc.searchColour(colour, id);
//		pc.searchSize(size, id);
//		Thread.sleep(2000);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scroll(0,400)");
//		//Thread.sleep(3000);
//		pc.addToWishList(id);
//		Thread.sleep(3000);
//		System.out.println("the pdt "+id+" is added to wishlist !!!");
//		pc.goToWishList();
//		Thread.sleep(4000);
//		driver.close();
//	}

@DataProvider
public Object[][] getData() throws IOException
{
//	HashMap<String,String> map= new HashMap<String,String>();
//	map.put("id","7615045");
//	map.put("colour","ROSEGOLD");
//	map.put("size","5");
//	HashMap<String,String> map1= new HashMap<String,String>();
//	map1.put("id","7512065");
//	map1.put("colour","GREY");
//	map1.put("size","4");
	
	
	List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
	return new Object[][] {{data.get(0)},{data.get(1)}};
}
}

//
		
	



