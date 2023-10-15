package UITests.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GuruPage extends BasePage {

	public GuruPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickOnPic() {
		WebElement element = driver.findElement(By.id("a077aa5e"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		driver.switchTo().frame(element);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src=\"Jmeter720.png\"]")));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.cssSelector("img[src=\"Jmeter720.png\"]")));
		//driver.findElement(By.cssSelector("img[src=\"Jmeter720.png\"]")).click();
		driver.switchTo().defaultContent();
	}
	
    public void selectMenu(String menu) {
    	
    	WebElement element = driver.findElement(By.id("interstitial"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
    	List<WebElement> mainMenus = driver.findElement(By.cssSelector("ul[class=\"gf-menu l1 \"]")).findElements(By.className("item"));
    	String menuLabel = null;
    	
    	for (WebElement webElement : mainMenus) {
    		menuLabel = webElement.getText();
    		if (menuLabel.trim().equals(menu)){
    			Actions actions = new Actions(driver);
    			actions.moveToElement(webElement);
    			actions.perform();
    			
    			//we could find the selenium word but it has a unique class
    			driver.findElement(By.className("item121")).findElement(By.className("item")).click();
    			return;
    		}
		}
    }
    
    public void dismissAdd() {
    	driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[aria-label=\"Advertisement\"]")));
    	driver.findElement(By.id("dismiss-button")).click();
    	driver.switchTo().defaultContent();
    }

    public Boolean getSubmitState() {
    	WebElement submitBtn = driver.findElement(By.name("submit")); 
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(submitBtn));
    			
		return submitBtn.isDisplayed();

    }
		
}