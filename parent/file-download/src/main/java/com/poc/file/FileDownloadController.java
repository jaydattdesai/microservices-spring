package com.poc.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.poc.file.commons.model.File;
import com.poc.file.commons.repository.FileRepository;

@RestController
public class FileDownloadController {

	@Autowired
	FileRepository fileRepository;
	
	
	@GetMapping(path="/listAllFiles")
	public Iterable<File> getFile() {
		return fileRepository.findAll();
	}
	
	
	@GetMapping("/listAllFiles/{id}")
	public HttpEntity<byte[]> downloadFile(@PathVariable("id") Long id) {
		
		File file = fileRepository.findOne(id);
		
		HttpHeaders header = new HttpHeaders();
	    header.set(HttpHeaders.CONTENT_DISPOSITION,
	                   "attachment; filename=" + file.getFileName());
	    header.setContentLength(file.getContent().length);

	    return new HttpEntity<byte[]>(file.getContent(), header);
	}
	

}
