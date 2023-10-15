package UITests.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends BasePage {

	public InventoryPage(WebDriver driver) {
		super(driver);
	}

	By buttonMenu = By.id("menu_button_container");
	By shoppingCart = By.id("shopping_cart_container");
	By inventoryGroup = By.id("inventory_container");
		
	public Boolean waitToLoaded() {		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryGroup));
		return driver.findElement(buttonMenu).isDisplayed();
	}
	WebElement itemName = null;
	
	public void addToCart(String label) {
		List<WebElement> items = driver.findElements(By.className("inventory_item"));
		for (WebElement webElement : items) {
			itemName = webElement.findElement(By.className("inventory_item_name"));
			if (itemName.getText().equals(label)) {
				webElement.findElement(By.cssSelector(".btn_inventory")).click();
				return;
			}
		}
	}
	
	public int getCartNumber() {
		
		WebElement cartCounter = driver.findElement(By.className("shopping_cart_badge"));
		return Integer.parseInt(cartCounter.getText());
		
	}
	
	public void startCheckout() {
		driver.findElement(shoppingCart).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
		driver.findElement(By.id("checkout")).click();
	}
	
	public void fillCheckout(String fName, String lName, int postCode ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
		
		driver.findElement(By.id("first-name")).sendKeys(fName);
		driver.findElement(By.id("last-name")).sendKeys(fName);
		driver.findElement(By.id("postal-code")).sendKeys(fName);
		
		driver.findElement(By.id("continue")).click();
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
		
		driver.findElement(By.id("finish")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout_complete_container")));
	}
	
	public String getCheckoutResult() {
		WebElement result = driver.findElement(By.className("complete-header"));
		return result.getText();
	}
	
	public String getFooterText() {
		WebElement footer = driver.findElement(By.className("footer_copy"));
		this.scrollToElement(footer);
		return footer.getText();
	}
	
	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
