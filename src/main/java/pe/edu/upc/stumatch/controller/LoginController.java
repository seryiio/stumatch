package pe.edu.upc.stumatch.controller;


import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class LoginController {

	@GetMapping(value = { "/login", "/" })
	public String login(@RequestParam(value = "sidebar", required = false) String sidebar,
			@RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
			RedirectAttributes flash) {

		if (principal != null) {
			return "redirect:/main";
		}

		if (sidebar != null) {
			model.addAttribute("error",
					"Error en el login: Nombre de usuario o contrasena incorrecta, por favor vuelva a intentarlo!");
		}

		if (logout != null) {
			model.addAttribute("success", "Ha cerrado sesion con exito!");
		}

		return "login";
	}
	
}

