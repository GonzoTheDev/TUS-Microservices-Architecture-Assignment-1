package com.tus.accounts.controller;

import com.tus.accounts.dto.AccountDto;
import com.tus.accounts.dto.PageResponse;
import com.tus.accounts.dto.request.CreateAccountRequest;
import com.tus.accounts.dto.request.UpdateAccountRequest;
import com.tus.accounts.service.AccountsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/customers/{customerId}/accounts")
@RequiredArgsConstructor
public class AccountsController {

    private final AccountsService accountsService;

    @PostMapping
    public ResponseEntity<AccountDto> create(
            @PathVariable Long customerId,
            @Valid @RequestBody CreateAccountRequest req
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountsService.createForCustomer(customerId, req));
    }

    @GetMapping
    public ResponseEntity<PageResponse<AccountDto>> list(
            @PathVariable Long customerId,
            @RequestParam(required = false) LocalDate openedFrom,
            @RequestParam(required = false) LocalDate openedTo,
            @PageableDefault(size = 10) Pageable pageable
    ) {
        return ResponseEntity.ok(accountsService.getForCustomer(customerId, openedFrom, openedTo, pageable));
    }

    @PutMapping("/{accountNumber}")
    public ResponseEntity<AccountDto> update(
            @PathVariable Long customerId,
            @PathVariable Long accountNumber,
            @Valid @RequestBody UpdateAccountRequest req
    ) {
        return ResponseEntity.ok(accountsService.updateForCustomer(customerId, accountNumber, req));
    }

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<Void> delete(
            @PathVariable Long customerId,
            @PathVariable Long accountNumber
    ) {
        accountsService.deleteForCustomer(customerId, accountNumber);
        return ResponseEntity.noContent().build();
    }
}
