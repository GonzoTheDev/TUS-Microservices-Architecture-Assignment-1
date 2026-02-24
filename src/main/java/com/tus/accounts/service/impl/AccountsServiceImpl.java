package com.tus.accounts.service.impl;

import com.tus.accounts.dto.AccountDto;
import com.tus.accounts.dto.PageResponse;
import com.tus.accounts.dto.request.CreateAccountRequest;
import com.tus.accounts.dto.request.UpdateAccountRequest;
import com.tus.accounts.entity.Accounts;
import com.tus.accounts.entity.Customer;
import com.tus.accounts.exception.ResourceNotFoundException;
import com.tus.accounts.mapper.AccountsMapper;
import com.tus.accounts.repository.AccountsRepository;
import com.tus.accounts.repository.CustomerRepository;
import com.tus.accounts.service.AccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountsServiceImpl implements AccountsService {

    private final CustomerRepository customerRepository;
    private final AccountsRepository accountsRepository;

    @Override
    public AccountDto createForCustomer(Long customerId, CreateAccountRequest req) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer " + customerId + " not found"));

        Accounts a = AccountsMapper.toEntity(req, customer);
        Accounts saved = accountsRepository.save(a);
        return AccountsMapper.toDto(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public PageResponse<AccountDto> getForCustomer(Long customerId, LocalDate openedFrom, LocalDate openedTo, Pageable pageable) {
        if (openedFrom != null && openedTo != null && openedFrom.isAfter(openedTo)) {
            throw new IllegalArgumentException("openedFrom must be <= openedTo");
        }

        if (!customerRepository.existsById(customerId)) {
            throw new ResourceNotFoundException("Customer " + customerId + " not found");
        }

        Page<Accounts> page;
        if (openedFrom != null && openedTo != null) {
            page = accountsRepository.findByCustomer_CustomerIdAndOpenedDateBetween(customerId, openedFrom, openedTo, pageable);
        } else {
            page = accountsRepository.findByCustomer_CustomerId(customerId, pageable);
        }

        return new PageResponse<>(
                page.getContent().stream().map(AccountsMapper::toDto).collect(Collectors.toList()),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }

    @Override
    public AccountDto updateForCustomer(Long customerId, Long accountNumber, UpdateAccountRequest req) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer " + customerId + " not found"));

        Accounts a = accountsRepository.findById(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Account " + accountNumber + " not found"));

        if (!a.getCustomer().getCustomerId().equals(customer.getCustomerId())) {
            throw new ResourceNotFoundException("Account " + accountNumber + " not found for customer " + customerId);
        }

        AccountsMapper.updateEntity(a, req);
        Accounts saved = accountsRepository.save(a);
        return AccountsMapper.toDto(saved);
    }

    @Override
    public void deleteForCustomer(Long customerId, Long accountNumber) {
        Accounts a = accountsRepository.findById(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Account " + accountNumber + " not found"));

        if (a.getCustomer() == null || !a.getCustomer().getCustomerId().equals(customerId)) {
            throw new ResourceNotFoundException("Account " + accountNumber + " not found for customer " + customerId);
        }

        accountsRepository.delete(a);
    }
}
