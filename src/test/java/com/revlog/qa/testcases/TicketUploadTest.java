package com.revlog.qa.testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.revlog.qa.base.TestBase;
import com.revlog.qa.pages.LoginPage;
import com.revlog.qa.pages.TicketUpload;
import com.revlog.qa.utils.TestUtil;

public class TicketUploadTest extends TestBase{
	LoginPage loginpage;
	TicketUpload ticketupload;
	
	public TicketUploadTest() {
		super();
		
	}


	@BeforeTest
	public void setUp() throws Exception
	{
		initialization();
		 loginpage=new LoginPage(driver);
		loginpage.ValidateLp(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(10000);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void upload() throws AWTException, Throwable
	{
		ticketupload=new TicketUpload(driver);
		ticketupload.TP();
		try {
			ticketupload.SelectFile();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		Thread.sleep(5000);
		ticketupload.UploadFile();
		
		
		Thread.sleep(500);
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		String t=ticketupload.getName();
		Assert.assertEquals("Test abc[Nokia 3] - Initial Call"	, t);
		
		
		
		
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	

}
