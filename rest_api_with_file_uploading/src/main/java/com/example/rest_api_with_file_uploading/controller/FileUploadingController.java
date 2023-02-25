package com.example.rest_api_with_file_uploading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.rest_api_with_file_uploading.components.FileUploadHelper;

@RestController
public class FileUploadingController {

	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/upload_file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile multipartFile) {

		try {
			if (multipartFile.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File is empty");
			}

//			if (!multipartFile.getContentType().equals("image/png")) {
//				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only PNG image is allowed");
//			}

			boolean is_file_uploaded = fileUploadHelper.uploadFile(multipartFile);

			if (is_file_uploaded) {
				return ResponseEntity.ok("File uploaded successfully.");
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong.");
		}

	}
}
