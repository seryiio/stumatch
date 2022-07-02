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
import pe.edu.upc.stumatch.model.entity.Career;

@Controller
@RequestMapping("/careers")
@SessionAttributes("{career}")
public class CareerController {
	@Autowired
	private CareerService careerService;

	@GetMapping	
	public String listCareers(Model model) {
		
		try {
			List<Career> careers = careerService.getAll();
			model.addAttribute("careers", careers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "careers/list-careers";
	}
	
	@GetMapping("new")
	public String newCareer(Model model) {
		Career career = new Career();
		model.addAttribute("career", career);
		try {
			List<Career> careers = careerService.getAll();
			model.addAttribute("careers", careers);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "careers/new-career";
	}
	
	@PostMapping("savenew")
	public String saveCareer(@Valid @ModelAttribute("career") Career career, BindingResult result, Model model) {
		try {
			if(result.hasErrors())
			{
				return "careers/new-career";
			}
			Career careerSaved = careerService.create(career);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/careers";
	}
	
	@GetMapping("{id}/edit")
	public String editCareer(Model model, @PathVariable("id") String id) {
			try {
				if(careerService.existById(id)) {
					Optional<Career> optional = careerService.findById(id);
					model.addAttribute("career", optional.get());
				} else {
					return "redirect:/careers";
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "careers/edit-career";
	}
	
	@PostMapping("{id}/update")
	public String updateCareer(Model model, @ModelAttribute("career") Career career, @PathVariable("id") String id) {
		try {
			if(careerService.existById(id)) {
				careerService.update(career);
			} else {
				return "redirect:/careers";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/careers";
	}
	
	@GetMapping("{id}/delete")
	public String deleteCareer(Model model, @PathVariable("id") String id) {
		try {
			if(careerService.existById(id)) {
				careerService.deleteById(id);
			} else {
				return "redirect:/careers";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/careers";
	}
}
