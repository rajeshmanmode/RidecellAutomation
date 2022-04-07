package Tests;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.RepositoriesPage;
import Utils.ApiUtils;
import Utils.BrowserUtilities;

public class RideCellTest {
	


	@Test
	public void TestNameAndDescriptions() throws IOException{
		
		Logger logger = LoggerFactory.getLogger("SampleLogger");
		
		logger.info("Test started");
		
		BrowserUtilities bu = new BrowserUtilities();
		ApiUtils au = new ApiUtils();
		
		HomePage home = bu.intiBrowser();
		
		try {
		RepositoriesPage repoPage = home.GotoRepo();
		
		Map<String,String> uiValues= repoPage.getRepoNameAndDescrip();
		
		Map<String,String> apiValues = au.getAPIResponse();
		
		Assert.assertTrue(uiValues.equals(apiValues),"Values from API and UI does not match");
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		logger.info("Test Completed");
	}
}
