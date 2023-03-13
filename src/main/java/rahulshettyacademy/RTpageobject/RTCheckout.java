package rahulshettyacademy.RTpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.RTabstractcomponent.AbstractComponent;

public class RTCheckout extends AbstractComponent{

	WebDriver driver;
	public RTCheckout(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="cart-page-checkout-btn")
	WebElement proceedToCheck;
	@FindBy(css="button[value='submit-shipping']")
	WebElement proceedToPayment;
	@FindBy(css=".cc-icon.icon-close-remove")
	WebElement removeButton;
	@FindBy(css="div[class='cc-headerBar-link js-userIcon']")
	WebElement menuHeader;
	@FindBy(xpath="//div[@class='cc-header-userMenu-container js-userSubMenu']/a[4]")
	WebElement signOut;
	
	public void proceedToCheck() throws InterruptedException
	{
		proceedToCheck.click();
		Thread.sleep(2000);
	}
	
	public void proceedToPayment()
	{
		proceedToPayment.click();
		goToCartPage();
		
	}
	
	public void remove() throws InterruptedException
	{
		removeButton.click();
		Thread.sleep(3000);
	}
	
	public void signOut() throws InterruptedException
	{
		menuHeader.click();
		signOut.click();
		System.out.println(" You are successfully logged out !!!");
		Thread.sleep(1000);
	}
	public void commonObjectCalling() throws InterruptedException
	{
		proceedToCheck();
		proceedToPayment();
		remove();
		signOut();
	}
}
