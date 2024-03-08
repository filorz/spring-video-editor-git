package com.java.service;

import com.java.payload.VideoRequest;
import com.java.utils.VideoOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class UserServiceImpl implements UserService {
	final private VideoOperation videoOperation;
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	public UserServiceImpl(VideoOperation videoOperation) {
		this.videoOperation = videoOperation;
	}

	@Async
	public CompletableFuture<Void> changeResolution(Long id, VideoRequest videoRequest) {
		logger.info("Start change resolution video" + Thread.currentThread().getName());
		videoOperation.videoScale(id, videoRequest.getWidth(), videoRequest.getHeight());

		return CompletableFuture.completedFuture(null);
	}

}
