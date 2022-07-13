package pe.edu.upc.stumatch.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.stumatch.business.crud.UserService;
import pe.edu.upc.stumatch.model.entity.User;

@Controller
@RequestMapping("/users")
@SessionAttributes("{user}")
public class UserController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UserService uService;

	@GetMapping("/new")
	public String newUser(Model model) {		
		model.addAttribute("user", new User());
		return "usersecurity/user";
	}


	@PostMapping("savenew")
	public String saveUser(@Valid User user, BindingResult result, Model model, SessionStatus status) throws Exception {
		
		if (result.hasErrors()) {
			return "usersecurity/user";
		} else {
			String bcryptPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(bcryptPassword);
			int rpta = uService.insert(user);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				return "usersecurity/user";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		//model.addAttribute("listaUsuarios", uService.list());

		return "redirect:/authorities/new";
		
	
	}
	
}
