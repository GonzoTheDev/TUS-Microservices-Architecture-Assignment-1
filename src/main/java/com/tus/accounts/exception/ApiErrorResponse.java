package com.tus.accounts.exception;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class ApiErrorResponse {
    private String apiPath;
    private String errorCode;
    private String errorMessage;
    private LocalDateTime errorTime;
}
