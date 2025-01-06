package Annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Annotations {

    // driver tanımlandı.
    public WebDriver driver;

    public String baseURL = "https://www.lcw.com/";

    @BeforeSuite
    public void setup() {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(ops);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize(); // Tarayıcı tam ekran yapıldı.
        System.out.println("Sistem Ayağa Kalktı");
    }

    @BeforeClass
    public void goToURL() {
        driver.get(baseURL);
        System.out.println("URL'e gidildi: " + baseURL);
    }

    @Test
    public void verifyTitle() {
        // Sayfanın başlığını doğruluyoruz.
        String title = driver.getTitle();
        Assert.assertEquals(title, "LCW.com: Trendler ve Yenilikçi Online Alışveriş Deneyimi Burada! | LCW");
        System.out.println("Sayfa başlığı doğrulandı: " + title);
    }

    @Test
    public void verifyCurrentURL() {
        // Geçerli URL'i doğruluyoruz.
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, baseURL);
        System.out.println("Geçerli URL doğrulandı: " + currentURL);
    }

    @AfterClass
    public void close() {
        driver.close();
        System.out.println("Sistem sonlandırıldı");
    }
}
