package org.sample.wordpress.tests;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.sample.wordpress.utilities.ReadConfig;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	ReadConfig readconfig=new ReadConfig();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
	public String url=readconfig.getURL();
	public String HomePageTitle=readconfig.getHomePageTitle();
	public String ProfilePageTitle=readconfig.getProfilePageTitle();
	public String SuccessMessage=readconfig.getSuccessMessage();
	public String ProfilePageHeader=readconfig.getprofilepageheader();
	public String GravatarLinkTitle=readconfig.getGravatarLinkTitle();
	public String ProfileDesp=readconfig.verifyProfileDesp();
	public String ProfileURL=readconfig.verifyProfileURL();
	public static WebDriver driver;
	
	 private static final Logger logger = LogManager.getLogger(Base.class);
	
	
	@Parameters("browser")
    @BeforeClass
	public void setup(String browsername) {
	
	  if (browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath() );
			driver = new FirefoxDriver();
	  }
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		
	}
	
	
	@AfterClass
	public void tearDOWN()
	{
		driver.quit();
	}
	
	
}
