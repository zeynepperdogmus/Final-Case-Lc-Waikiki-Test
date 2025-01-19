
# LC Waikiki Test Otomasyon Projesi

## Proje Hakkında
Bu proje, LC Waikiki için bir test otomasyon senaryosu geliştirmeyi amaçlamaktadır. Proje kapsamında:
- **POM (Page Object Model)** tasarım deseni kullanılmıştır.
- **Allure Report** ile raporlama sağlanmıştır.
- Test senaryoları, **Selenium**, **Java**, **TestNG**, **Log4j** ve **Maven** kullanılarak hazırlanmıştır.


## Gereksinimler
Projenin çalıştırılabilmesi için aşağıdaki gereksinimlerin karşılanması gerekmektedir:
- **Java JDK 8+**
- **Maven**
- **Selenium WebDriver**
- **TestNG**
- **Allure** raporlama aracı

## Proje Kurulumu
1. Projeyi klonlayın:
   ```bash
   git clone https://github.com/zeynepperdogmus/Final-Case-Lc-Waikiki-Test.git
   cd lcw-test-automation
   ```  
2. Gerekli bağımlılıkları yüklemek için Maven kullanın:
   ```bash
   mvn clean install
   ```  
3. Testleri çalıştırmadan önce `username`, `password` gibi bilgileri doldurun.

## Testlerin Çalıştırılması
- Testleri çalıştırmak için aşağıdaki komutu kullanın:
  ```bash
  mvn test
  ```  
- Test sonuçlarını görüntülemek için Allure raporlarını oluşturun ve tarayıcıda açın:
  ```bash
  allure serve allure-results
  ```

## Senaryolar
- **Kullanıcı Girişi:**
    - Geçerli bir e-posta ve şifre ile giriş yapılır.

- **Kategoriler ve Filtreleme:**
    - Çocuk & Bebek > Kız Çocuk (6-14 Yaş) > Mont ve Kaban kategorisi seçilir.
    - "Beden" filtresi olarak `5-6`, `6` ve `6-7` seçilir.
    - "Renk" filtresi olarak `Bej` seçilir.

- **Ürün Ekleme:**
    - İlk sıradaki 4. ürün detay sayfasına gidilir.
    - Stokta bulunan bir beden seçilerek sepete eklenir.

- **Sıralama ve Favoriler:**
    - "En çok satanlar" seçilerek ürünler sıralanır.
    - Ürün favorilere eklenir.

- **Favorilerim Sayfası ve Doğrulama:**
    - Favorilere eklenen ürünün favorilerim sayfasında listelendiği kontrol edilir.

## Proje Yapısı
```plaintext
lcw-test-automation/
lc_waikiki_test_zeynep/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.LCwaikiki.testcase/
│   │   │   │   ├── functions/          # Özel fonksiyonlar
│   │   │   │   │   └── CustomFunctions
│   │   │   │   ├── pages/              # Sayfa nesneleri
│   │   │   │   │   ├── anaProcess
│   │   │   │   │   ├── HomePage
│   │   │   │   │   ├── kategoriSecimi
│   │   │   │   │   └── LoginPage
│   │   │   │   ├── Users/              # Kullanıcı ve yardımcı sınıflar
│   │   │   │   │   ├── User
│   │   │   │   │   ├── Log4j
│   │   │   │   │   └── WebDriverHelper
│   ├── test/
│   │   ├── java/
│   │   │   ├── com.LCwaikiki.testcase/
│   │   │   │   ├── BaseTest
│   │   │   │   └── LCwaikikiTestCase
├── pom.xml                             # Maven bağımlılıkları
└── README.md                           # Proje açıklamaları

```


## Lisans
Bu proje, **eğitim amaçlı** olarak hazırlanmıştır ve herhangi bir ticari kullanım için uygun değildir. Kodlar, yalnızca bireysel öğrenme ve değerlendirme amacıyla kullanılabilir.  
