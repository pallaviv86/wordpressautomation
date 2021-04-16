package org.sample.wordpress.tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.sample.wordpress.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC002_NavigateToMyProfilePage extends Base {
	
private static final Logger logger = LogManager.getLogger(TC002_NavigateToMyProfilePage.class);
	
@BeforeClass
public void setup() throws InterruptedException{
	 TC001_LogInTestCase tc1=new TC001_LogInTestCase();
	    tc1.loginTest();
	    Thread.sleep(1000);
	    
}
	
	@Test
	public void navigateToMyProfile() throws InterruptedException
	{
	      HomePage homepage=new HomePage(driver);
	      homepage.clickMyProfileLink();
	      Thread.sleep(1000);
	      logger.info("MyProfile link is clicked");
	      Assert.assertEquals(driver.getTitle(), ProfilePageTitle);
	      logger.info("MyProfile page title is verified");
	         
	}

}
