package com.LCwaikiki.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver webDriver;  // WebDriver nesnesi tanımlanıyor

    @BeforeMethod
    public void setup(){
        // ChromeDriver için yolu belirtiyoruz
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ZEYNEP\\OneDrive\\Masaüstü\\chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu");

        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // Otomasyon uyarısının engellenmesi

        String baseUrl = "https://www.lcwaikiki.com/tr-TR/TR"; // Test edilecek URL belirleniyor

        // WebDriver ile Chrome tarayıcısını başlatıyoruz
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Sayfa elemanlarının yüklenmesi için 10 saniye bekleme süresi
        Log4j.info("Test is starting..."); // Log4j ile testin başladığı bilgisi yazdırılıyor
        webDriver.get(baseUrl); // Belirtilen URL'ye gidiliyor
        webDriver.manage().window().maximize(); // Tarayıcı penceresi tam ekran yapılır
        Log4j.info("Opening Page " + baseUrl); // Log4j ile açılan sayfa bilgisi yazdırılıyor
    }

    @AfterMethod
    public void tearDown() {
        // Testin sonlandırılması için browser kapatılıyor
        Log4j.info("Test is ending."); // Log4j ile testin sonlandığı bilgisi yazdırılıyor
        if (webDriver != null) {
            webDriver.quit(); // WebDriver oturumu sonlandırılıyor ve tarayıcı kapatılıyor
        }
    }
}
