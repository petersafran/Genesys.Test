package UITests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	By userName = By.id("user-name");
	By passWord = By.id("password");
	By loginBtn = By.id("login-button");
		
	public Boolean isLoaded() {		
		return null;
	}
	
	public void doLogon(String uName, String pwd) {
		driver.findElement(userName).sendKeys(uName);
		driver.findElement(passWord).sendKeys(pwd);
		driver.findElement(loginBtn).click();
	}
	
	public String getErrorMsg() {
		WebElement error = driver.findElement(By.cssSelector("h3[data-test=\"error\"]"));
		String result = error.getText();
		//String resut2 = error.getAttribute("innerHTML");
		return result;
	}
	
}
