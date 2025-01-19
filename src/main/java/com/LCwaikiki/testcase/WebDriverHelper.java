package com.LCwaikiki.testcase;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverHelper {
    protected WebDriver webDriver;


    public WebDriverHelper(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // Bir öğeye tıklama işlemi
    public void click(By byElement, int timeOutInSeconds) {
        try {
            // Bekleme süresi belirlenir
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeOutInSeconds));
            // Öğenin tıklanabilir olmasını bekleyip tıklama işlemi yapılır
            wait.until(ExpectedConditions.elementToBeClickable(byElement)).click();
        } catch (Exception e) {
            // Hata oluşursa, hata mesajı loglanır
            System.err.println("Click işlemi sırasında hata oluştu: " + e.getMessage());
        }
    }

    // Bir öğeye metin gönderme işlemi
    public void sendKeys(By byElement, String text) {
        try {
            // Öğenin tıklanabilir olmasını bekleriz
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(byElement));
            // Var olan metin temizlenir (opsiyonel)
            element.clear();
            // Metin gönderilir
            element.sendKeys(text);
        } catch (Exception e) {
            // Hata oluşursa, hata mesajı loglanır
            System.err.println("SendKeys işlemi sırasında hata oluştu: " + e.getMessage());
        }
    }

    // Bir öğenin metnini alır
    public String getText(By byElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        // Öğenin görünür olmasını bekleyip metni döndürür
        return wait.until(ExpectedConditions.visibilityOfElementLocated(byElement)).getText();
    }

    // Öğeye fare ile tıklamadan önce üzerine gelme işlemi
    public void moveToElement(By byElement) {
        WebElement element = webDriver.findElement(byElement);
        String strJavaScript = "var element = arguments[0]; var mouseEventObj = document.createEvent('MouseEvents'); mouseEventObj.initEvent( 'mouseover', true, true ); element.dispatchEvent(mouseEventObj);";
        // JavaScript ile fare hareketi simüle edilir
        ((JavascriptExecutor) webDriver).executeScript(strJavaScript, element);
    }

    // Sayfayı belirtilen piksel kadar kaydırma
    public void scrollToPage(String pixel) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        // JavaScript ile sayfa kaydırılır
        js.executeScript("window.scrollBy(0," + pixel + ")");
    }

    // Sayfayı en alta kaydırma
    public void scrollToPageEnd() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        // JavaScript ile sayfa en alta kaydırılır
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    // Görünür öğeye kadar sayfayı kaydırma
    public void scrollByVisibleElement(By byElement) {
        WebElement element = webDriver.findElement(byElement);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        // JavaScript ile belirtilen öğeye kadar kaydırılır
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
