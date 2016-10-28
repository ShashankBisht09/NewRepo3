package com.project.selenium.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class StoreQAPage {
	WebDriver driver;

	public StoreQAPage(WebDriver driver){
		
		this.driver=driver;

}
	private By MOUSE_OVER=By.xpath("//a[text()='Product Category']");
	private By IPHONE_LINK=By.xpath("//a[text()='iPhones']");
	private By CART_BUTTON=By.xpath("//div[@class='default_product_display product_view_40 iphones group']/descendant::input[@name='Buy']");
	private By CHECKOUT_BUTTON=By.xpath("//a [@class='go_to_checkout']");
	private By CONTINUE_BUTTON=By.xpath("//span[text()='Continue']");
	private By CALCULATE_BUTTON=By.xpath("//input[@value='Calculate']");
	private By DROPDOWN_BUTTON=By.id("current_country");
	
	
	public void mouseOver(){
		
		 Actions act=new Actions(driver);
		 act.moveToElement(driver.findElement(MOUSE_OVER)).build().perform();
		
	}
	public void clickOnIphone(){
	driver.findElement(IPHONE_LINK).click();	
	}
	public Boolean isElementPresent(){
		List<WebElement> allElement=driver.findElements(CART_BUTTON);
		if(allElement.size()==0){
			return false;
		}
		return true;
	}
	
	public void clickOnCart(){
		
		driver.findElement(CART_BUTTON).click();	
	}
	public void clickOnCheckout(){
		driver.findElement(CHECKOUT_BUTTON).click();	
	}
	public void clickOnContinue(){
		driver.findElement(CONTINUE_BUTTON).click();	
	}
	public void selectIndia(){
		Select sel=new Select(driver.findElement(DROPDOWN_BUTTON));
		sel.selectByVisibleText("India");
		
	}
	public void clickOnCalculate(){
		driver.findElement(CALCULATE_BUTTON).click();	
	}
	public String getURL(){
		String s=driver.getCurrentUrl();
		return s;
	}
	


}

	
