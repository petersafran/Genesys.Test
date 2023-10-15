package UITests.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import UITests.pages.InventoryPage;
import UITests.pages.LoginPage;

public class ErrorAndFooterTest {
 	public String baseUrl = "https://www.saucedemo.com/inventory.html";
	public WebDriver driver = new ChromeDriver();
	    
	  @Test
	  public void ErrorMessageTest() {	  
		  final String expectedError = "Epic sadface: Username is required";
		  
		  LoginPage loginPage = new LoginPage(driver);
		  loginPage.doLogon("", "");

		  String error = loginPage.getErrorMsg();
		  Assert.assertEquals(error, expectedError);
		  
		  loginPage.doLogon("standard_user", "secret_sauce");
		  
		  InventoryPage invPage = new InventoryPage(driver);
		  
		  WebElement footer = driver.findElement(By.className("footer_copy"));
		  
		  String footerText = invPage.getFooterText();
			      
		  footerText.contains("2023");
		  footerText.contains("All rights reserved");
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
