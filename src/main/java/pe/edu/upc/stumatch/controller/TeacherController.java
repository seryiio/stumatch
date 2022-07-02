package pe.edu.upc.stumatch.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
import pe.edu.upc.stumatch.business.crud.TeacherService;
import pe.edu.upc.stumatch.model.entity.Career;
import pe.edu.upc.stumatch.model.entity.Teacher;

@Controller
@RequestMapping("/teachers")
@SessionAttributes("{teacher}")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private CareerService careerService;
	
	@GetMapping
	public String listTeacher(Model model) {
		
		try {
			List<Teacher> teachers = teacherService.getAll();
			model.addAttribute("teachers", teachers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "teachers/list-teachers";
	}
	
	@GetMapping("new")
	public String newTeacher(Model model) {
		Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);
		try {
			List<Career> careers = careerService.getAll();
			model.addAttribute("careers", careers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "teachers/new-teacher";
	}
	
	@PostMapping("savenew")
	public String saveTeacher(@Valid @ModelAttribute("teacher") Teacher teacher, BindingResult result,Model model) {
		try {
			if(result.hasErrors())
			{
				List<Career> careers = careerService.getAll();
				model.addAttribute("careers", careers);
				return "teachers/new-teacher";
			}
			Teacher teacherSaved = teacherService.create(teacher);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/teachers";
	}
	
	@GetMapping("{id}/edit")
	public String editTeacher(Model model, @PathVariable("id") String id) {
		
		try {
			if(teacherService.existById(id)) {
				Optional<Teacher> optional = teacherService.findById(id);
				model.addAttribute("teacher", optional.get());
				List<Career> careers = careerService.getAll();
				model.addAttribute("careers", careers);
			} else {
				return "redirect:/teachers";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "teachers/edit-teacher";
	}
	
	@PostMapping("{id}/update")
	public String updateTeacher(Model model, @ModelAttribute("teacher") Teacher teacher, @PathVariable("id") String id) {
		try {
			if(teacherService.existById(id)) {
				teacherService.update(teacher);
			} else {
				return "redirect:/teachers";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/teachers";
	}
	
	@GetMapping("{id}/delete")
	public String deleteTeacher(Model model, @PathVariable("id") String id) {
		try {
			if(teacherService.existById(id)) {
				teacherService.deleteById(id);
			} else {
				return "redirect:/teachers";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/teachers";
	}
	
}
