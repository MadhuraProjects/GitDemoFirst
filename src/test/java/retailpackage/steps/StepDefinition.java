package retailpackage.steps;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import retailpackage.RTpageobject.RTCheckout;
import retailpackage.RTpageobject.RTLandingPage1;
import retailpackage.RTpageobject.RTProductCatalogue;
import retailpackage.testcomponents.BaseTest;

public class StepDefinition extends BaseTest{
	public RTLandingPage1 landingPage;
	public RTProductCatalogue productCatalogue;
	public RTCheckout checkOut;
	
		@Given("I landed on ECommerce Page")
		public void I_landed_on_ECommerce_Page() throws IOException, InterruptedException
		{
			landingPage=launchApplication();
		}
	 	@Given("^I login with username (.+) and password (.+)$")
	    public void i_login_with_username_and_password(String email, String password) throws Throwable {
	 		productCatalogue=landingPage.loginApplication(email,password);
	    }

//	    @When("^I select product by id (.+) and colour (.+) and size (.+) and added to cart$")
//	    public void i_select_product_by_id_and_colour_and_size(String id, String colour, String size) throws Throwable {
//	    	productCatalogue.commonObjectCalling(driver, id,colour,size);
//	    }
//
//	    @Then("I checkout")
//	    public void i_checkout() throws Throwable {
//			checkOut=productCatalogue.goToCartPage();
//			checkOut.commonObjectCalling();
//			tearDown();
//	    }

	    @When("^I select product by id (.+) and colour (.+) and size (.+) and moved to wishlist$")
	    public void i_select_product_by_id_and_colour_and_size_and_moved_to_wishlist(String id, String colour, String size) throws Throwable {
	    	productCatalogue.commonWishList(driver,id,colour,size);
	    }

	    @Then("I signout")
	    public void i_signout() throws Throwable {
	    	checkOut.signOut();
	    	tearDown();
	    }
	    

	    @Then("^\"([^\"]*)\" message is displayed$")
	    public void something_message_is_displayed(String strArg1) throws Throwable {
			Assert.assertEquals("Incorrect e-mail or password",landingPage.getErrorMessage());
			System.out.println("The Error Validation Test is executed succesfully !!!");
			tearDown();
	    } 
}
