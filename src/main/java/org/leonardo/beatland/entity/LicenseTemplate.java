package org.leonardo.beatland.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "license_templates")

public class LicenseTemplate {

    // Folgende Lizenztypen gibt es zur Verfügung
    public enum LicenseType{
        MP3,
        WAV,
        STEMS,
        EXCLUSIVE
    }

    public LicenseTemplate() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long licenseTemplateId;

    private String licenseName;

    @Enumerated(EnumType.STRING)
    private LicenseType licenseType;

    private String licenseDescription;
    private int licensePrice;

    //Exclusive Lizenz, welche ein Beat beim Kauf von dem Marketplace runternimmt
    private boolean isExclusive;

    //Getter & Setter Methoden


    public Long getLicenseTemplateId() {
        return licenseTemplateId;
    }

    public String getLicenseName() {
        return licenseName;
    }

    public void setLicenseName(String licenseName) {
        this.licenseName = licenseName;
    }

    public LicenseType getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(LicenseType licenseType) {
        this.licenseType = licenseType;
    }

    public String getLicenseDescription() {
        return licenseDescription;
    }

    public void setLicenseDescription(String licenseDescription) {
        this.licenseDescription = licenseDescription;
    }

    public int getLicensePrice() {
        return licensePrice;
    }

    public void setLicensePrice(int licensePrice) {
        this.licensePrice = licensePrice;
    }

    public boolean isExclusive() {
        return isExclusive;
    }

    public void setExclusive(boolean exclusive) {
        isExclusive = exclusive;
    }
}
