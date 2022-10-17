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

import az.developia.library.dao.StudentDAO;
import az.developia.library.model.Student;
 
@Controller
public class StudentController {

	@Autowired
	private StudentDAO studentDAO;
 
	@GetMapping(path = "/students")
	public String showStudents(Model model) {
		List<Student> students=studentDAO.findAll();
		model.addAttribute("students", students);
		return "students";
	}
	@GetMapping(path = "/students/new")
	public String openNewStudentPage(Model model) {
		Student student=new Student();
		model.addAttribute("student", student);
		model.addAttribute("header", "Yeni Telebe");
		return "save-student";
	}
	 
	@PostMapping(path="/students/new-student-process")
	public String saveStudent(@Valid  @ModelAttribute(name="student") Student student,
			BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "save-student";
		}
		studentDAO.save(student);
		List<Student> students=studentDAO.findAll();
		model.addAttribute("students", students);
		return "redirect:/students";
	}
	@GetMapping(path = "/students/delete/{id}")
	public String deleteBook(@PathVariable(name="id")Integer id,Model model) {
		boolean studentExists=studentDAO.findById(id).isPresent();
		if(studentExists) {
			studentDAO.deleteById(id);
		}else {
			
		}
		List<Student> students=studentDAO.findAll();
		model.addAttribute("students", students);
		
		return "redirect:/students";
	}
	@GetMapping(path = "/students/edit/{id}")
	public String editBook(@PathVariable(name="id")Integer id,Model model) {
		Optional<Student> studentOptional=studentDAO.findById(id);
		boolean studentExists=studentOptional.isPresent();
		Student student=new Student();
		if(studentExists) {
			student=studentOptional.get();
		}else {
			
		}
		
		model.addAttribute("student", student);
		model.addAttribute("header", "Telebe redaktesi");
		
		return "save-student";
	}
}
