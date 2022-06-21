package com.hachiko.bookshop.controllers;

import com.hachiko.bookshop.dtos.CustomerDTO;
import com.hachiko.bookshop.facades.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerFacade customerFacade;

    @PostMapping("")
    public CustomerDTO addNewCustomer(@RequestBody @Valid CustomerDTO customerDTO){
         return customerFacade.save(customerDTO);
    }

    @GetMapping(params = "email")
    public CustomerDTO findCustomerByEmail(@RequestParam("email") @Valid String email ){
        return customerFacade.findCustomerByEmail(email);
    }
}
