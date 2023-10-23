package org.student.repository;

import org.springframework.data.repository.CrudRepository;
import org.student.entity.User;
public interface UserRepository extends CrudRepository<User, Integer> {

}
