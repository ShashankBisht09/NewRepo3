package com.project.selenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolsQAPage {
	WebDriver driver;

	public ToolsQAPage(WebDriver driver){
		
		this.driver=driver;
	}
private By FRAME_ID=By.xpath("//iframe[@id='IF2']");
private By TAB_3=By.xpath("//a [@id='ui-id-3']");
private By TAB_3_CONTENT=By.xpath("//div[@id='tabs-3']/b");
private By DEMO_SITE= By.xpath("//a[@class='ripple']/span/span/span[text()='DEMO SITES']");
private By DROP_CLICK=By.xpath("//a[@class='ripple']/span/span/span[text()='Handling Alerts using Selenium WebDriver']");
private By SIMPLE_ALERT=By.xpath("//button[text()='Simple Alert']");
private By CONFIRM_ALERT=By.xpath("//button[text()='Confirm Pop up']");
private By PROMPT_ALERT=By.xpath("//button[text()='Prompt Pop up']");



public void switchToFrame(){
	driver.switchTo().frame(driver.findElement(FRAME_ID));
}
public void switchToMain(){
	driver.switchTo().defaultContent();
}

public void clickOnTab3(){
	driver.findElement(TAB_3).click();
}
public String tab3Content(){
	String t=driver.findElement(TAB_3_CONTENT).getText();
	return t;
}
public void mouseOver(){
	
	 Actions act=new Actions(driver);
	 act.moveToElement(driver.findElement(DEMO_SITE)).build().perform();
	
}
public void clickOnHandling(){
	driver.findElement(DROP_CLICK).click();	
}
public String clickOnSimple() throws InterruptedException{
	driver.findElement(SIMPLE_ALERT).click();
	Alert alert=driver.switchTo().alert();
	String s= alert.getText();
	Thread.sleep(2000);
	alert.accept();
	return s;
	
	
}

public void clickOnConfirm() throws InterruptedException{
	driver.findElement(CONFIRM_ALERT).click();
	Alert alert=driver.switchTo().alert();
	Thread.sleep(2000);
	alert.dismiss();
}
public void clickOnPrompt() throws InterruptedException{
	driver.findElement(PROMPT_ALERT).click();
	Alert alert=driver.switchTo().alert();
	alert.sendKeys("Yes");
	Thread.sleep(2000);
	alert.accept();
}
}
