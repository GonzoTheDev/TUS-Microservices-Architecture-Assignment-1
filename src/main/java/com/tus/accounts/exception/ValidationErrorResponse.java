package com.tus.accounts.exception;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class ValidationErrorResponse {
    private String apiPath;
    private String errorCode;
    private String errorMessage;
    private LocalDateTime errorTime;
    private Map<String, String> fieldErrors;
}
