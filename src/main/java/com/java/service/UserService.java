package com.java.service;

import com.java.payload.VideoRequest;

import java.util.concurrent.CompletableFuture;

public interface UserService {
	CompletableFuture<Void> changeResolution(Long id, VideoRequest videoRequest);
}
