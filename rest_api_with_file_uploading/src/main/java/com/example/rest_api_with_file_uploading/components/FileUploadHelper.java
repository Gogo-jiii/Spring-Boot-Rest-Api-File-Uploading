package com.example.rest_api_with_file_uploading.components;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public final String DIR_PATH = "/home/vg/Downloads/rest_api_with_file_uploading/src/main/resources/static/images";

	public boolean uploadFile(MultipartFile file) {
		Path file_path =  Path.of(DIR_PATH + File.separator + file.getOriginalFilename());
		
		try {
			Files.copy(file.getInputStream(), file_path,StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
