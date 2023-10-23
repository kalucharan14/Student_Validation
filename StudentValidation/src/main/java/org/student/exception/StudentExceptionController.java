package org.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.student.entity.ResponseStructure;
import org.student.entity.Student;

@ControllerAdvice
public class StudentExceptionController {
    @ExceptionHandler(value=StudentNotFoundException.class)
	public ResponseStructure<Student> exception(StudentNotFoundException exception){
    	ResponseStructure<Student> st=new ResponseStructure<>();
    	st.setBody(null);
    	st.setMessage("not found");
    	st.setCode(HttpStatus.NOT_FOUND);
    	return st;
	}
	
}
