package org.student.service;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.student.dao.StudentDao;
import org.student.entity.ResponseStructure;
import org.student.entity.Student;
import org.student.exception.StudentNotFoundException;
@Service
public class StudentService{
@Autowired
StudentDao studentDao;
public ResponseStructure<Student>  createStudent(Student student,MultipartFile file) throws IOException{
   ResponseStructure<Student> structure=new ResponseStructure<>();
boolean br=true;
Map<String, Integer>marks=	student.getMarks();
for(String name:marks.keySet()) {
	if(marks.get(name)<35)
		br=false;
}
int age=Period.between(student.getDob(), LocalDate.now()).getYears();
if(age<15 || age>20)
	br=false;
if(br) {
	structure.setBody(student);
	structure.setCode(HttpStatus.ACCEPTED);
	structure.setMessage("valid Sucessfully");
	studentDao.save(student,file);
}
else {
	
	structure.setBody(null);
	structure.setCode(HttpStatus.NOT_ACCEPTABLE);
	structure.setMessage("error");
}
	return structure;
}
public ResponseStructure<Student>updateStudent(Student student,MultipartFile file) throws IOException{
	ResponseStructure<Student> structure =new ResponseStructure<>();
	Map<String , Integer> marks=student.getMarks();
	boolean br=true;
	for(String name:marks.keySet()) {
		if(marks.get(name)<35 && marks.get(name)<0 && marks.get(name)>100)
			br=false;
	}
	if(br==false) {
		structure.setBody(null);
		structure.setCode(HttpStatus.NOT_ACCEPTABLE);
		structure.setMessage("error");
	}
	else {
		structure.setBody(student);
		structure.setCode(HttpStatus.ACCEPTED);
		structure.setMessage("Update  Sucessfully");
		studentDao.save(student,file);
	}
	return structure;
}
public ResponseStructure<Student> deleteStudent(Long id){
	ResponseStructure<Student> structure=new ResponseStructure<Student>();
	Optional<Student> st=studentDao.search(id);
	
	if(!st.isPresent()) 
		throw new StudentNotFoundException();
	else {
	structure.setBody(null);
	structure.setCode(HttpStatus.FOUND);
	studentDao.delete(id);
	structure.setMessage("delete Sucessfully");
	return structure;
	}
	
}

}
