package org.leonardo.beatland.service;

import org.leonardo.beatland.entity.Beat;
import org.leonardo.beatland.entity.LicenseTemplate;
import org.leonardo.beatland.entity.Purchase;
import org.leonardo.beatland.entity.User;
import org.leonardo.beatland.repository.BeatRepository;
import org.leonardo.beatland.repository.LicenseTemplateRepository;
import org.leonardo.beatland.repository.PurchaseRepository;
import org.leonardo.beatland.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private BeatRepository beatRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LicenseTemplateRepository licenseTemplateRepository;

    public Purchase createPurchase(Purchase purchase){
        Beat beat = beatRepository.findById(purchase.getBeat().getBeatId()).orElseThrow();
        User user = userRepository.findById(purchase.getBuyer().getUserId()).orElseThrow();
        LicenseTemplate license = licenseTemplateRepository.findById(
                purchase.getLicenseTemplate().getLicenseTemplateId()).orElseThrow();

        purchase.setBuyer(user);
        purchase.setBeat(beat);
        purchase.setLicenseTemplate(license);
        purchase.setTransactionDate(LocalDateTime.now());

        if(!beat.isAvailable()){
            throw new RuntimeException("Beat ist nicht mehr verfügbar.");
        }

        if(license.isExclusive()){
            beat.setAvailable(false);
            beatRepository.save(beat);
        }

        return purchaseRepository.save(purchase);
    }

    public List<Purchase> getALlPurchases(){
        return purchaseRepository.findAll();
    }

    public Purchase getPurchaseById(Long id){
        return purchaseRepository.findById(id).orElse(null);
    }

    public void deletePurchase(Long id){
        purchaseRepository.deleteById(id);
    }

}
