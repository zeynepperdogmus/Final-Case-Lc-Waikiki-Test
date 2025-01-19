package com.LCwaikiki.testcase;

import com.LCwaikiki.testcase.pages.HomePage;
import com.LCwaikiki.testcase.pages.LoginPage;
import com.LCwaikiki.testcase.pages.anaProcess;
import com.LCwaikiki.testcase.Users.User;
import org.testng.annotations.Test;

public class LCwaikikiTestCase extends BaseTest {

    @Test
    public void LCwaikikiTest() throws InterruptedException {
        String title = "Trendler ve Yenilikçi Online Alışveriş Deneyimi Burada!";  // Sayfa başlığı
        String email = "zeynep.erdogmus@hotmail.com";  // Kullanıcı e-posta adresi
        String password = "zeynep1734";  // Kullanıcı şifresi

        // Anasayfa sayfasına git
        HomePage homePage = new HomePage(webDriver);
        String webDriverTitle = homePage.getHomePageTitle();  // Sayfa başlığı alınır

        Log4j.info("Title: " + webDriverTitle);  // Başlık bilgisi loglanır
        Thread.sleep(1000);  // Bir saniye beklenir

        // Login sayfasına git
        Log4j.info("Go to Login Page");  // Login sayfasına geçildiği loglanır
        LoginPage loginPage = homePage.getLoginPage();  // LoginPage nesnesi oluşturuluyor
        Log4j.info("email: " + email + ", password: " + password);  // Kullanıcı bilgileri loglanır
        User user = new User(email, password);  // Kullanıcı bilgileri bir User nesnesine atanır
        loginPage.login(user);  // Login işlemi yapılır
        Log4j.info("Anasayfaya Dön");  // Anasayfaya dönüldüğü loglanır

        // Üyelik girişinde site problemi olduğu için tekrar anasayfaya döndük
        Log4j.info("Üyelik girişinde site problemi olduğu için tekrar anasayfaya döndük");
        webDriver.get("https://www.lcwaikiki.com/tr-TR/TR");  // Site tekrar açılır
        homePage.waitForLoad();  // Sayfa yüklenene kadar beklenir
        Log4j.info("Site yüklendi");  // Sayfanın yüklendiği loglanır

        // Kategori seçme işlemini gerçekleştirme
        anaProcess selectCategory = new anaProcess(webDriver);  // anaProcess nesnesi oluşturuluyor
        selectCategory.cocukKategoriSec();  // Çocuk kategorisi seçilir
        Log4j.info("Kategori seçme işlemi tamamlandı");  // Kategori seçme işlemi tamamlandığı loglanır
    }
}
