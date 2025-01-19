package com.LCwaikiki.testcase.pages;

import com.LCwaikiki.testcase.functions.CustomFunctions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class anaProcess {

    WebDriver webDriver;
    CustomFunctions customFunctions;

    // XPath değerleri
    String firstButtonXpath = "/html/body/div[3]/div/div[1]/header/div[3]/nav/ul/li[4]/a"; // İlk öğe
    String secondButtonXpath = "/html/body/div[3]/div/div[1]/header/div[3]/nav/ul/li[4]/div/nav/ul/button[4]"; // İkinci öğe
    String thirdButtonXpath = "/html/body/div[3]/div/div[1]/header/div[3]/nav/ul/li[4]/div/nav/section/div[1]/div[2]/ul/li[5]/a"; // Üçüncü öğe

    String siralamaButtonXpath = "/html/body/div[3]/div/div[2]/div[1]/div[5]/div[2]/button"; // Sıralama butonu
    String cokSatanlarButtonXpath = "//*[@id=\"icon-top-selling\"]"; // Çok satanlar butonu


    public anaProcess(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.customFunctions = new CustomFunctions(webDriver);
    }

    // Çocuk kategorisini seçme işlemleri
    public void cocukKategoriSec() {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20)); //20 saniye bekleme
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            Actions actions = new Actions(webDriver);  // Actions ile fare hareketleri yapılır

            // 1. İlk butona hover yapılır
            customFunctions.hoverOnButton(actions, firstButtonXpath);
            System.out.println("İlk butona hover yapıldı.");

            // 2. İkinci butona tıklanır
            customFunctions.clickButton(actions, secondButtonXpath);
            System.out.println("İkinci butona tıklanmış oldu.");

            // 3. Üçüncü butona tıklanır
            customFunctions.clickButton(actions, thirdButtonXpath);
            System.out.println("Üçüncü butona tıklanmış oldu.");

            // 5-6 yaş butonlarına tıklama işlemi yapılır
            customFunctions.clickAgeButton("//*[@id=\"root\"]/div/div[2]/div[1]/div[6]/div/div[1]/div/div[5]/div/div[2]/div[3]/div[2]/span[1]");
            customFunctions.clickAgeButton("//*[@id=\"root\"]/div/div[2]/div[1]/div[6]/div/div[1]/div/div[5]/div/div[2]/div[3]/div[1]/div/span");
            customFunctions.clickAgeButton("//*[@id=\"root\"]/div/div[2]/div[1]/div[6]/div/div[1]/div/div[5]/div/div[2]/div[3]/div[2]/div/span");
            customFunctions.clickAgeButton("//*[@id=\"root\"]/div/div[2]/div[1]/div[6]/div/div[1]/div/div[5]/div/div[2]/div[3]/div[3]/div/span");

            // 4. Çok satanlar butonuna tıklanır
            customFunctions.clickAgeButton("//*[@id=\"root\"]/div/div[2]/div[1]/div[4]/div[2]/div/a[4]");

            // 5. Ürün seçimi yapılır
            customFunctions.selectProduct("//*[@id=\"root\"]/div/div[2]/div[1]/div[6]/div/div[2]/div[4]/a");

            // 6. Kıyafet bedeni seçimi yapılır, ilk bulunan bedene tıklanır
            CustomFunctions.clickFirstAvailableButton(wait, js, "//button[contains(@class, 'option-box') and contains(@class, 'option-size-box') and contains(@class, 'option-size-box__stripped')]");

            // 7. Sepete ekle butonuna tıklanır
            customFunctions.clickAddToCart("//*[@id=\"product-detail-add-to-card-operation\"]/div/div[2]/button");

            // 8. Sepete git butonuna tıklanır
            customFunctions.navigateToCart("//*[@id=\"header__container\"]/header/div[1]/div[3]/div/div[2]/a");

            // 9. Ürünü favorilere ekler
            customFunctions.addToFavorites("//*[contains(@class, 'fa-heart-o')]");

            // 10. Favori sayfasına gider
            customFunctions.navigateToFavorites("//*[@id=\"header__container\"]/header/div[1]/div[3]/div/div[1]/a");

        } catch (Exception e) {
            // Hata oluşursa hata mesajı yazdırılır
            System.out.println("Hata oluştu: " + e.getMessage());
        }
    }
}
