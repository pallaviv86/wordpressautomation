package org.sample.wordpress.tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.sample.wordpress.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_LogInTestCase extends Base{
	
	 private static final Logger logger = LogManager.getLogger(TC001_LogInTestCase.class);
	 
	@Test
	public void loginTest()
	{
	  
      LoginPage login = new LoginPage(driver);
      login.clickLogInLink();
      logger.info("Log In link is clicked");
      login.setUserName(username);
      logger.info("Entered Username");
      login.clickContinueBtn();
      logger.info("Continue button is clicked");
      login.setPassword(password);
      logger.info("Entered Password");
      login.clickLogInBtn();
      logger.info("LogIn button is clicked");
      Assert.assertEquals(driver.getTitle(), HomePageTitle);
      logger.info("HomePage page title is verified");
         
	}
    
}
