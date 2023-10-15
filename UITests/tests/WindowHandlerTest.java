package UITests.tests;

import org.testng.annotations.Test;

import UITests.pages.GuruPage;

import org.testng.annotations.BeforeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class WindowHandlerTest {
	public String baseUrl = "https://demo.guru99.com/test/guru99home/";
	public WebDriver driver = new ChromeDriver();
	
	@Test
	public void WindowTest() {
		GuruPage guruPage = new GuruPage(driver);
		guruPage.clickOnPic();
        Object[] allWindows = driver.getWindowHandles().toArray();
        driver.switchTo().window(allWindows[0].toString());
        Assert.assertEquals(driver.getTitle(), "Demo Guru99 Page");
        driver.switchTo().window(allWindows[1].toString());
        Assert.assertEquals(driver.getTitle(), "Selenium Live Project: FREE Real Time Project for Practice");
        driver.close();
        driver.switchTo().window(allWindows[0].toString());
        
        guruPage.selectMenu("Testing");

        guruPage.dismissAdd();
        
        Boolean present = guruPage.getSubmitState();
        Assert.assertEquals(present, Boolean.TRUE);
        
        
	}
	
	@BeforeTest
	public void beforeTest() {	  
		driver.manage().window().maximize();
		driver.get(baseUrl);	  
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
