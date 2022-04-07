package Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtilities {

	WebDriver driver;
	
	public static void main(String[] args) {
		
	}
	
	public HomePage intiBrowser() throws IOException {
		PropertyReader pr = new PropertyReader();
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(pr.readProperty("baseurl"));
		
		return new HomePage(driver);
	}
}
