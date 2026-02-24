package com.tus.accounts.dto.request;

import com.tus.accounts.entity.AccountStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class UpdateAccountRequest {

    @NotBlank
    @Size(max = 100)
    private String accountType;

    @NotBlank
    @Size(max = 200)
    private String branchAddress;

    @NotNull
    private LocalDate openedDate;

    @NotNull
    private AccountStatus status;
}
