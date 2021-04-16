package org.sample.wordpress.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver rdriver){
		this.driver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(how = How.XPATH,using = "//li[@class='x-nav-item x-nav-item--wide']/a[contains(@title,'Log In')]")
	private WebElement LogInLink;
	
	@FindBy(id="usernameOrEmail")
	private WebElement uname;
	
	@FindBy(how = How.XPATH,using = "//button[text()='Continue']")
	private WebElement continueBtn;
	
	@FindBy(id="password")
	private WebElement pwd;
	
	@FindBy(how = How.XPATH,using = "//button[text()='Log In']")
	private WebElement LogInBtn;
	
    public void clickLogInLink() {
    	LogInLink.click();
		
	}   
	
	
	public void setUserName(String username) {
		uname.sendKeys(username);	
		
	}
	
	 public void clickContinueBtn() {
		 continueBtn.click();
			
		}   
		
		
	 public void setPassword(String password) {
		 pwd.sendKeys(password);	
			
		}
	 
	 public void clickLogInBtn() {
		 LogInBtn.click();
			
		}   
			
	}


