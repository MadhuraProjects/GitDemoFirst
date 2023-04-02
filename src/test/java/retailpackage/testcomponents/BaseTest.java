package retailpackage.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

import retailpackage.RTpageobject.RTLandingPage1;

public class BaseTest {
	public WebDriver driver;
	public RTLandingPage1 landingPage;
	public WebDriver initializeDriver() throws IOException
	{
		//we need to create object of properties file
		Properties prop=new Properties();
		// we need to convert into input stream
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//retailpackage//resources//GlobalData.properties");
		//load method expects input stream object
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
		}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException
	{
		// reading json to String
		String jsonContent=FileUtils.readFileToString(new File(filepath));			
		// convert String to HashMap-- Jackson DataBind
		// The ObjectMapper class has a method readValue to convert String to HashMap
		ObjectMapper mapper= new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
			});
			
		// so the object data stores 2 hashmaps -- 1st hashmap containing 1st set of data and 2nd containing 2nd set of data
		return data;
	}
	
	// this is a common method for all the test initiation so we will write the driver initiation and url launch code in BeforeMethod
	@BeforeMethod(alwaysRun=true)
	public RTLandingPage1 launchApplication() throws IOException, InterruptedException
	{
		driver=initializeDriver();
		Thread.sleep(2000);
		landingPage=new RTLandingPage1(driver);
		//driver.get("https://www.bata.in/login");
		landingPage.goTo();
		return landingPage;
	}
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}
	
}
