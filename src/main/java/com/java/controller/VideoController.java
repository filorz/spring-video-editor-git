package com.java.controller;

import com.java.payload.ApiFileResponse;
import com.java.payload.ApiResponse;
import com.java.payload.StatusHandleResponse;
import com.java.payload.VideoRequest;
import com.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/file")
public class VideoController {

	@Autowired UserService service;

	private CompletableFuture<Void> future = new CompletableFuture<>();
	
	@PostMapping(value = "/", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<?> saveUsers(@RequestParam(value="file") MultipartFile file) throws Exception {

		return ResponseEntity.ok().body(new ApiFileResponse(UUID.randomUUID()));
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<?> changeResolutionVideo(
			@PathVariable Long id,
			@RequestBody VideoRequest request) {

		future = CompletableFuture.runAsync(() -> service.changeResolution(id, request));
		return ResponseEntity.ok().body(new ApiResponse(true));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getStatusHandleFile(@PathVariable Long id) {
		if (future.isDone()) {
			return ResponseEntity.ok()
					.body(new StatusHandleResponse(
							UUID.randomUUID(),
							id.toString() + ".mpg4",
							false,
							true
					));
		}

		return ResponseEntity.ok()
				.body(new StatusHandleResponse(
						UUID.randomUUID(),
						id.toString() + ".mpg4",
						true,
						false
				));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) {

		return ResponseEntity.ok()
				.body(new ApiResponse(true));
	}
}
