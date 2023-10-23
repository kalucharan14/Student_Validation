package org.student.controller;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.student.entity.ResponseStructure;
import org.student.entity.Student;
import org.student.service.FileService;
import org.student.service.StudentService;
import jakarta.validation.Valid;
@RestController
public class StudentController {
@Autowired
StudentService studentService;
@Autowired
FileService fileService;
@PostMapping("/student")
public ResponseStructure<Student> create(@RequestBody @Valid Student student,@RequestParam MultipartFile file) throws IOException{
	 return studentService.createStudent(student,file);
}
@PutMapping("/student")
public ResponseStructure<Student> update(@RequestBody Student student,MultipartFile file) throws IOException{
	return studentService.updateStudent(student,file);
			
}
@DeleteMapping("/student/{id}")
public ResponseStructure<Student> delete(@PathVariable(name = "id") Long id){
	return studentService.deleteStudent(id);
}
@PostMapping("/upload")
public void fileUpload(@RequestParam("file") MultipartFile file) throws IOException{
//	String name=file.getName();
//	String content=file.getContentType();
//	long size=file.getSize();
//	System.out.println(name);
//	System.out.println(content);
//	System.out.println(size+"KB");
	if(file.isEmpty())
		System.out.println("please upload a file");
 if(!file.getContentType().equals("image/jpeg")) {
		System.out.println("please upload a jpeg file");
	}
 boolean br=fileService.uploadFile(file);
 if(br) {
	 System.out.println("file uploaded sucessfuly");
	}
 else
	 System.out.println("file upload to failled");
}

}
