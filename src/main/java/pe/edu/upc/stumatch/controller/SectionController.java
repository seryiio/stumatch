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

import pe.edu.upc.stumatch.business.crud.CourseService;
import pe.edu.upc.stumatch.business.crud.SectionService;
import pe.edu.upc.stumatch.business.crud.TeacherService;
import pe.edu.upc.stumatch.model.entity.Course;
import pe.edu.upc.stumatch.model.entity.Section;
import pe.edu.upc.stumatch.model.entity.Teacher;

@Controller
@RequestMapping("/sections")
@SessionAttributes("{section}")
public class SectionController {

	@Autowired
	private SectionService sectionService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private TeacherService teacherService;

	@GetMapping
	public String listSection(Model model) {

		try {
			List<Section> sections = sectionService.getAll();
			model.addAttribute("sections", sections);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "sections/list-sections";
	}

	@GetMapping("new")
	public String newSection(Model model) {
		Section section = new Section();
		model.addAttribute("section", section);
		try {
			List<Course> courses = courseService.getAll();
			model.addAttribute("courses", courses);
			List<Teacher> teachers = teacherService.getAll();
			model.addAttribute("teachers", teachers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "sections/new-section";
	}

	@PostMapping("savenew")
	public String saveSection(@Valid @ModelAttribute("section") Section section, BindingResult result, Model model) {
		try {
			if(result.hasErrors())
			{
				List<Course> courses = courseService.getAll();
				model.addAttribute("courses", courses);
				List<Teacher> teachers = teacherService.getAll();
				model.addAttribute("teachers", teachers);
				return "sections/new-section";
			}
			Section sectionSaved = sectionService.create(section);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/sections";
	}

	@GetMapping("{id}/edit")
	public String editSection(Model model, @PathVariable("id") String id) {

		try {
			if (sectionService.existById(id)) {
				Optional<Section> optional = sectionService.findById(id);
				model.addAttribute("section", optional.get());
				List<Course> courses = courseService.getAll();
				model.addAttribute("courses", courses);
				List<Teacher> teachers = teacherService.getAll();
				model.addAttribute("teachers", teachers);
			} else {
				return "redirect:/sections";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "sections/edit-section";
	}

	@PostMapping("{id}/update")
	public String updateSection(Model model, @ModelAttribute("section") Section section,
			@PathVariable("id") String id) {
		try {
			if (sectionService.existById(id)) {
				sectionService.update(section);
			} else {
				return "redirect:/sections";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/sections";
	}

	@GetMapping("{id}/delete")
	public String deleteSection(Model model, @PathVariable("id") String id) {
		try {
			if (sectionService.existById(id)) {
				sectionService.deleteById(id);
			} else {
				return "redirect:/sections";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/sections";
	}

}
