package org.student.dao;
import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.student.entity.Student;
import org.student.repository.StudentRepository;
@Repository
public class StudentDao {
@Autowired
StudentRepository studentRepository;
public Student save(Student student,MultipartFile file) throws IOException {
	student.setFileData(file.getBytes());
	return studentRepository.save(student);
}
public Student update(Student student) {
	return studentRepository.save(student);
}
public void delete(Long id) {
	 studentRepository.deleteById(id);
}
public Optional<Student> search(Long id){
	return studentRepository.findById(id);
}

}
