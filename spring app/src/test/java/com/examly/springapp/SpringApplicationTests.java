package com.examly.springapp;


import org.testng.annotations.Test;
import java.net.URL;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;import org.testng.annotations.Test;


public class SpringApplicationTests {

    ChromeOptions chromeOptions = new ChromeOptions();
    WebDriver driver = null;
            
        @BeforeTest
        public void beforeTest() throws Exception {
            
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
        }
        
    
        @Test
        public void testcase_1() throws InterruptedException {
            
            driver.get("http://jqueryui.com/droppable/");
            String title = "Droppable | jQuery UI";
            Assert.assertEquals(driver.getTitle(), title);
    }
    
           @Test
           public void testcase_2() throws InterruptedException{
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