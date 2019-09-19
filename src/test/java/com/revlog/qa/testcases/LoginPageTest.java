package com.revlog.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.revlog.qa.base.TestBase;
import com.revlog.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage(driver);
	}
	
	
	@Test
	public void loginTest() throws Exception {
		 loginpage.ValidateLp(prop.getProperty("username"), prop.getProperty("password"));
		// driver.close();
		 
		 
		
	}
	
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.close();
		
	
	}
	
	

}
