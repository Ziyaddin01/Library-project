package az.developia.library.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.library.dao.BookDAO;
import az.developia.library.model.Book;
 
@Controller
public class BookController {

	@Autowired
	private BookDAO bookDAO;
	 
	@GetMapping(path="/books")
	public String showBooks(Model model) {
		List<Book> books=bookDAO.findAll();
		model.addAttribute("books", books);
		return "books";
	}
	@GetMapping(path="/books/new")
	public String openNewBookPage(Model model) {
		Book book=new Book();
		model.addAttribute("book", book);
		model.addAttribute("header", "Kitab Yarat");
		return "save-book";
	}
	@PostMapping(path="/books/save-book-process")
	public String saveBook(@Valid @ModelAttribute(name="book")Book book,
			BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "save-book";
		}
		bookDAO.save(book);
		List<Book> books=bookDAO.findAll();
		model.addAttribute("books", books);
		return "redirect:/books";
	}
	@GetMapping(path="/books/delete/{id}")
	public String deleteBook(@PathVariable(name="id")Integer id,Model model) {
		boolean bookExists=bookDAO.findById(id).isPresent();
		if(bookExists) {
		bookDAO.deleteById(id);	
		}else {
			
		}
		List<Book> books=bookDAO.findAll();
		model.addAttribute("books", books);
		
		return "redirect:/books";
	}
	@GetMapping(path="/books/edit/{id}")
	public String editBook(@PathVariable(name="id")Integer id,Model model) {
		Optional<Book> bookOptional=bookDAO.findById(id);
		boolean bookExists=bookOptional.isPresent();
		Book book=new Book();
		if(bookExists) {
		book=bookOptional.get();	
		}else {
			
		}
 
		model.addAttribute("book", book);
		model.addAttribute("header", "Kitab Redaktesi");
		
		return "save-book";
	}
}
