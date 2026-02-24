package com.tus.accounts.dto;

import com.tus.accounts.entity.AccountStatus;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class AccountDto {
    private Long accountNumber;
    private Long customerId;

    private String accountType;
    private String branchAddress;

    private LocalDate openedDate;
    private AccountStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
