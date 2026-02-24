package com.tus.accounts.repository;

import com.tus.accounts.entity.Accounts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Page<Accounts> findByCustomer_CustomerId(Long customerId, Pageable pageable);

    Page<Accounts> findByCustomer_CustomerIdAndOpenedDateBetween(Long customerId, LocalDate from, LocalDate to, Pageable pageable);
}
