package org.sample.wordpress.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ReadConfig {
	
	 private static final Logger logger = LogManager.getLogger(ReadConfig.class);
	 
	Properties prop;
	public ReadConfig()
	{
		File src= FileReaderUtil.readResourceFile("/config.properties");
		try {
			FileInputStream ip = new FileInputStream(src);
			prop = new Properties(); 
			prop.load(ip);
		} catch (Exception exception) {
			logger.error(exception);

		} 
	}
	public String getURL()
	{
		String url=prop.getProperty("url");
		return url;
	}
	public String getUserName()
	{
		String uname=prop.getProperty("username");
		return uname;
	}
	
	public String getPassword()
	{
		String pwd=prop.getProperty("password");
		return pwd;
	}
	
	
	public String getFirefoxPath()
	{
		Path path = FileSystems.getDefault().getPath("src/test/resources/"+ prop.getProperty("firefoxpath"));
		return path.toString();
	}

	public String getHomePageTitle()
	{
		String HomePageTitle=prop.getProperty("homePageTitle");
		return HomePageTitle;
	}
	
	public String getProfilePageTitle()
	{
		String ProfileTitle=prop.getProperty("profilePageTitle");
		return ProfileTitle;
	}
	
	public String getSuccessMessage()
	{
		String SuccessMessage=prop.getProperty("successmessage");
		return SuccessMessage;
	}
	public String getprofilepageheader()
	{
		String ProfilePageHeader=prop.getProperty("profilepageheader");
		return ProfilePageHeader;
	}
	public String getGravatarLinkTitle()
	{
		String GravatarLinkTitle=prop.getProperty("gravatarchildwindow");
		return GravatarLinkTitle;
	}
	public String verifyProfileURL()
	{
		String ProfileURL=prop.getProperty("profileURL");
		return ProfileURL;
	}
	public String verifyProfileDesp()
	{
		String ProfileDesp=prop.getProperty("profileDesp");
		return ProfileDesp;
	}
}
