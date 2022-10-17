package az.developia.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.library.model.Student;

public interface StudentDAO extends JpaRepository<Student, Integer> {
  
}
 