package org.leonardo.beatland.service;

import org.leonardo.beatland.entity.Beat;
import org.leonardo.beatland.entity.LicenseTemplate;
import org.leonardo.beatland.entity.Purchase;
import org.leonardo.beatland.repository.BeatRepository;
import org.leonardo.beatland.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private BeatRepository beatRepository;

    public Purchase createPurchase(Purchase purchase){
        LicenseTemplate license = purchase.getLicenseTemplate();
        Beat beat = purchase.getBeat();

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
