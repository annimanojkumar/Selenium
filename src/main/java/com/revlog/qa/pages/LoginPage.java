package com.revlog.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.revlog.qa.base.TestBase;


public class LoginPage extends TestBase {
	@FindBy(xpath="//input[@id='inputUsername']")
	private WebElement untb;
	@FindBy(xpath="//input[@id='inputPassword']")
	private WebElement pwtb;
	@FindBy(xpath="//input[@id='login']")
	private WebElement lgtb;
	
	
	
	public LoginPage(WebDriver driver) {
		

		PageFactory.initElements(driver,this);
	}
	


	public void ValidateLp(String a,String b) throws Exception{
		untb.sendKeys(a);
	    pwtb.sendKeys(b);
	    Thread.sleep(1000);
	    lgtb.click();
	    
	}
	
	

   
	
	
	
	
	
	
	
	
	

}
