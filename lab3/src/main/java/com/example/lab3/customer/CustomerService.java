package com.example.lab3.customer;



import com.example.lab3.customer.dto.CreateCustomerDTO;
import com.example.lab3.customer.dto.UpdateCustomerDTO;
import com.example.lab3.customer.customer;
import com.example.lab3.customer.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepository;

    public customer createcustomer(CreateCustomerDTO dto) {
        customer customer = new customer(dto.getName(), dto.getEmail(), dto.getPhone(), dto.getAddress());
        return customerRepository.save(customer);
    }

    public List<customer> getAllcustomers() {
        return customerRepository.findAll();
    }

    public Optional<customer> getcustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Optional<customer> updatecustomer(Long id, UpdateCustomerDTO dto) {
        return customerRepository.findById(id).map(existing -> {
            if (dto.getName() != null) existing.setName(dto.getName());
            if (dto.getEmail() != null) existing.setEmail(dto.getEmail());
            if (dto.getPhone() != null) existing.setPhone(dto.getPhone());
            if (dto.getAddress() != null) existing.setAddress(dto.getAddress());
            return customerRepository.save(existing);
        });
    }

    public boolean deletecustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
