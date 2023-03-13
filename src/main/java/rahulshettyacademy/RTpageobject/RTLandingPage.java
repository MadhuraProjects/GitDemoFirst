package rahulshettyacademy.RTpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.cache.AbstractCache;

import rahulshettyacademy.RTabstractcomponent.AbstractComponent;

public class RTLandingPage extends AbstractComponent{

	WebDriver driver;
	public RTLandingPage(WebDriver driver)
	{
		// to send the driver variable of the child class to the parent class
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	// Page Factory
	@FindBy(id="login-form-email")
	WebElement useremail;
	@FindBy(id="loginPassword")
	WebElement pwd;
	@FindBy(css=".cc-button-type-1.js-analytics-loginButton")
	WebElement submit;
	public void goTo()
	{
		driver.get("https://www.bata.in/login");
	}
	public RTProductCatalogue loginApplication(String email, String password) throws InterruptedException
	{
		useremail.sendKeys(email);
		pwd.sendKeys("MyBata@123");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,300)");
		submit.click();
		Thread.sleep(5000);
		RTProductCatalogue productCatalogue=new RTProductCatalogue(driver);
		return productCatalogue;
	}
}
