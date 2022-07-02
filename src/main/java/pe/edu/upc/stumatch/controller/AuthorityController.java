package pe.edu.upc.stumatch.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.stumatch.business.crud.AuthorityService;
import pe.edu.upc.stumatch.business.crud.UserService;
import pe.edu.upc.stumatch.model.entity.Authority;

@Controller
@SessionAttributes
@RequestMapping("/authorities")
public class AuthorityController {
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private AuthorityService authorityService;
	
	/*
	@GetMapping("/new")
	public String newAuthority(Model model) {
		Authority authority = new Authority();
		model.addAttribute("authority", authority);
		try {
			List<Authority> authoritys = authorityService.getAll();
			model.addAttribute("authoritys", authoritys);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "role/role";
	}
	
	@PostMapping("savenew")
	public String saveAuthority(Model model, @ModelAttribute("authority") Authority authority) {
		try {
			Authority authoritySaved = authorityService.create(authority);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/students";
	}
	*/
	
	
	
	@GetMapping("/new")
	public String newRole(Model model) {
		model.addAttribute("authority", new Authority());
		model.addAttribute("listaUsuarios", uService.list());
		return "role/role";
	}

	@PostMapping("/save")
	public String saveRole(@Valid Authority authority, BindingResult result, Model model, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			return "role/listRole";
		} else {
			//authority.setAuthority("ROLE_STUDENT");
			authorityService.insert(authority);
		

			model.addAttribute("mensaje", "Se guardó correctamente");
			status.setComplete();

		}
		model.addAttribute("listaRoles", authorityService.list());

		return "role/listRole";

	}

	@GetMapping("/list")
	public String listRole(Model model) {
		try {
			model.addAttribute("role", new Authority());
			model.addAttribute("listaRoles", authorityService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "role/listRole";
	}
	
}
