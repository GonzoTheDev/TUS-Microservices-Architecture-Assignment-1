package com.tus.accounts.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class UpdateCustomerRequest {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Email
    @Size(max = 100)
    private String email;

    @NotBlank
    @Size(max = 20)
    @Pattern(regexp = "^[0-9+ ]{7,20}$", message = "mobileNumber must contain only digits, spaces, or + and be 7-20 chars")
    private String mobileNumber;
}
