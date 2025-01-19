package com.LCwaikiki.testcase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends kategoriSecimi {

    // Ana sayfa ve çerez pop-up'ı için XPath değerleri
    By mainBy = By.xpath("/html/body");
    By closeCookiesButtonBy = By.xpath("/html/body/div[5]/div/div[2]/div/button");


    public HomePage(WebDriver webDriver) {
        super(webDriver);  // üst sınıf kategoriSecimi'nin constructor'ı çağrılır
    }

    // Ana sayfa başlığını döndüren metod
    public String getHomePageTitle() {
        return webDriver.getTitle();  // Web sayfasının başlığını alır
    }

    // Sayfanın tam olarak yüklenmesini bekleyen metod
    public void waitForLoad() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10)); // WebDriverWait nesnesi oluşturulur ve 10 saniye beklenir
        // Ana sayfanın görünür olmasını bekler
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainBy));
    }

    // Çerez pop-up'ını kapatma işlemi
    public void closeCookiesPopUp() {
        // Çerez pop-up'ını kapatma butonuna 10 saniye içinde tıklanır
        click(closeCookiesButtonBy, 10);
    }
}
