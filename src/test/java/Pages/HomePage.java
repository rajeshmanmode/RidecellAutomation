package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage {

	Logger logger = LoggerFactory.getLogger("SampleLogger");
	WebDriver driver;

	WebDriverManager wm;

	public String reprsitorylinkxpath = "//a[@href=\"/orgs/django/repositories\"]";

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	public RepositoriesPage GotoRepo() {

		By repoLink = By.xpath(reprsitorylinkxpath);
		logger.info("repository link clicked, navigating to repositories page");
		driver.findElement(repoLink).click();
		return new RepositoriesPage(driver);
	}
}
