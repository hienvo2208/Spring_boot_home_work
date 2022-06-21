package com.hachiko.bookshop.controllers;

import com.hachiko.bookshop.dtos.PurchaseRequestDTO;
import com.hachiko.bookshop.dtos.PurchaseResponseDTO;
import com.hachiko.bookshop.facades.PurchaseFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseFacade purchaseFacade;
    public PurchaseResponseDTO addNewPurchase(@RequestBody @Valid PurchaseRequestDTO purchaseRequestDTO){
        return purchaseFacade.savePurchaseFacade(purchaseRequestDTO);
    }
}
