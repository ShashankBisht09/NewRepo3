package com.project.selenium.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.project.selenium.pages.StoreQAPage;
import com.project.selenium.pages.ToolsQAPage;

public class ToolsStoreTest {
	WebDriver driver;
	
	@BeforeMethod
	public void initDriver(){
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		
	}
	@AfterMethod
	public void endDriver()
	{
		driver.quit();
			
	}
	@Test(priority=1)
	public void testToolsQA() throws InterruptedException{
		
		
		driver.get("http://toolsqa.com/iframe-practice-page/");
		ToolsQAPage obj=new ToolsQAPage(driver);
		obj.switchToFrame();
		obj.clickOnTab3();	
		String s1=obj.tab3Content();
		Assert.assertTrue(s1.contains("Content 3 Title"));
		obj.switchToMain();
		obj.mouseOver();
		obj.clickOnHandling();
        String a=obj.clickOnSimple();
        Assert.assertTrue(a.contains("A simple Alert"));
        obj.clickOnConfirm();
        obj.clickOnPrompt();
		
	}

	@Test(priority=2)
	public void testStoreQA() throws InterruptedException{
		
		
		driver.get("http://store.demoqa.com/");
		StoreQAPage obj1=new StoreQAPage(driver);
		
		obj1.mouseOver();
		obj1.clickOnIphone();
		Boolean a=obj1.isElementPresent();
		Assert.assertTrue(a);
		System.out.println("add to cart verified");
		obj1.clickOnCart();
		obj1.clickOnCheckout();
		obj1.clickOnContinue();
		obj1.selectIndia();
		obj1.clickOnCalculate();
		String url=obj1.getURL();
		Assert.assertTrue(url.contains("http://store.demoqa.com/products-page/checkout/"));
		System.out.println("URl verified");
		
	}
}
