package org.leonardo.beatland.controller;

import org.leonardo.beatland.entity.Purchase;
import org.leonardo.beatland.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    public List<Purchase> getAllPurchases(){
        return purchaseService.getALlPurchases();
    }

    @PostMapping
    public Purchase createPurchase(@RequestBody Purchase purchase){
        return purchaseService.createPurchase(purchase);
    }

    @DeleteMapping("/{id}")
    public void deletePurchase(@PathVariable Long id){
        purchaseService.deletePurchase(id);
    }

}
