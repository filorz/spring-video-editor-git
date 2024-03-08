package com.java.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ApiFileResponse {
    private UUID id;

    public ApiFileResponse(UUID id) {
        this.id = id;
    }
}
