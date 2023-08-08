package Testngdemo;
import org.testng.annotations.Test;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class App {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        
        // Initialize Chrome browser
        WebDriver driver = new ChromeDriver();
        
        // Navigate to the webpage
        driver.get("http://jqueryui.com/droppable/");
        
        // Switch to the iframe containing the drag and drop elements
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        
        // Locate the source and target elements
        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droppable"));
        
        // Initialize Actions class
        Actions actions = new Actions(driver);
        
        // Perform drag and drop operation
        actions.dragAndDrop(sourceElement, targetElement).perform();
        
        // Verify color property of CSS for the target element
        String actualColor = targetElement.getCssValue("background-color");
        String expectedColor = "rgba(70, 130, 180, 1)"; // Adjust the expected color value as needed
        Assert.assertEquals(actualColor, expectedColor, "Color property verification failed.");
        
        // Verify text change after drag and drop
        String actualText = targetElement.getText();
        String expectedText = "Dropped!";
        Assert.assertEquals(actualText, expectedText, "Text verification failed.");
        
        // Switch back to default content
        driver.switchTo().defaultContent();
        
        // Close the browser
        driver.quit();
    }
}
    
}
