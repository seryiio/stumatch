package pe.edu.upc.stumatch.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.stumatch.utils.UserAuthentication;
import pe.edu.upc.stumatch.business.crud.CareerService;
import pe.edu.upc.stumatch.business.crud.CourseService;
import pe.edu.upc.stumatch.business.crud.EnrollmentService;
import pe.edu.upc.stumatch.business.crud.SectionService;
import pe.edu.upc.stumatch.business.crud.StudentService;
import pe.edu.upc.stumatch.model.entity.Career;
import pe.edu.upc.stumatch.model.entity.Course;
import pe.edu.upc.stumatch.model.entity.Enrollment;
import pe.edu.upc.stumatch.model.entity.Section;
import pe.edu.upc.stumatch.model.entity.Student;

@Controller
@RequestMapping("/enrollments")
public class EnrollmentController {
	@Autowired
	private EnrollmentService enrollmentService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private SectionService sectionService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private CareerService careerService;

	@Autowired
	private UserAuthentication userAuthentication;

	@GetMapping
	public String listEnrollment(Model model) {

		if (userAuthentication.isAuthenticated()) { // Enviar los datos del Segmento al html
			userAuthentication.getSegment(model);
		}
		try {
			List<Enrollment> enrollments = enrollmentService.getAll();
			model.addAttribute("enrollments", enrollments);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			List<Course> courses = courseService.getAll();
			model.addAttribute("courses", courses);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			List<Section> sections = sectionService.getAll();
			model.addAttribute("sections", sections);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "enrollments/list-enrollments";
	}

	@GetMapping("{id}/select_section")
	public String selectSection(Model model, @PathVariable("id") String id, @ModelAttribute("course") Course course) {
		Enrollment enrollment = new Enrollment();
		model.addAttribute("enrollment", enrollment);
		if (userAuthentication.isAuthenticated()) {
			userAuthentication.getSegment(model);
		}
		try {
			if (courseService.existById(id)) {
				Optional<Course> optional = courseService.findById(id);
				model.addAttribute("course", optional.get());

				List<Enrollment> enrollments = enrollmentService.getAll();
				model.addAttribute("enrollments", enrollments);
				List<Section> sections = sectionService.getAll();
				model.addAttribute("sections", sections);
			} else {
				return "redirect:/enrollments";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "enrollments/list-course_sections";
	}

	@PostMapping("savenewSection")
	public String saveSelectSection(Model model, Enrollment enrollment, Section section, Course course, Student student,
			SessionStatus status, RedirectAttributes redirectAttrs) {
		try {
			enrollment.setNumberCycle("2022-01");
			int vacancies = enrollment.getSection().getVacancies();
			int newvacancies = vacancies - 1;
			enrollment.getSection().setVacancies(newvacancies);
			int creditCourse = enrollment.getSection().getCourse().getNumberCredits();
			int creditAmount = enrollment.getStudent().getCreditAmount();
			int newcreditAmount = creditAmount - creditCourse;
			enrollment.getSection().setVacancies(newvacancies);
			enrollment.getStudent().setCreditAmount(newcreditAmount);
			////////////// WENAAAAAAAAAAAAAAAAAAAA//////////////
			int rpta2 = enrollmentService.verifyVacancies(enrollment);
			int rpta3 = enrollmentService.veriflyCredits(enrollment);
			int rpta = enrollmentService.insert(enrollment);

			/*
			 * if (rpta2 < 0) { redirectAttrs.addFlashAttribute("mensaje", "Por vago")
			 * .addFlashAttribute("clase", "danger"); return "redirect:/enrollments"; } else
			 * { redirectAttrs.addFlashAttribute("mensaje",
			 * "Ta bien").addFlashAttribute("clase", "sucess"); }
			 */
			if (rpta >= 1) {
				redirectAttrs.addFlashAttribute("mensaje", "Elimine una seccion para seleccionar otra")
						.addFlashAttribute("clase", "danger");
			} else if (rpta <= 1 && rpta2 > 0) {
				redirectAttrs.addFlashAttribute("mensaje", "Se guardo correctamente").addFlashAttribute("clase",
						"sucess");
			}

			if (rpta <= 1 && rpta2 <= 0) {
				redirectAttrs.addFlashAttribute("mensaje", "No hay vacantes, seleccione otra seccion")
						.addFlashAttribute("clase", "warning");
			}
			if (rpta <= 1 && rpta2 > 0 && rpta3 < 0) {
				redirectAttrs.addFlashAttribute("mensaje", "Creditos insuficientes").addFlashAttribute("clase",
						"warning");
			}
			/*
			 * if (rpta >= 1) { if (rpta2 <= 0) {
			 * System.out.print("ASDDASFSDAFSADFSDFSAFASDFSF");
			 * redirectAttrs.addFlashAttribute("mensaje", "No hay :c")
			 * .addFlashAttribute("clase", "danger"); } else {System.out.print("Ya existe");
			 * redirectAttrs.addFlashAttribute("mensaje",
			 * "Elimine una seccion para seleccionar otra") .addFlashAttribute("clase",
			 * "danger");
			 * 
			 * return "redirect:/enrollments";} } else if (rpta < 1){
			 * redirectAttrs.addFlashAttribute("mensaje",
			 * "Se guardo correctamente").addFlashAttribute("clase", "sucess"); }
			 */

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/enrollments";
	}

	@PostMapping("{id}/update")
	public String updateEnrollment(Model model, @ModelAttribute("enrollment") Enrollment enrollment,
			@PathVariable("id") String id) {
		try {
			if (sectionService.existById(id)) {
				enrollmentService.update(enrollment);
			} else {
				return "redirect:/enrollments";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/enrollments";
	}

	@GetMapping("{id}/delete")
	public String deleteEnrollment(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttrs) {
		try {

			if (enrollmentService.existById(id)) {
				enrollmentService.Restaurar(id);
				enrollmentService.deleteById(id);
				redirectAttrs.addFlashAttribute("mensaje", "Se elimino correctamente").addFlashAttribute("clase",
						"success");
				/*
				 * if (enrollment.getStudent().getId() == student.getId()) { int creditAmount =
				 * 10; int newcreditAmount = creditAmount + 5;
				 * student.setCreditAmount(newcreditAmount); studentService.update(student); }
				 */
			} else {
				return "redirect:/enrollments";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/enrollments";
	}

	@RequestMapping("/report")
	public String listEnrollmentforCycle(Map<String, Object> model) {

		try {
			model.put("reporte1", enrollmentService.Reporte1());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "enrollments/report-enrollment";
	}

}
