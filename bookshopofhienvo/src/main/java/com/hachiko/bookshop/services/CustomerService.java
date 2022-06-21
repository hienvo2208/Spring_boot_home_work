package com.hachiko.bookshop.services;

import com.hachiko.bookshop.dtos.CustomerDTO;
import com.hachiko.bookshop.entties.Customer;
import com.hachiko.bookshop.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public Optional<Customer> findCustomerByEmail(String email){
        return customerRepository.findCustomerByEmail(email);
    }


}
