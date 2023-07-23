package com.test.lambda;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MyHomeIE {
	
	public boolean status=false;
	
	public static void main(String[] args) throws InterruptedException{
		 String url="https://www.myhome.ie/";
		 By accept_loc=By.xpath("//button[contains(text(),'I ACCEPT')]");
		
		 
		 System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver_114.exe");
		 WebDriver driver=new ChromeDriver();
		 
		 driver.get(url);
		 Thread.sleep(3000);
		 driver.manage().window().maximize();
		 Thread.sleep(3000);
		//div[contains(@class,'results-panel')][1]//h2//a[1]
		 driver.findElement(accept_loc).click();
		 Thread.sleep(2000);
		 SearchBox(driver, "Dublin 22", "1,500");
		 int size=driver.findElements(By.xpath("//div[contains(@data-cy,'results-card')]//a/h2")).size();
		 Thread.sleep(2000);
		 for(int i=1;i<=size;i++){
			 driver.findElement(By.xpath("//div[contains(@data-cy,'results-card')]["+i+"]//a/h2")).click();
			 EmailAgent(driver, "Vinyk", "test@gmail.com", "+3538999999");
		 }
		 driver.quit();
	}
	
	 public static boolean SearchBox(WebDriver driver ,String county,String maxprice){
		 try{
			 By search_btn=By.xpath("//button[contains(text(),'Sea')]");
			 By county_loc=By.xpath("//button[contains(@class,'dropdown-toggle')]//span[contains(text(),'County')]");
			 By search_loc=By.xpath("//input[contains(@placeholder,'Sea')]");
			 By countyvalue_loc=By.xpath("//div[contains(text(),'"+county+"')]");
			 By rent_loc=By.xpath("//div//span[contains(text(),'Rent')]");
			 By maxprice_loc=By.xpath("//button//span[contains(text(),'Max')]");
			 By maxpricetag_loc=By.xpath("//div//div[contains(text(),'"+maxprice+"')]");
			 
			 
			 driver.findElement(rent_loc).click();
			 Thread.sleep(2000);
			 driver.findElement(county_loc).click();
			 Thread.sleep(2000);
			 driver.findElement(search_loc).sendKeys(county);
			 Thread.sleep(2000);
			 driver.findElement(countyvalue_loc).click();
			 Thread.sleep(2000);
			 driver.findElement(maxprice_loc).click();
			 Thread.sleep(2000);
			 driver.findElement(maxpricetag_loc).click();
			 Thread.sleep(2000);
			 driver.findElement(search_btn).click();
			 Thread.sleep(5000);
		 }catch(Exception e){
			 return false;
		 }
		 return true;
	 }
	 
	 public static boolean EmailAgent(WebDriver driver ,String name,String email,String phone){
		 try{
			 By email_btn=By.xpath("//button//div[contains(text(),'EMAIL')]");
			 By name_loc=By.xpath("//input[contains(@name,'name')]");
			 By email_loc=By.xpath("//input[contains(@name,'email')]");
			 By phone_loc=By.xpath("//input[contains(@name,'phone')]");
			 By message_loc=By.xpath("//textarea[contains(@name,'message')]");
			 By send_loc=By.xpath("//button[contains(text(),'Send')]");
			 By back_btn=By.xpath("//a[contains(text(),'Back')]");
			 
			 Thread.sleep(2000);
//			 ScrollUpOrDown(driver, email_btn);
//			 driver.findElement(email_btn).click();
//			 Thread.sleep(2000);
			 ScrollUpOrDown(driver, name_loc);
			 driver.findElement(name_loc).sendKeys(name);
			 
			 Thread.sleep(2000);
			 ScrollUpOrDown(driver, email_loc);
			 driver.findElement(email_loc).sendKeys(email);
			 
			 Thread.sleep(1000);
			 ScrollUpOrDown(driver, phone_loc);
			 driver.findElement(phone_loc).sendKeys(phone);
			 
			 Thread.sleep(1000);
			 ScrollUpOrDown(driver, message_loc);
			 driver.findElement(message_loc).sendKeys("msg");
			 
			 Thread.sleep(1000);
			 ScrollUpOrDown(driver, send_loc);
			 driver.findElement(send_loc).click();
			 
			 Thread.sleep(1000);
			 ScrollUpOrDown(driver, back_btn);
			 driver.findElement(back_btn).click();
			 
			 
		 }catch(Exception e){
			 return false;
		 }
		 return true;
	 }
	 
	 public static boolean ScrollUpOrDown(WebDriver driver,By ele){
			try{
				Thread.sleep(1000);
				WebElement element=driver.findElement(ele);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(2000);
				driver.findElement(ele).isDisplayed();
			}catch(Exception e){
				return false;
			}
			return true;
		}

}
