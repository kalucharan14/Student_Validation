package org.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
