package org.leonardo.beatland.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "purchases")

public class Purchase {

    public Purchase() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseId;

    private LocalDateTime transactionDate;
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "beat_id")
    private Beat beat;

    @ManyToOne
    @JoinColumn(name = "license_template_id")
    private LicenseTemplate licenseTemplate;

    //Getter & Setter Methoden


    public Long getPurchaseId() {
        return purchaseId;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Beat getBeat() {
        return beat;
    }

    public void setBeat(Beat beat) {
        this.beat = beat;
    }

    public LicenseTemplate getLicenseTemplate() {
        return licenseTemplate;
    }

    public void setLicenseTemplate(LicenseTemplate licenseTemplate) {
        this.licenseTemplate = licenseTemplate;
    }
}
