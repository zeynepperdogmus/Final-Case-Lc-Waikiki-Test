[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/Q0KbRC36)
# hafta5-odev
### LCW QA Bootcamp 5. hafta ödev reposu
* Bugün ne öğrendim? README.md dosyasında yazınız.
* https://www.lcw.com/ sitesine gidiniz.  back(), forward(),to() ve refresh() metodlarını kullanarak seçmiş olduğunuz sayfalara idiniz ve sayfa başlığını verfiy ediniz. 
* Browser’ın başlatılması ilk adım olacak şekilde @BeforeTest gibi gerekli annotation’ı ekleyin. Ardından, sayfada bulunan title’ı verfiy edin. @Test annotation kullanarak.
       Son olarak, browserı kapatarak testi sonlandırın. gerekli annotationları kullanarak.

Not: Diğer Annotationları ‘da ekleyerek yeni testler oluşturabilirsiniz.

Happy Coding! 😇



Bugün, Selenium WebDriver ve JUnit framework'ü ile otomasyon testlerinin temellerini öğrendik. İlk olarak, Selenium’un web tarayıcılarını nasıl kontrol edebileceğini inceledik. Tarayıcıyı başlatma, doğru URL'ye yönlendirme ve testlerin başında tarayıcıyı optimize etme gibi işlemleri öğrendik. WebDriver’ın tarayıcıyı bizim yerimize nasıl yönettiğini görmek gerçekten öğreticiydi. Ayrıca, tarayıcılar arası uyumluluk sorunlarını çözebilmek için doğru ayarları yapmamız gerektiğini fark ettik.

JUnit framework’ü ile ilgili olarak, testlerin düzenini sağlamak için kullanılan anotasyonları detaylı bir şekilde öğrendik. Testlerden önce yapılması gereken hazırlıkları @BeforeMethod ile, testlerden sonra yapılacak temizlik işlemlerini ise @AfterMethod ile düzenleyebileceğimizi gördük. Bu anotasyonlar, testlerin daha düzenli ve esnek olmasını sağlıyor. Ayrıca, @Test anotasyonu sayesinde test metotlarını işaretleyebildik ve sonuçları doğrulamak için assertEquals() gibi doğrulama metotlarını kullanmayı öğrendik. Bunun dışında, @BeforeClass ve @AfterClass anotasyonlarının, test sınıfındaki tüm testlerden önce ve sonra yapılması gereken işlemler için kullanıldığını öğrendik. Bu, kaynakları daha verimli yönetmemizi sağlıyor.

Web sayfalarındaki elementlerle etkileşim kurma konusunda da önemli bilgiler edindik. findElement ile tek bir elementi, findElements ile birden fazla elementi seçmeyi ve XPath ile dinamik elementleri nasıl bulacağımızı öğrendik. XPath’teki fonksiyonlar, element bulmayı oldukça kolaylaştırıyor.

Gezinti işlemleri de önemli bir konu oldu. Selenium’un navigate() komutları ile sayfalara gitme, geri dönme ve sayfayı yenileme işlemleri hakkında bilgi sahibi olduk.

Sonuç olarak, bugünkü ders otomasyon testi yazma sürecine dair güçlü bir temel sağladı. Öğrendiğimiz tekniklerle test yazma süreçlerini daha bilinçli ve sistematik bir şekilde ilerletebileceğimizi düşünüyorum.