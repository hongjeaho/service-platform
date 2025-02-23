package com.platform.common.web.base.exception;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.platform.common.web.base.dto.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(JWTDecodeException.class)
    public ResponseEntity<ApiResponse<Void>> handleOrderInValidException(
            final HttpServletRequest request,
            final JWTDecodeException ex) {

        log.error("JWTDecodeException {}\n", request.getRequestURI(), ex);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.ofError(ex));
    }
}
