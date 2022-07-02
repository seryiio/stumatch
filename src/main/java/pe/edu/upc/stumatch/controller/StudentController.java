package pe.edu.upc.stumatch.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.stumatch.business.crud.CareerService;
import pe.edu.upc.stumatch.business.crud.StudentService;
import pe.edu.upc.stumatch.model.entity.Career;
import pe.edu.upc.stumatch.model.entity.Student;
import pe.edu.upc.stumatch.utils.UserAuthentication;

@Controller
@RequestMapping("/students")
@SessionAttributes("{student}")
public class StudentController {
	
	@Autowired
	private UserAuthentication userAuthentication;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CareerService careerService;
	
	@GetMapping
	public String listStudent(Model model) {
		
		try {
			List<Student> students = studentService.getAll();
			model.addAttribute("students", students);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "students/list-students";
	}
	
	@GetMapping("profile")
	public String profileStudent(Model model) {	
		
		if (userAuthentication.isAuthenticated()) {	// Enviar los datos del Segmento al html
			userAuthentication.getSegment(model);
		}
				
		return "students/profile-student";
	}
	
	@GetMapping("new")
	public String newStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		try {
			List<Career> careers = careerService.getAll();
			model.addAttribute("careers", careers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "students/new-student";
	}
	
	@PostMapping("savenew")
	public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult result,Model model) {
		try {
			if(result.hasErrors())
			{
				List<Career> careers = careerService.getAll();
				model.addAttribute("careers", careers);
				return "students/new-student";
			}
			Student studentSaved = studentService.create(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/users/new";
	}
	
	@GetMapping("{id}/edit")
	public String editStudent(Model model, @PathVariable("id") String id) {
		
		try {
			if(studentService.existById(id)) {
				Optional<Student> optional = studentService.findById(id);
				model.addAttribute("student", optional.get());
				List<Career> careers = careerService.getAll();
				model.addAttribute("careers", careers);
			} else {
				return "redirect:/students";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "students/edit-student";
	}
	
	@PostMapping("{id}/update")
	public String updateStudent(Model model, @ModelAttribute("student") Student student, @PathVariable("id") String id) {
		try {
			if(studentService.existById(id)) {
				studentService.update(student);
			} else {
				return "redirect:/students";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/students";
	}
	
	@GetMapping("{id}/delete")
	public String deleteStudent(Model model, @PathVariable("id") String id) {
		try {
			if(studentService.existById(id)) {
				studentService.deleteById(id);
			} else {
				return "redirect:/students";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/students";
	}
	
}
