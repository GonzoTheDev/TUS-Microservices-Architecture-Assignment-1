package com.tus.accounts.service;

import com.tus.accounts.dto.AccountDto;
import com.tus.accounts.dto.PageResponse;
import com.tus.accounts.dto.request.CreateAccountRequest;
import com.tus.accounts.dto.request.UpdateAccountRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface AccountsService {
    AccountDto createForCustomer(Long customerId, CreateAccountRequest req);
    PageResponse<AccountDto> getForCustomer(Long customerId, LocalDate openedFrom, LocalDate openedTo, Pageable pageable);
    AccountDto updateForCustomer(Long customerId, Long accountNumber, UpdateAccountRequest req);
    void deleteForCustomer(Long customerId, Long accountNumber);
}
