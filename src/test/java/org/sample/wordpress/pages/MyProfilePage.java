package org.sample.wordpress.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {
	
	
		WebDriver driver;
			
			public MyProfilePage(WebDriver rdriver){
				this.driver=rdriver;
				PageFactory.initElements(rdriver, this);
				
			}
			
			@FindBy(how = How.XPATH,using = "//h1[@class='formatted-header__title wp-brand-font']")
			private WebElement HeaderTitle;
			
			@FindBy(how = How.XPATH,using = "//div[@class='section-header__label']/span[text()='Profile']")
			private WebElement SectionHeaderTitle;
			
			@FindBy(how = How.XPATH,using = "//a[text()='your profile']")
			private WebElement YourProfileLink;
			
			@FindBy(how = How.XPATH,using = "//a[text()='Gravatar Hovercards']")
			private WebElement GravatarHovercardsLink;
			
			@FindBy(id="first_name")
			private WebElement Fname;
			
			@FindBy(id="last_name")
			private WebElement Lname;
			
			@FindBy(id="display_name")
			private WebElement DisplayName;
			
			@FindBy(id="description")
			private WebElement AboutMe;
			
			@FindBy(how = How.XPATH,using = "//button[@class='button form-button is-primary']")
			private WebElement SaveProfile;
			
			@FindBy(how = How.XPATH,using = "//span[@class='notice__text']")
			private WebElement SuccessMsg;
			
			@FindBy(how = How.XPATH,using = "//button[@class='button is-compact']")
			private WebElement AddBtn;
			
			@FindBy(how = How.XPATH,using = "//button[text()='Add WordPress Site']")
			private WebElement AddWordPressSiteBtn;
			
			@FindBy(how = How.XPATH,using = "//button[text()='Add URL']")
			private WebElement AddURLBtn;
			
			@FindBy(how = How.XPATH,using = "//button[text()='Cancel']")
			private WebElement CancelBtn;
			
			@FindBy(how = How.XPATH,using = "//input[@class='form-text-input profile-links-add-other__value']")
			private WebElement EnterURL;
			
			@FindBy(how = How.XPATH,using = "//input[@class='form-text-input profile-links-add-other__title']")
			private WebElement EnterProfileDescription;
			
			@FindBy(how = How.XPATH,using = "//button[text()='Add Site']")
			private WebElement AddSiteBtn;
			
			@FindBy(how = How.XPATH,using = "//span[@class='profile-link__url']")
			private WebElement AddedProfileURL;
			
			@FindBy(how = How.XPATH,using = "//span[@class='profile-link__title']")
			private WebElement AddedProfileDesp;
			
			@FindBy(how = How.XPATH,using = "//button[@class='button inline-help__button is-borderless']")
			private WebElement Help;
			
			@FindBy(how = How.XPATH,using = "//div[@class='edit-gravatar__image-container']")
			private WebElement Image;
			
			@FindBy(how = How.XPATH,using = "//button[@class='button profile-link__remove is-borderless']")
			private List<WebElement> RemoveBtn;
			
			@FindBy(how = How.XPATH,using = "//ul[@class='profile-links-add-wordpress__list']//li")
			private List<WebElement> AllSites;
			
			public String verifyHeaderTitle() {
				return (HeaderTitle.getText());
			}
			public String verifySectionHeaderTitle() {
				return (SectionHeaderTitle.getText());
			}
			
			public boolean verifyYourProfileLink() {
				return (YourProfileLink.isDisplayed());
			}
			public void clickYourProfileLink() {
				YourProfileLink.click();
			}
			
			
			public boolean verifyGravatarHovercardsLink() {
				return(GravatarHovercardsLink.isDisplayed());
			}
			public void clickGravatarHovercardsLink() {
				GravatarHovercardsLink.click();
			}
			
			public void setFName(String fname) {
				Fname.clear();
				Fname.sendKeys(fname);	
				
			}
			public void setLName(String lname) {
				Lname.clear();
				Lname.sendKeys(lname);	
				
			}
			
			public String verifyDisplayName() {
				return (DisplayName.getAttribute("value"));
			}
			public void setDescription(String description) {
				AboutMe.clear();
				AboutMe.sendKeys(description);	
				
			}
			public void clickSaveProfileBtn() {
				SaveProfile.click();

		    }
			public String verifySuccessMsg() {
				return (SuccessMsg.getText());
			}
			public boolean verifyAddBtn() {
				return (AddBtn.isDisplayed());
			}
			public void clickAddBtn() {
				AddBtn.click();
			}
			public boolean verifyAddURLBtn() {
				return (AddURLBtn.isDisplayed());
			}
			public boolean verifyAddWordPressSiteBtn() {
				return (AddWordPressSiteBtn.isDisplayed());
			}
			public void clickAddURLBtn() {
				AddURLBtn.click();
			}
			
			public void clickAddWordPressSiteBtn() {
				AddWordPressSiteBtn.click();
			}
			public void clickCancelBtn() {
				CancelBtn.click();
			}
			public void setURL(String url) {
				EnterURL.clear();
				EnterURL.sendKeys(url);	
				
			}
			public void setProfileDescription(String profiledesp) {
				EnterProfileDescription.clear();
				EnterProfileDescription.sendKeys(profiledesp);	
				
			}
			public void clickAddSiteBtn() {
				AddSiteBtn.click();

		    }
			public String verifyAddedProfileURL() {
				return (AddedProfileURL.getText());
			}
			public String verifyAddedProfileDesp() {
				return (AddedProfileDesp.getText());
			}
			
			public boolean verifyHelpButton() {
				return (Help.isDisplayed());
			}
			
			public boolean verifyImage() {
				return (Image.isDisplayed());
			}
			
			public List<WebElement> getRemoveList() {
				return (RemoveBtn);
			}
			
			public List<WebElement> getAllSites() {
				return (AllSites);
			}
			
			public void removeAll() {
				List<WebElement> remove=getRemoveList();
			      int count2=remove.size();
			      System.out.println("Number of remove buttons listed:"+count2);
			      if(count2!=0)
			      {
			      for (WebElement r : remove) {
			    	   r.click();
			    	  }
			      }
				
				
			}
			
			public void selectAllSites() throws InterruptedException {
				List<WebElement> allsites=getAllSites();
			      int count=allsites.size();
			      System.out.println("Number of sites listed :"+count);
			      if(count!=0)
			      {
			      for(int i=1; i <= allsites.size(); i++)
			        {
			    	  driver.findElement(By.xpath("//ul[@class='profile-links-add-wordpress__list']/li["+ i + "]/input")).click();
			        }
			      
			      clickAddSiteBtn();
			      System.out.println("All available site checkboxes are selected");
			      Thread.sleep(1000);
			      }
			      
			      else
			      {
			    	  clickCancelBtn();
			    	  System.out.println("Cancel button is clicked");
					  Thread.sleep(1000);
				      
			      }
				
			}


}
