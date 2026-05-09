package com.tss.hibernate.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@Data
public class ErrorResponse {
    private int status;
    private String message;
    private String path;
    private Instant timestamp;
    private String error;
}
