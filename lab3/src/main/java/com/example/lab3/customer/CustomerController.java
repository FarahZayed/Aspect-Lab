package com.example.lab3.customer;
import com.example.lab3.customer.dto.CreateCustomerDTO;
import com.example.lab3.customer.dto.UpdateCustomerDTO;
import com.example.lab3.customer.customer;
import com.example.lab3.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<customer> createcustomer(@Valid @RequestBody CreateCustomerDTO dto) {
        return ResponseEntity.ok(customerService.createcustomer(dto));
    }

    @GetMapping
    public ResponseEntity<List<customer>> getAllcustomers() {
        return ResponseEntity.ok(customerService.getAllcustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<customer> getcustomerById(@PathVariable Long id) {
        return customerService.getcustomerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<customer> updatecustomer(@PathVariable Long id,
                                                   @Valid @RequestBody UpdateCustomerDTO dto) {
        return customerService.updatecustomer(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletecustomer(@PathVariable Long id) {
        if (customerService.deletecustomer(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
