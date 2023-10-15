package UITests.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditorPage extends BasePage {

	public EditorPage(WebDriver driver) {
		super(driver);
	}

	By editorArea = By.id("cke_ckeditor-4-demo");
		
	public Boolean isLoaded() {		
		return null;
	}
	
	public Boolean waitToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(editorArea));
		
		return driver.findElement(editorArea).isDisplayed();
	}
	
	public void addTextToEditor(String text){
		
		driver.findElement(By.id("ckeditor-4-output-button")).click();

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ckeditor-4-output")));
		driver.findElement(By.cssSelector("pre[class=\" CodeMirror-line \"]")).click();
		Actions actions = new Actions(driver);
		actions.sendKeys(text);
		actions.perform();
		
		driver.findElement(By.id("ckeditor-4-editor-button")).click();
		
	}
	
	
	
	public String getEditorText() {
		driver.switchTo().frame(0);
		String editorText = driver.findElement(By.cssSelector("body[role=\"textbox\"]")).getText();
		driver.switchTo().defaultContent();
		
		return editorText;
	}
	
}
