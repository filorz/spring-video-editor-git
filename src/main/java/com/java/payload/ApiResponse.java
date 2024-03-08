package com.java.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {
    private Boolean success;

    public ApiResponse(Boolean success) {
        this.success = success;
    }
}
