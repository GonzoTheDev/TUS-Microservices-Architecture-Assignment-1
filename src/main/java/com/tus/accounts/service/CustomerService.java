package com.tus.accounts.service;

import com.tus.accounts.dto.CustomerDto;
import com.tus.accounts.dto.PageResponse;
import com.tus.accounts.dto.request.CreateCustomerRequest;
import com.tus.accounts.dto.request.UpdateCustomerRequest;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    CustomerDto create(CreateCustomerRequest req);
    CustomerDto getById(Long customerId);
    PageResponse<CustomerDto> getAll(Pageable pageable);
    CustomerDto update(Long customerId, UpdateCustomerRequest req);
    void delete(Long customerId);
}
