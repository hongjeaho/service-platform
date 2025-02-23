package com.platform.common.web.base.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "ApiResponse", title = "응답 정보")
public class ApiResponse<T> {

    @Schema(title = "성공 여부")
    private boolean succeeded;
    @Schema(title = "응답 메세지")
    private String message;
    @Schema(title = "요청 정보")
    private T payload;

    public static <T> ApiResponse<T> of(String message, T payload) {
        var apiResponse = new ApiResponse<T>();
        apiResponse.succeeded = true;
        apiResponse.message = message;
        apiResponse.payload = payload;

        return apiResponse;
    }

    public static ApiResponse<Void> ofError(Exception exception) {
        return ofError(exception, null);
    }

    public static <T> ApiResponse<T> ofError(Exception exception, T payload) {
        var apiResponse = new ApiResponse<T>();
        apiResponse.succeeded = false;
        apiResponse.message = exception.getMessage();
        apiResponse.payload = payload;

        return apiResponse;
    }

    public static <T> ApiResponse<T> payload(T payload) {
        return of(null, payload);
    }
}
