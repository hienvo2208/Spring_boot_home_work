package com.hachiko.bookshop.facades;

import com.hachiko.bookshop.dtos.CustomerDTO;
import com.hachiko.bookshop.entties.Customer;
import com.hachiko.bookshop.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static com.hachiko.bookshop.constants.ErrorCode.CUSTOMER_ALREADY_EXISTS;
import static com.hachiko.bookshop.constants.ErrorCode.CUSTOMER_NOT_FOUND;

@Service
public class CustomerFacade {
    @Autowired
    private CustomerService customerService;

    public CustomerDTO save(CustomerDTO cDTO) {
        Optional<Customer> customer = customerService.findCustomerByEmail(cDTO.getEmail());
        if (!customer.isPresent()) {
            Customer result = Customer.builder()
                    .name(cDTO.getName())
                    .surname(cDTO.getSurname())
                    .address(cDTO.getAddress())
                    .email(cDTO.getEmail())
                    .build();
            customerService.save(result);
            return cDTO;
        } else {
            CustomerDTO csDto = new CustomerDTO();
            csDto.setErrorMessage(CUSTOMER_ALREADY_EXISTS.getMessage());
            csDto.setError(CUSTOMER_ALREADY_EXISTS.getCode());
            return csDto;
        }
    }

    public CustomerDTO findCustomerByEmail(String email) {
        Optional<Customer> customer = customerService.findCustomerByEmail(email);
        if (customer.isPresent()) {
            return CustomerDTO.fromCustomer(customer.get());
        }
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setErrorMessage(CUSTOMER_NOT_FOUND.getMessage());
        customerDTO.setError(CUSTOMER_NOT_FOUND.getCode());
        return customerDTO;
    }
}
