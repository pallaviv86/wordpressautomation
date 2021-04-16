package org.sample.wordpress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
	
	public HomePage(WebDriver rdriver){
		this.driver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(how = How.XPATH,using = "//header[@id='header']//img[@class='gravatar']")
	private WebElement MyProfileLink;
	
	public void clickMyProfileLink() {
		MyProfileLink.click();

}
}
