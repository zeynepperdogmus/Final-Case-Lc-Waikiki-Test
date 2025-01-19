package com.LCwaikiki.testcase.functions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

// Constructor: WebDriver, WebDriverWait ve JavascriptExecutor nesneleri oluşturuluyor
public class CustomFunctions {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public CustomFunctions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,  Duration.ofMillis(10000));
        this.js = (JavascriptExecutor) driver;
    }

    // Butona hover yapma
    public void hoverOnButton(Actions actions, String xpath) throws InterruptedException {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));  // Buton görünene kadar beklenir
        actions.moveToElement(button).perform(); // Fareyi butonun üzerine getirir
        Thread.sleep(2000); // 2 saniye bekleme
    }

    // Butona tıklama
    public void clickButton(Actions actions, String xpath) throws InterruptedException {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))); // Buton tıklanabilir olana kadar beklenir
        actions.moveToElement(button).click().perform(); // Butona tıklama işlemi yapılır
        Thread.sleep(2000); // 2 saniye bekleme
    }

    // Yaş butonlarına tıklama
    public void clickAgeButton(String xpath) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))); // Yaş butonu tıklanabilir olana kadar beklenir
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath))); // JavaScript kullanarak butona tıklarız
        Thread.sleep(2000); // 2 saniye bekleme
    }

    // Ürün seçimi
    public void selectProduct(String xpath) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))); // Ürün tıklanabilir olana kadar beklenir
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
        Thread.sleep(2000); // 2 saniye bekleme
    }

    // Sepete ekle
    public void clickAddToCart(String xpath) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))); // Sepete ekle butonu tıklanabilir olana kadar beklenir
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
        Thread.sleep(2000); // 2 saniye bekleme
    }

    // Sepete git
    public void navigateToCart(String xpath) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))); // Sepet butonu tıklanabilir olana kadar beklenir
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
        Thread.sleep(2000); // 2 saniye bekleme
    }

    // Favoriye ekle
    public void addToFavorites(String xpath) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))); // Favoriye ekle butonu tıklanabilir olana kadar beklenir
        driver.findElement(By.xpath(xpath)).click();
        Thread.sleep(2000); // 2 saniye bekleme
    }

    // Favori sayfasına git
    public void navigateToFavorites(String xpath) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))); // Favori sayfası butonu tıklanabilir olana kadar beklenir
        driver.findElement(By.xpath(xpath)).click();
        Thread.sleep(2000); // 2 saniye bekleme
    }

    // Ana sayfaya dön
    public void returnToHomePage(String xpath) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))); // Ana sayfa butonu tıklanabilir olana kadar beklenir
        driver.findElement(By.xpath(xpath)).click(); // Ana sayfaya dönmek için tıklanır
        Thread.sleep(2000); // 2 saniye bekleme
    }

    // Favori sayfasına git
    public void goToFavoritesPage(String xpath) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))); // Favori sayfası butonu tıklanabilir olana kadar beklenir
        driver.findElement(By.xpath(xpath)).click(); // Favori sayfasına gitmek için tıklanır
        Thread.sleep(2000); // 2 saniye bekleme
    }

    public static void clickFirstAvailableButton(WebDriverWait wait, JavascriptExecutor js, String xpathPattern) throws InterruptedException {
        // Butonları arama
        List<WebElement> buttons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpathPattern)));  // XPath ile butonları bulma

        // Eğer butonlar varsa
        if (!buttons.isEmpty()) {
            WebElement button = buttons.get(0);  // İlk butona tıklanır
            js.executeScript("arguments[0].click();", button);  // JavaScript ile tıklama
            System.out.println("İlk uygun butona tıklanmış oldu.");
        } else {
            System.out.println("Buton bulunamadı!"); // Buton yoksa mesaj yazdırılır
        }
    }

}
