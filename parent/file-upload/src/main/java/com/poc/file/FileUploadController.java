package com.poc.file;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.poc.file.commons.model.File;
import com.poc.file.commons.repository.FileRepository;

@RestController
public class FileUploadController {
	
	@Autowired
	FileRepository fileRepository;

	@PostMapping(path="/uploadFile")
	String uploadFile(@RequestParam("file") MultipartFile fileToUpload) throws IOException {
		
		File file = new File();
		file.setContent(fileToUpload.getBytes());
		file.setFileName(fileToUpload.getOriginalFilename());
		file.setContentType(fileToUpload.getContentType());
		fileRepository.save(file);
		return "File: "+fileToUpload.getOriginalFilename()+" uploaded successfully";
	}
	

}
