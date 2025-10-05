// JobExperience.java dosyasının içine yapıştırılacak kod

package org.example; // Bu satır sendeki paket adıyla aynı olmalı

public class JobExperience {
    private String jobTitle;
    private String company;
    private String dates;
    private String description;

    // Constructor
    public JobExperience(String jobTitle, String company, String dates, String description) {
        this.jobTitle = jobTitle;
        this.company = company;
        this.dates = dates;
        this.description = description;
    }

    // Getters
    public String getJobTitle() {
        return jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public String getDates() {
        return dates;
    }

    public String getDescription() {
        return description;
    }
}