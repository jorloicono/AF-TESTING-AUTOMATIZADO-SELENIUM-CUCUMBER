package selenium_example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class Class10 {
    public static void main(String[] args){

        System.setProperty("web-driver.chrome.driver","./drivers/chromedriver.exe");

        // Creo la instancia del navegador

        WebDriver driver = new ChromeDriver();


        // Navegamos a la web

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        try{

            WebElement textInput = driver.findElement(By.id("my-text-id"));
            textInput.sendKeys("Texto de prueba");

            Thread.sleep(5000);

            WebElement passwordInput = driver.findElement(By.name("my-password"));
            passwordInput.sendKeys("MiPassword");
            Thread.sleep(5000);

            WebElement dropdown = driver.findElement(By.name("my-select"));
            Select select  = new Select(dropdown);
            select.selectByValue("2");
            Thread.sleep(5000);

            WebElement ddatalist = driver.findElement(By.name("my-datalist"));
            ddatalist.sendKeys("Seattle");
            Thread.sleep(5000);

            WebElement fileinput = driver.findElement(By.name("my-file"));
            fileinput.sendKeys("C:/Users/Jorge/Desktop/SELENIUM.pptx");
            Thread.sleep(5000);

            WebElement submitButton = driver.findElement(By.cssSelector("button[type = 'submit']"));
            submitButton.click();
            Thread.sleep(5000);

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
