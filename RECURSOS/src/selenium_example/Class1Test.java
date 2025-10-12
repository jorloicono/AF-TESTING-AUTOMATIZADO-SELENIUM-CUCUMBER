package selenium_example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Class1Test {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        // Configurar el driver de Chrome (Asegúrate de tener el driver en la ruta correcta)
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        // Inicializar el navegador
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void testWikipediaTitle() {
        // Navegar a Wikipedia
        driver.get("https://www.wikipedia.org");

        // Esperar hasta que el título sea visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleContains("Wikipedia"));

        // Obtener el título de la página
        String titulo = driver.getTitle();

        // Verificar que el título es "Wikipedia"
        assertEquals("Wikipedia, la enciclopedia libre", titulo, "El título de la página no es el esperado.");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

