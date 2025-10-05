// Person.java dosyasının içine yapıştırılacak kod

package org.example; // Bu satır sendeki paket adıyla aynı olmalı

public class Person {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private String summary; // Kişisel özet

    // Constructor (Yapıcı Metot) - Bu nesne oluşturulurken bilgileri alır.
    public Person(String fullName, String email, String phoneNumber, String address, String summary) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.summary = summary;
    }

    // Getter metotları - Özel (private) bilgilere dışarıdan erişmek için kullanılır.
    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getSummary() {
        return summary;
    }
}