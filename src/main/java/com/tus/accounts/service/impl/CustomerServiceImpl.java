package com.tus.accounts.service.impl;

import com.tus.accounts.dto.CustomerDto;
import com.tus.accounts.dto.PageResponse;
import com.tus.accounts.dto.request.CreateCustomerRequest;
import com.tus.accounts.dto.request.UpdateCustomerRequest;
import com.tus.accounts.entity.Customer;
import com.tus.accounts.exception.ResourceNotFoundException;
import com.tus.accounts.mapper.CustomerMapper;
import com.tus.accounts.repository.CustomerRepository;
import com.tus.accounts.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerDto create(CreateCustomerRequest req) {
        Customer c = CustomerMapper.toEntity(req);
        Customer saved = customerRepository.save(c);
        return CustomerMapper.toDto(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerDto getById(Long customerId) {
        Customer c = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer " + customerId + " not found"));
        return CustomerMapper.toDto(c);
    }

    @Override
    @Transactional(readOnly = true)
    public PageResponse<CustomerDto> getAll(Pageable pageable) {
        Page<Customer> page = customerRepository.findAll(pageable);
        return new PageResponse<>(
                page.getContent().stream().map(CustomerMapper::toDto).collect(Collectors.toList()),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }

    @Override
    public CustomerDto update(Long customerId, UpdateCustomerRequest req) {
        Customer c = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer " + customerId + " not found"));
        CustomerMapper.updateEntity(c, req);
        Customer saved = customerRepository.save(c);
        return CustomerMapper.toDto(saved);
    }

    @Override
    public void delete(Long customerId) {
        Customer c = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer " + customerId + " not found"));
        customerRepository.delete(c);
    }
}
