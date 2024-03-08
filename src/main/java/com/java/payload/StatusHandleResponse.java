package com.java.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatusHandleResponse {
    private UUID id;
    private String filename;
    private Boolean processing;
    private Boolean processingSuccess;

}
