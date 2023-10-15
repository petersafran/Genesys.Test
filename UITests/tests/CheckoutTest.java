package UITests.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import UITests.pages.InventoryPage;
import UITests.pages.LoginPage;
import UITests.resources.Credential;
import UITests.resources.CredentialProvider;

public class CheckoutTest {
	public String baseUrl = "https://www.saucedemo.com/inventory.html";
	public WebDriver driver = new ChromeDriver();
	    
	  @Test
	  public void CheckoutFlowTest() {	  
		  LoginPage loginPage = new LoginPage(driver);
		  CredentialProvider cp = new CredentialProvider();
		  Credential credToUse = null;
		  
		  try {
			credToUse = cp.getCredentials();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  
		  loginPage.doLogon(credToUse.username, credToUse.password);
		  		
		  InventoryPage invPage = new InventoryPage(driver);
		  invPage.waitToLoaded();
		  invPage.addToCart("Sauce Labs Backpack");
		  invPage.addToCart("Sauce Labs Fleece Jacket");
		  int count = invPage.getCartNumber();
		  Assert.assertEquals(count, 2);
		  invPage.startCheckout();
		  invPage.fillCheckout("asd","asd",11);
		  String result = invPage.getCheckoutResult();
		  Assert.assertEquals(result,"Thank you for your order!");
		  
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
