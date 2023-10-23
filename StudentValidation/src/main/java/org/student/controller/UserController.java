package org.student.controller;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.student.entity.User;
import org.student.service.UserService;

@RestController
public class UserController {
@Autowired
	UserService userService;
@PostMapping("/user")
public User addUser(@RequestParam String name,@RequestParam double sal,@RequestParam MultipartFile multipartFile) throws IOException {
	return userService.addUser(name, sal, multipartFile);
}
	
}
