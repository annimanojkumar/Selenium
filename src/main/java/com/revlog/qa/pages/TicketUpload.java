package com.revlog.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.revlog.qa.base.TestBase;

public class TicketUpload extends LoginPage {
	public static String s;
	@FindBy(xpath="//div[@id='bs-example-navbar-collapse-1']/load-template/ul[1]/li[1]/a/span")
	private WebElement tic;
	@FindBy(xpath="//div[@id='bs-example-navbar-collapse-1']//li[6]/a")
	private WebElement ct;
	@FindBy(xpath="//div[@id='bs-example-navbar-collapse-1']//li[6]/ul/li[1]/a")
	private WebElement upt;
	@FindBy(id="retailerId")
	private WebElement rt;
	@FindBy(xpath="//input[@id='file']")
	private WebElement sf;
	@FindBy(xpath="//button[@id='saveBtn']")
	private WebElement uf;
	@FindBy(xpath="//div[@id='bs-example-navbar-collapse-1']/load-template/ul[1]/li[1]/ul/li[2]/a")
	private WebElement uncl;
	public TicketUpload (WebDriver driver) throws IOException
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void TP() throws InterruptedException{
		tic.click();
		ct.click();
		upt.click();
		Thread.sleep(5000);
		rt.click();
		Select Sel=new Select(rt);
		Sel.selectByVisibleText("Demo Retailer");
		Thread.sleep(5000);
	}
	
	
	public String SelectFile() throws InterruptedException, AWTException, Throwable, InvalidFormatException, IOException{
		String a="C:\\Users\\Bizlog\\Desktop\\dataaa11.xlsx";
		FileInputStream fis=new FileInputStream(a);
		Workbook wb=WorkbookFactory.create(fis);
		Cell c=wb.getSheet("sheet1").getRow(0).getCell(0);
		String s1=c.toString();
		System.out.println(s1);
		if(s1.equals("Buy Back"))
		{
			s="C:\\Users\\Bizlog\\Desktop\\buyback1.xlsx";
		}
		else if(s1.equals("PickAndDrop(one way)"))
		{
			s="C:\\Users\\Bizlog\\Desktop\\pnd.xlsx";
		}
		else if(s1.equals("PickAndDrop(two way)"))
		{
		    s="C:\\Users\\DELL\\Desktop\\PICK AND DROP TWO WAY.xlsx";
		}
		else if(s1.equals("Advance Exchange"))
		{
			s="C:\\Users\\DELL\\Desktop\\ticket-upload-Demo-AdvanceExchange-DEMO.xlsx";
		}
		sf.click();
		Thread.sleep(5000);
		StringSelection ss = new StringSelection(s);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
	    r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		//System.out.println(s);
		return s;
		
	}
	public void UploadFile() throws InterruptedException{
		uf.click();
		Thread.sleep(5000);
	}
	public String getName() throws InterruptedException {
		tic.click();
		uncl.click();
		Thread.sleep(5000);
		String ticketname=".//*[@id='pagecontents']/div/table/tbody/tr[1]/td[3]";
	   WebElement name=	driver.findElement(By.xpath(ticketname));
	   String s=name.getText();
	   return s;
		
	}
}
