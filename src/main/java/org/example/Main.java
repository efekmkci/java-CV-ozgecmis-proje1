

package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. KİŞİSEL BİLGİLERİ OLUŞTUR (Hayali Bilgiler)
        Person person = new Person(
                "Efe EKMEKCİ",
                "efeekmekci@email.com",
                "+90 555 123 45 67",
                "Teknoloji Cd. Java Sk. No:42, Bursa",
                "Yazılım geliştirme alanında 5+ yıl deneyime sahip, özellikle Java ve Spring Boot teknolojilerinde uzmanlaşmış bir profesyonel. Ölçeklenebilir ve sürdürülebilir uygulamalar geliştirmeye odaklanmıştır."
        );

        // 2. İŞ DENEYİMLERİNİ OLUŞTUR (Hayali 3 Deneyim)
        List<JobExperience> experiences = new ArrayList<>();

        JobExperience job1 = new JobExperience(
                "Kıdemli Java Geliştirici",
                "Tekno A.Ş.",
                "Ocak 2022 - Günümüz",
                "Spring Boot ve Mikroservis mimarisi kullanarak büyük ölçekli e-ticaret platformunun arka uç sistemlerinin geliştirilmesi. Kod kalitesini artırmak için birim ve entegrasyon testleri yazılması."
        );

        JobExperience job2 = new JobExperience(
                "Java Yazılım Uzmanı",
                "Çözüm Bilişim",
                "Haziran 2019 - Aralık 2021",
                "Finans sektörü için müşteri ilişkileri yönetimi (CRM) yazılımının geliştirme ekibinde yer alındı. Mevcut projenin performans iyileştirmeleri ve yeni modüllerin eklenmesinden sorumlu olundu."
        );

        JobExperience job3 = new JobExperience(
                "Yazılım Geliştirme Stajyeri",
                "Kod Fabrikası",
                "Temmuz 2018 - Eylül 2018",
                "Java ile web uygulamaları geliştirme temelleri üzerine çalışıldı. Var olan bir projedeki küçük hataların (bug) giderilmesine ve dokümantasyonun hazırlanmasına yardımcı olundu."
        );

        experiences.add(job1);
        experiences.add(job2);
        experiences.add(job3);

        // 3. CV OLUŞTURUCUYU ÇAĞIR
        CvGenerator cvGenerator = new CvGenerator();
        try {
            // Oluşturulacak PDF'in adı ve konumu
            cvGenerator.generate(person, experiences, "ozgecmis.CV.pdf");
        } catch (IOException e) {
            System.err.println("CV oluşturulurken bir hata oluştu: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
