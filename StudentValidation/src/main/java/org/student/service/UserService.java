package org.student.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.student.dao.UserDao;
import org.student.entity.User;

@Service
public class UserService {
@Autowired
UserDao userDao;
public User addUser(String name,double sal,MultipartFile multipartFile) throws IOException {
	return userDao.addUser(name, sal, multipartFile);
}
}
