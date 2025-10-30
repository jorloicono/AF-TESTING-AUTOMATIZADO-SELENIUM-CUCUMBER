package com.gfg;

/**
 * Unit test for simple App.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class AppTest {

    @Test
    public void testLoginInChrome() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.quit();
    }
    @Test
    public void testLoginInFirefox() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver2 = new FirefoxDriver();
        driver2.get("https://www.saucedemo.com/");
        driver2.findElement(By.id("user-name")).sendKeys("standard_user");
        driver2.findElement(By.id("password")).sendKeys("secret_sauce");
        driver2.findElement(By.id("login-button")).click();
        driver2.quit();
    }
}