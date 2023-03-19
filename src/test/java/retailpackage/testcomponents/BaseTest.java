package retailpackage.testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import retailpackage.RTpageobject.RTLandingPage;

public class BaseTest {
	public WebDriver driver;
	public WebDriver initializeDriver() throws IOException
	{
		//we need to create object of properties file
		Properties prop=new Properties();
		// we need to convert into input stream
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//retailpackage//resources//GlobalData.properties");
		//load method expects input stream object
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
		}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	// this is a common method for all the test initiation so we will write the driver initiation and url launch code here
	public RTLandingPage launchApplication() throws IOException
	{
		driver=initializeDriver();
		RTLandingPage landingPage=new RTLandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
}
