package com.ejemplo.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SelectorsAdvancedTest {

    WebDriver driver;

    @BeforeAll
    void setupDrivers() {
        // WebDriverManager se encarga de descargar y configurar los drivers para Chrome/Firefox/Edge.
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    // Cambia el navegador pasando "chrome", "firefox" o "edge"
    void startBrowser(String browser) {
        if ("firefox".equalsIgnoreCase(browser)) {
            FirefoxOptions opts = new FirefoxOptions();
            opts.setHeadless(false);
            driver = new FirefoxDriver(opts);
        } else if ("edge".equalsIgnoreCase(browser)) {
            EdgeOptions opts = new EdgeOptions();
            driver = new EdgeDriver(opts);
        } else {
            ChromeOptions opts = new ChromeOptions();
            driver = new ChromeDriver(opts);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @BeforeEach
    void openTestPage() {
        // Por defecto usamos Chrome; si quieres otro navegador, invoca startBrowser desde un test específico.
        startBrowser("chrome");

        // Ruta al HTML local - ajusta a tu ubicación si no usas resources
        Path html = Paths.get("src/test/resources/testpage.html");
        String url = html.toAbsolutePath().toUri().toString();
        driver.get(url);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    void cssSelectorsAdvanced_examples() {
        // 1) selector por atributo: button con data-action="save"
        WebElement saveBtn = driver.findElement(By.cssSelector("button[data-action='save']"));
        Assertions.assertNotNull(saveBtn);

        // 2) selector con "contains" en atributo (subcadena): botones cuyo data-action contiene 'save'
        List<WebElement> saveish = driver.findElements(By.cssSelector("button[data-action*='save']"));
        Assertions.assertTrue(saveish.size() >= 1);

        // 3) combinador hijo y nth-child
        WebElement secondChild = driver.findElement(By.cssSelector(".parent > .child:nth-child(2)"));
        Assertions.assertEquals("Segundo hijo", secondChild.getText());

        // 4) atributo que empieza por ^
        List<WebElement> dataIdUsers = driver.findElements(By.cssSelector("[data-id^='u-']"));
        Assertions.assertTrue(dataIdUsers.size() >= 2);
    }

    @Test
    void xpathSelectorsAdvanced_examples() {
        // 1) localizar por texto exacto
        WebElement itemPera = driver.findElement(By.xpath("//li[text()='Pera']"));
        Assertions.assertNotNull(itemPera);

        // 2) contains() en XPath — texto parcial
        WebElement melon = driver.findElement(By.xpath("//li[contains(text(),'Melón')]"));
        Assertions.assertNotNull(melon);

        // 3) localizar elemento por atributo numérico y luego navegar a su label: ejemplo data-price
        List<WebElement> specials = driver.findElements(By.xpath("//li[@class='item special' and number(@data-price) > 2]"));
        // aquí comprobamos que Melón (2.50) aparecerá
        Assertions.assertTrue(specials.size() >= 1);

        // 4) sibling and ancestor: botón que sigue a input con id 'name'
        WebElement saveFromNameDiv = driver.findElement(By.xpath("//input[@id='name']/following-sibling::button[contains(@class,'save')]"));
        Assertions.assertNotNull(saveFromNameDiv);

        // 5) normalize-space para evitar espacios extras
        WebElement firstChild = driver.findElement(By.xpath("//div[normalize-space(.)='Primer hijo']"));
        Assertions.assertNotNull(firstChild);
    }

    @Test
    void interactions_clicks_inputs_checkboxes_radios() {
        // Input: limpiar y escribir
        WebElement nameInput = driver.findElement(By.cssSelector("input#name"));
        nameInput.clear();
        nameInput.sendKeys("Luis");

        // Click en botón (ejemplo con JS alert) — usar try/catch si hay alert
        WebElement save = driver.findElement(By.cssSelector("button[title='guardar']"));
        save.click(); // en nuestra página no hace nada crítico

        // Checkbox: toggle
        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox'][name='agree']"));
        checkbox.click();
        Assertions.assertTrue(checkbox.isSelected());

        // Radios: seleccionar por value mediante XPath
        WebElement radioRojo = driver.findElement(By.xpath("//input[@type='radio' and @value='rojo']"));
        radioRojo.click();
        Assertions.assertTrue(radioRojo.isSelected());

        // Leer todos los botones que contienen 'save' en data-action
        List<WebElement> saves = driver.findElements(By.cssSelector("button[data-action*='save']"));
        for (WebElement b : saves) {
            System.out.println("Found save-like button: " + b.getAttribute("data-action"));
        }
    }

    // Ejemplo de test para ejecutar en Firefox (método independiente)
    @Test
    void runInFirefox_demo() {
        // cerramos browser actual y abrimos Firefox
        if (driver != null) driver.quit();
        startBrowser("firefox");

        Path html = Paths.get("src/test/resources/testpage.html");
        driver.get(html.toAbsolutePath().toUri().toString());

        // localizamos con CSS y comprobamos visibilidad
        WebElement pear = driver.findElement(By.cssSelector("li.item.special"));
        Assertions.assertTrue(pear.isDisplayed());
    }
}
