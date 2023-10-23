package org.student.service;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class FileService  {
private final String UPDATE_URL="C:\\Users\\kaluc\\OneDrive\\Desktop\\SpringBoot\\StudentValidation\\src\\main\\resources\\static\\image";
public boolean uploadFile(MultipartFile multipartFile) throws IOException {
	boolean br=false;
	Files.copy(multipartFile.getInputStream(), Paths.get(UPDATE_URL+File.separator+multipartFile.getOriginalFilename()) ,StandardCopyOption.REPLACE_EXISTING);
	br=true;
	return br;
}
}
