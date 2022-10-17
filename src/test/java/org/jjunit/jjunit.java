package org.jjunit;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jjunit {
	
	static WebDriver driver;
	
	@BeforeClass
public static void beforeTest(){
	

	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
}
	@AfterClass
	public static void afterClass() {
		driver.quit();
	}
	@Before
	public void bFore() {
		Date d = new Date();
		System.out.println(d);
	}
	
	@After
	public void aFter() {
		Date d = new Date();
		System.out.println(d);
	}
	@Test
	public void test() throws InterruptedException {
		
		driver.get("https://facebook.com");
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		boolean contains = title.contains("Facebook – log in or sign up");
		
		Assert.assertTrue(contains);
		
		System.out.println("Verified");
	}
	
}
