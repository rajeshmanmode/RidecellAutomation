package Pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RepositoriesPage {

	WebDriver driver;
	
	String repoListXpath = "//div[@class='Box']/ul/li";
	String nameXpath = "//a[@itemprop='name codeRepository']";
	String descriptionXpath = "//p[@itemprop='description']"; 
	
	By reporsListlocator = By.xpath(repoListXpath);
	By nameLocator = By.xpath(nameXpath);
	By descripLocator = By.xpath(descriptionXpath);
	
	
	public RepositoriesPage(WebDriver driver) {
		this.driver=driver;
	}

	public Map<String, String> getRepoNameAndDescrip() {
		Map<String, String> m1 = new HashMap<String, String>();
		String key,val="";
		
		List<WebElement> reposlist = driver.findElements(reporsListlocator);
		for(WebElement w : reposlist) {
			key = w.findElement(nameLocator).getText();
			
			if(w.findElement(descripLocator).isDisplayed()) {
				val = w.findElement(descripLocator).getText();
			}
			
			m1.put(key, val);
		}
		
		System.out.println(m1);
		return m1;
				
	}
}