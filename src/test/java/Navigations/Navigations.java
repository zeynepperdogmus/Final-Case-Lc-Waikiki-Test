package Navigations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Navigations {

    public WebDriver driver;

    final private String URL1 = "https://www.lcw.com/";
    final private String URL2 = "https://www.lcw.com/kadin-t-1";
    final private String URL3 = "https://www.lcw.com/erkek-t-2";

    @BeforeAll
    public void setup() {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
    }

    @Test
    public void getCurrentURL() {
        driver.get(URL1);
    }

    @Test
    public void navigateToURL() {
        setup();

        // URL2'ye navigate ettik
        driver.navigate().to(URL2);
    }

    @Test
    public void backRefreshForwardToURL() {
        setup();

        // URL1'e yönlendirildi
        driver.navigate().to(URL1);
        Assertions.assertEquals("LCW.com: Trendler ve Yenilikçi Online Alışveriş Deneyimi Burada! | LCW", driver.getTitle());

        // URL2'ye yönlendirildi
        driver.navigate().to(URL2);
        Assertions.assertEquals("Kadın Ürünleri Fiyatları ve Modelleri | LCW", driver.getTitle());

        // URL3'e yönlendirildi
        driver.navigate().to(URL3);
        Assertions.assertEquals("Erkek Ürünleri Fiyatları ve Modelleri | LCW", driver.getTitle());

        // Back işlemi (URL2'ye döner)
        driver.navigate().back();
        Assertions.assertEquals("Kadın Ürünleri Fiyatları ve Modelleri | LCW", driver.getTitle());

        // Forward işlemi (URL3'e geri gider)
        driver.navigate().forward();
        Assertions.assertEquals("Erkek Ürünleri Fiyatları ve Modelleri | LCW", driver.getTitle());

        // Sayfa yenileme (URL3 yenilenir)
        driver.navigate().refresh();
        Assertions.assertEquals("Erkek Ürünleri Fiyatları ve Modelleri | LCW", driver.getTitle());
    }

    @AfterTest
    public void quit() {
        driver.close();
    }
}
