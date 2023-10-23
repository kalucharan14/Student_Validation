package org.student.dao;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.student.entity.User;
import org.student.repository.UserRepository;

@Repository
public class UserDao {
	@Autowired
UserRepository userRepository;
public User addUser(String name,double sal,MultipartFile multipartFile) throws IOException {
	User u=new User();
	u.setName(name);
	u.setSal(sal);
	u.setFiledata(multipartFile.getBytes());
	userRepository.save(u);
	return u;
}
}
