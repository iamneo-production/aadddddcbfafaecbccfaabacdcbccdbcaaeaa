package ai.iamneo.testing.Testing_Selenium_TestNg;

import org.testng.annotations.Test;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AppTest {

	ChromeOptions chromeOptions = new ChromeOptions();
	WebDriver driver = null;

	@BeforeTest
	public void beforeTest() throws Exception {
	//	System.setProperty("webdriver.chrome.driver", "/home/coder/project/workspace/Testing-with-Selenium-TestNg/chromedriver");
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
	}

	public void testcase_1() throws InterruptedException {
	 driver.get("http://jqueryui.com/droppable/");
	  String title = "Droppable | jQuery UI";
	  Assert.assertEquals(driver.getTitle(), title);
		}


	@Test
	public void TestCase_2() throws InterruptedException {
		String title= "Droppable | jQuery UI";
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.titleContains(title));
		driver.switchTo().frame(0);
		 WebElement source = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#draggable"))));
		WebElement target = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#droppable"))));

		 Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).build().perform();
		String getText = target.getText();
		 Assert.assertEquals(getText, "Dropped!");
    }
	
	@Test
	public void testcase_3() throws InterruptedException{

		driver.get("http://jqueryui.com/droppable/"); 
 		String title = "Droppable | jQuery UI";
		Assert.assertEquals(driver.getTitle(), title);

		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.titleContains(title));
		driver.switchTo().frame(0);
		WebElement target = driver.findElement(By.cssSelector("#droppable"));
		String color = target.getCssValue("background-color");
		Assert.assertEquals(color, "rgba(233, 233, 233, 1)");

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
