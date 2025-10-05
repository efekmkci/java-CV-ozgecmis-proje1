# Java ile PDF CV Oluşturucu

Bu proje, Java ve Apache PDFBox kütüphanesi kullanılarak geliştirilmiş basit bir masaüstü uygulamasıdır. Projenin amacı, kod içerisinde önceden tanımlanmış kişisel bilgileri ve iş deneyimlerini alarak standart bir CV formatında bir PDF dosyası oluşturmaktır.

Bu proje, bir okul ödevi için geliştirilmiştir.

## 🚀 Projenin Özellikleri

-   **Dinamik PDF Oluşturma:** Kişi, özet ve iş deneyimi gibi bilgileri alarak bir PDF dosyası meydana getirir.
-   **Fotoğraf Ekleme:** CV'nin sağ üst köşesine bir profil fotoğrafı ekler.
-   **Türkçe Karakter Desteği:** Türkçe karakterlerin (`ç`, `ğ`, `ı`, `ö`, `ş`, `ü`) PDF'te doğru görüntülenmesi için özel fontlar kullanır.
-   **Basit ve Modüler Kod Yapısı:** Her bir veri modeli (`Person`, `JobExperience`) ayrı sınıflarda tutularak kodun okunabilirliği artırılmıştır.

## 🛠️ Kullanılan Teknolojiler

-   **Java:** Ana programlama dili.
-   **Apache PDFBox:** PDF dosyaları oluşturmak ve düzenlemek için kullanılan açık kaynaklı kütüphane.
-   **Maven:** Proje bağımlılıklarını (dependency) yönetmek için kullanılmıştır.

## ⚙️ Nasıl Çalıştırılır?

Projeyi kendi bilgisayarınızda çalıştırmak için aşağıdaki adımları izleyebilirsiniz.

### Gereksinimler

-   Java Development Kit (JDK) 11 veya üstü.
-   Apache Maven.
-   Bir IDE (IntelliJ IDEA, Eclipse, vb.)

### Kurulum Adımları

1.  **Projeyi Klonlayın:**
    ```bash
    git clone [https://github.com/EFE-EKMEKCİ/java-CV-ozgecmis-proje1.git](https://github.com/EFE-EKMEKCİ/java-CV-ozgecmis-proje1.git)```

2.  **Gerekli Dosyaları Ekleyin:**
    Projenin doğru çalışabilmesi için `src/main/resources` klasörünün içinde aşağıdaki dosyaların bulunması gerekmektedir:
    -   `profile-photo.jpg` (Kendi fotoğrafınız, 100x120 piksel boyutlarında olabilir)
    -   `DejaVuSans.ttf` (Normal font)
    -   `DejaVuSans-Bold.ttf` (Kalın font)
    -   `DejaVuSans-Oblique.ttf` (İtalik/Eğik font)

    *Not: Bu fontları internetten "DejaVu Fonts" olarak aratıp kolayca indirebilirsiniz.*

3.  **Projeyi Çalıştırın:**
    -   **IDE üzerinden:** Projeyi IntelliJ IDEA veya Eclipse gibi bir IDE'de açın. `Main.java` dosyasına sağ tıklayıp "Run" seçeneğini seçin.
    -   **Terminal üzerinden:** Projenin ana dizinindeyken aşağıdaki komutu çalıştırın:
    ```bash
    mvn clean install exec:java -Dexec.mainClass="org.example.Main"
    ```

### 📄 Çıktı

Program başarıyla çalıştığında, projenin ana dizininde **`ozgecmis.CV.pdf`** adında bir PDF dosyası oluşturulacaktır.
