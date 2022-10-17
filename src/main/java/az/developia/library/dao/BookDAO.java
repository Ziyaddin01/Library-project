package az.developia.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.library.model.Book;

public interface BookDAO extends JpaRepository<Book, Integer> {
 
}
 