package org.sample.wordpress.tests;

import java.util.Iterator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.sample.wordpress.pages.MyProfilePage;
import org.sample.wordpress.utilities.RandomString;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC003_MyProfilePageTestCase extends Base {
	
	 private static final Logger logger = LogManager.getLogger(TC003_MyProfilePageTestCase.class);
	 
	@BeforeClass
	public void setup() throws InterruptedException {
		//Login to application
		TC001_LogInTestCase tc1=new TC001_LogInTestCase();
	    tc1.loginTest();
	    Thread.sleep(1000);
	    //Navigate to MyProfile page
	    TC002_NavigateToMyProfilePage tc2=new TC002_NavigateToMyProfilePage();
		tc2.navigateToMyProfile();
		Thread.sleep(1000);
		}
	
	@Test
	public void verifyMyProfile() throws InterruptedException
	{
		 //Verify section header
	     MyProfilePage myprofile=new MyProfilePage(driver);
	     String actualSectionHeaderTitle=myprofile.verifySectionHeaderTitle();
	     Assert.assertEquals(actualSectionHeaderTitle, ProfilePageHeader);
	     logger.info("MyProfile Section Header is verfied");
	      
	     //Input Fname,Lname and Description
	      myprofile.setFName("Test");
	      logger.info("Entered first name");
	      myprofile.setLName("WordPress");
	      logger.info("Entered last name");
	      RandomString rs=new RandomString();
	      String description=rs.randomstring();
	      myprofile.setDescription("Testing"+description);
	      logger.info("Entered description");
	      String actualDisplayName=myprofile.verifyDisplayName();
	      Assert.assertEquals(actualDisplayName, username);
	      logger.info("Display name is verified");
	      
	      //Click Save profile button and verify success message
	      myprofile.clickSaveProfileBtn();
	      logger.info("Save profile button is clicked");
	      Thread.sleep(1000);
	      String actualSuccessMsg=myprofile.verifySuccessMsg();
	      Assert.assertEquals(actualSuccessMsg,SuccessMessage);
	      logger.info("Success Message is verified");
	      Thread.sleep(1000);
	      
	      //Verify your profile link and navigation to its respective child window 
	      Assert.assertTrue(myprofile.verifyYourProfileLink());
	      logger.info("YourProfile Link presence is verified");
	      myprofile.clickYourProfileLink();
	      logger.info("YourProfile Link is clicked");
	      Thread.sleep(1000);
	      Iterator<String> profile=driver.getWindowHandles().iterator();
	      String parent=profile.next();
	      String child=profile.next();
	      driver.switchTo().window(child);
	      logger.info("Focus currently on YourProfile child window");
	      Thread.sleep(1000);
	      String childbrowser=actualDisplayName+ " - Gravatar Profile";
	      Assert.assertEquals(driver.getTitle(),childbrowser);
	      logger.info("YourProfile child window title is verified");
	      driver.close();
	      driver.switchTo().window(parent);
	      logger.info("Focus back from YourProfile child window to parent window");
	      
	      //Verify Gravatar Hovarcards link and the respective child window navigation
	      Assert.assertEquals(myprofile.verifyGravatarHovercardsLink(),true);
	      logger.info("Gravatar Hovercards Link presence is verified");
	      myprofile.clickGravatarHovercardsLink();
	      logger.info("Gravatar Hovercards Link is clicked");
	      Iterator<String> Gravatar=driver.getWindowHandles().iterator();
	      String parent1=Gravatar.next();
	      String child1=Gravatar.next();
	      driver.switchTo().window(child1);
	      logger.info("Focus currently on Gravatar link child window");
	      Thread.sleep(1000);
	      Assert.assertEquals(driver.getTitle(),GravatarLinkTitle);
	      logger.info("Gravatar link child window title is verified");
	      driver.close();
	      driver.switchTo().window(parent1);
	      logger.info("Focus back from Gravatar link child window to parent window");
	      Thread.sleep(2000);
	     
	      
	      //Verify Add Button 
	      Assert.assertEquals(myprofile.verifyAddBtn(),true);
	      logger.info("Add Button presence is verified");
	      Thread.sleep(1000);
	      myprofile.clickAddBtn();
	      logger.info("Add Button is clicked");
	      Thread.sleep(1000);
	      
	      //Verify Add WordPress Site 
	      Assert.assertEquals(myprofile.verifyAddWordPressSiteBtn(),true);
	      logger.info("Add WordPress Site button presence is verified");
	      myprofile.clickAddWordPressSiteBtn();
	      logger.info("Add WordPress Site button clicked");
	      Thread.sleep(1000);
	      myprofile.selectAllSites();
	      
	      //Verify Add URL button
	      myprofile.clickAddBtn();
	      logger.info("Add Button is clicked");
	      Assert.assertEquals(myprofile.verifyAddURLBtn(),true);
	      logger.info("Add URL button presence is verified");
	      Thread.sleep(1000);
	      myprofile.clickAddURLBtn();
	      Thread.sleep(1000);
	      logger.info("Add URL button button clicked");
	      myprofile.setURL(ProfileURL);
	      logger.info("URL is entered");
	      myprofile.setProfileDescription(ProfileDesp);
	      logger.info("Description is entered");
	      myprofile.clickAddSiteBtn();
	      logger.info("Add Site Button is entered");
	      
	      //Remove all selections
	      Thread.sleep(1000);
	      myprofile.removeAll();
	      logger.info("All available remove buttons are selected");
	      
	      
	      //Verify Help option is displayed
	      Assert.assertEquals(myprofile.verifyHelpButton(),true);
	      logger.info("Verified HELP option is displayed");
	      
	      
	      //Verify Image option is displayed
	      Assert.assertEquals(myprofile.verifyImage(),true);
	      logger.info("Verified Profile Image element is displayed");
	}

}
