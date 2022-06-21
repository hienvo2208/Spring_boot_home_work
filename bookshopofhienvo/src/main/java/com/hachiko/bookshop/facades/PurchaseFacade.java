package com.hachiko.bookshop.facades;

import com.hachiko.bookshop.dtos.PurchaseRequestDTO;
import com.hachiko.bookshop.dtos.PurchaseResponseDTO;
import com.hachiko.bookshop.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseFacade {

    @Autowired
    private PurchaseService purchaseService;

    public PurchaseResponseDTO savePurchaseFacade(PurchaseRequestDTO purchaseRequestDTO) {
         return null;
    }
}
