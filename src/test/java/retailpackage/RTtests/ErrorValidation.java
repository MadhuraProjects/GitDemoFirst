package retailpackage.RTtests;

import org.testng.Assert;
import org.testng.annotations.Test;

import retailpackage.RTpageobject.RTProductCatalogue;
import retailpackage.testcomponents.BaseTest;

public class ErrorValidation extends BaseTest{

	@Test
	public void ErrorValidation() throws InterruptedException
	{
		String email="cmadhura22j2018@gmail.com";
		String password="MyBat";
		RTProductCatalogue productCatalogue=landingPage.loginApplication(email,password);
		Assert.assertEquals("Incorrect e-mail or password",landingPage.getErrorMessage());
		System.out.println("The Error Validation Test is executed succesfully !!!");
		System.out.println("This is a regular branch check !!!");
	}
}
