package com.LCwaikiki.testcase.pages;

import com.LCwaikiki.testcase.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class kategoriSecimi extends WebDriverHelper {
    // Giriş veya kayıt ol butonu için XPath
    By loginOrRegisterButtonBy = By.xpath("//*[@id=\"user_1_\"]");
    // Arama kutusu için XPath
    By searchBoxBy = By.xpath("//*[@id=\"search\"]");

    public kategoriSecimi(WebDriver webDriver) {
        super(webDriver);
    }

    // Kullanıcıyı giriş sayfasına yönlendiren metod
    public LoginPage getLoginPage() throws InterruptedException {
        // Login veya kayıt butonunun tıklanabilir olmasını bekleme
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10)); // 10 saniye bekleme
        WebElement loginOrRegisterButton = wait.until(ExpectedConditions.elementToBeClickable(loginOrRegisterButtonBy));
        Thread.sleep(500); // Butona tıklamadan önce 0.5 saniye bekleme

        // Login veya kayıt butonuna tıklama
        loginOrRegisterButton.click();

        // LoginPage sayfasına yönlendirme
        return new LoginPage(webDriver);  // LoginPage sayfasını döndürüyoruz
    }
}
