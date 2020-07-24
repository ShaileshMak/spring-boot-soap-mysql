package com.shailesh.mak.soap.api.repository;

import com.shailesh.mak.soap.api.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student ,Long> {
}
