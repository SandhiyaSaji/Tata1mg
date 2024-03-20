package com.tata1mg;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Medi {
	static WebDriver driver;
    static Actions action;
    
    
	
   @BeforeClass
   public static void method1() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
		driver=new ChromeDriver(options);
		driver.get("https://www.1mg.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement( By.xpath("//div[text()='Cancel']")).click();
	    action=new Actions(driver); 
   
   }
   
   @AfterClass
   public static void method() {
	System.out.println("Browser closed");  
   }
   
   @Before
   public void beforeMethod() {
	System.out.println("Before Method");  
   }
   
   @After
   public void afterMethod() {
	System.out.println("After method");  
   }
   
   @Test
    public void method2() {
		WebElement medicine=driver.findElement(By.xpath("//div[text()='Medicines']"));
		medicine.click();
		String actTitle=driver.getTitle();
		String expTitle="Online Pharmacy India | Buy Medicines from India's Trusted Medicine Store: 1mg.com";
		Assert.assertEquals(expTitle, actTitle);
	}
   
   @Test
    public void method3() {
	    WebElement VitAndNut = driver.findElement(By.xpath("//span[text()='Vitamins & Nutrition']"));
	    action.moveToElement(VitAndNut).build().perform();
    }
   
   @Test
    public void method4() {
    	 WebElement multivit =driver.findElement(By.xpath("//span[text()='Multivitamins']"));
         multivit.click();
    
    }
   
   @Test
    public void method5() {
    	WebElement multivitforMen =driver.findElement(By.xpath("//div[text()='Multivitamins for Men']"));
    	action.moveToElement(multivitforMen).build().perform();
    	multivitforMen.click();
    }
   
   //@Ignore -->Does not execute the method
   @Test
    public void method6() {
    	List <WebElement> products=driver.findElements(By.xpath("//div[contains(@class,'style__pro-title___2QwJy')]"));
        for(int i=0;i<products.size();i++) {
        	String text=products.get(i).getText();
        	if(text.contains("Men")||text.contains("Multivitamin")) {
        		System.out.println("Contains: " + text);
        	}
        	else {
        		System.out.println("Not Contains: " + text);
        	}
        } 
    
    }
}
