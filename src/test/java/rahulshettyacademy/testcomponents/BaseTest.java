package rahulshettyacademy.testcomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver(); 
	
}
