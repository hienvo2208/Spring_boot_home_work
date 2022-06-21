package com.hachiko.bookshop.services;

import com.hachiko.bookshop.entties.Purchase;
import com.hachiko.bookshop.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }

    public List<Purchase>
}
