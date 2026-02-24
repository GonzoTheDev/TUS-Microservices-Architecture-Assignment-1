package com.tus.accounts.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class CustomerDto {
    private Long customerId;
    private String name;
    private String email;
    private String mobileNumber;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private long totalAccounts;
}
