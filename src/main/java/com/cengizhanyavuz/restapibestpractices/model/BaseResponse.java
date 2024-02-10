package com.cengizhanyavuz.restapibestpractices.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record BaseResponse<T>(boolean isSuccess, T payload, String message) {
    @JsonCreator
    public BaseResponse(@JsonProperty("success") boolean isSuccess,
                        @JsonProperty("payload") T payload,
                        @JsonProperty("message") String message) {
        this.isSuccess = isSuccess;
        this.payload = payload;
        this.message = message;
    }

    public static <T> BaseResponse<T> success(T payload, String message) {
        return new BaseResponse<>(true, payload, message);
    }

    public static <T> BaseResponse<T> fail(T payload, String message) {
        return new BaseResponse<>(false, payload, message);
    }
}
