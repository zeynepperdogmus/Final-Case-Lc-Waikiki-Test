package com.LCwaikiki.testcase.pages;

import com.LCwaikiki.testcase.Users.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends kategoriSecimi {

    // Kullanıcı adı, şifre ve giriş butonları için XPath değerleri
    By userNameFieldBy = By.xpath("//*[@id=\"login\"]/div/div[2]/div/div/div/form/div/div/input");
    By passwordFieldBy = By.xpath("//*[@id=\"login\"]/div/div[2]/div/div/div/form/div[2]/div/input");
    By loginButtonBy = By.xpath("//*[@id=\"login\"]/div/div[2]/div/div/div/form/div/button");
    By logintoAccountButtonBy = By.xpath("//*[@id=\"login\"]/div/div[2]/div/div/div/form/button");


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    // Kullanıcıyı giriş yaptıktan sonra anasayfaya yönlendiren metod
    public HomePage login(User user) throws InterruptedException {
        // Her işlemden önce body'ye tıklanıyor pop-up'ları engellemek için
        webDriver.findElement(By.tagName("body")).click();

        // Kullanıcı adı alanına e-posta adresi giriliyor
        sendKeys(userNameFieldBy, user.getEmail());
        webDriver.findElement(By.tagName("body")).click();
        click(loginButtonBy, 10);  // Giriş butonuna tıklanıyor, 10 saniye bekleniyor

        // Şifre alanına şifre giriliyor ve biraz bekleniyor
        Thread.sleep(2000);  // 2 saniye duraklama
        webDriver.findElement(By.tagName("body")).click();
        sendKeys(passwordFieldBy, user.getPassword());  // Şifre giriliyor
        webDriver.findElement(By.tagName("body")).click();
        click(logintoAccountButtonBy, 10);  // Hesaba giriş butonuna tıklanıyor, 10 saniye bekleniyor

        // Giriş başarılı ise HomePage'e yönlendirilir
        HomePage homePage = new HomePage(webDriver);
        return homePage;  // HomePage döndürülüyor
    }
}
