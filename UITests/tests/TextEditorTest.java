package UITests.tests;

import org.testng.annotations.Test;

import UITests.pages.EditorPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TextEditorTest {
	public String baseUrl = "https://onlinehtmleditor.dev/";
	public WebDriver driver = new ChromeDriver();
	final String textToAdd = "<p><strong>Automation </strong><u>Test </u>Example</p>";
	final String textExpected = "Automation Test Example";
	
	@Test
	public void EditorTest() {
		EditorPage editor = new EditorPage(driver);
		editor.waitToLoad();
		editor.addTextToEditor(textToAdd);
		String textSeen = editor.getEditorText();
		
		Assert.assertEquals(textSeen, textExpected);
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
