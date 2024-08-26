import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class PruebaTest {
    private WebDriver chromeDriver;

    @Before
    public void abrirDriver(){
        // Webdriver de chrome para poder ingresar
        System.setProperty("webdriver.chrome.driver", "/Users/fmaylle/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setCapability("marionette", false);
        chromeDriver = new ChromeDriver(options);
        //tiempo de espera para que pueda buscar la aplicación
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void main() {
        //ingresamos a google
        chromeDriver.get("https://www.google.com");
        //ingresamos lo que deseamos buscar
        chromeDriver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Cantidad de paises en america");
        //Presionamos la tecla enter
        chromeDriver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(Keys.ENTER);
        //hacer click en el link seleccionado
        chromeDriver.findElement(By.xpath("//h3[contains(text(),'Mapa Político de América: Países y Capitales - Web')]")).click();
        //creamos un elemento web para poder hacer acciones mas avanzadas
        WebElement subtitulo = chromeDriver.findElement(By.id("parent-fieldname-title"));
        //verificamos lo seleccionado
        Assert.assertTrue(subtitulo.getText().contains("Mapa Político de América: Países y Capitales"));

    }
    @After
    public void cerrarDriver(){
        //Cerrar la aplicación o caso de prueba o driver
        chromeDriver.quit();
    //NOTAS:
        //-> Utilizar chropath para analizar elementos web
        //-> encontrar elementos con (En order de prioridad) ->id,Xpath,css
        //->Abrir y cerrar el drive en cada test
        //->interactuar con elementos desde el driver
    }
    }
