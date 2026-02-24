package com.tus.accounts.controller;

import com.tus.accounts.dto.CustomerDto;
import com.tus.accounts.dto.PageResponse;
import com.tus.accounts.dto.request.CreateCustomerRequest;
import com.tus.accounts.dto.request.UpdateCustomerRequest;
import com.tus.accounts.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> create(@Valid @RequestBody CreateCustomerRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(req));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> get(@PathVariable Long customerId) {
        return ResponseEntity.ok(customerService.getById(customerId));
    }

    @GetMapping
    public ResponseEntity<PageResponse<CustomerDto>> list(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(customerService.getAll(pageable));
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> update(@PathVariable Long customerId, @Valid @RequestBody UpdateCustomerRequest req) {
        return ResponseEntity.ok(customerService.update(customerId, req));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> delete(@PathVariable Long customerId) {
        customerService.delete(customerId);
        return ResponseEntity.noContent().build();
    }
}
