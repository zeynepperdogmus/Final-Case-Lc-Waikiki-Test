import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverHelper {
    protected WebDriver webDriver;

    public WebDriverHelper(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void click(By byElement, int timeOutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeOutInSeconds));
            wait.until(ExpectedConditions.elementToBeClickable(byElement)).click();
        } catch (Exception e) {
            System.err.println("Click işlemi sırasında hata oluştu: " + e.getMessage());
        }
    }

    public void sendKeys(By byElement, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(byElement));
            element.clear(); // Var olan metni temizleme (opsiyonel)
            element.sendKeys(text);
        } catch (Exception e) {
            System.err.println("SendKeys işlemi sırasında hata oluştu: " + e.getMessage());
        }
    }

    public String getText(By byElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(byElement)).getText();
    }

    public void moveToElement(By byElement) {
        WebElement element = webDriver.findElement(byElement);
        String strJavaScript = "var element = arguments[0]; var mouseEventObj = document.createEvent('MouseEvents'); mouseEventObj.initEvent( 'mouseover', true, true ); element.dispatchEvent(mouseEventObj);";
        ((JavascriptExecutor) webDriver).executeScript(strJavaScript, element);
    }

    public void scrollToPage(String pixel) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0," + pixel + ")");
    }

    public void scrollToPageEnd() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollByVisibleElement(By byElement) {
        WebElement element = webDriver.findElement(byElement);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
