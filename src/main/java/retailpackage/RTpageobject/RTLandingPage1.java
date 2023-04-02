package retailpackage.RTpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.cache.AbstractCache;

import retailpackage.RTabstractcomponent.AbstractComponent;

public class RTLandingPage1 extends AbstractComponent{

	WebDriver driver;
	public RTLandingPage1(WebDriver driver)
	{
		// to send the driver variable of the child class to the parent class
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	// Page Factory
	@FindBy(id="login-form-email")
	WebElement useremail;
	@FindBy(id="login-form-password")
	WebElement pwd;
	@FindBy(css=".cc-button-type-1.js-analytics-loginButton")
	WebElement submit;
	@FindBy(css=".alert.alert-danger")
	WebElement errorMessage;
	
	public void goTo()
	{
		driver.get("https://www.bata.in/login");
	}
	public RTProductCatalogue loginApplication(String email, String password) throws InterruptedException
	{
		useremail.sendKeys(email);
		pwd.sendKeys(password);
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,300)");
		submit.click();
		System.out.println(" You have succesfully logged in !!!");
		System.out.println(" Please wait while we load the website ");
		Thread.sleep(5000);
		RTProductCatalogue productCatalogue=new RTProductCatalogue(driver);
		return productCatalogue;
	}
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
}
