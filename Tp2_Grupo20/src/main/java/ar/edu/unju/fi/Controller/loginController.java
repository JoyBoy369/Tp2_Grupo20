package ar.edu.unju.fi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.listas.FormLogin;


@Controller

public class loginController {
	@GetMapping("/")
	public String getLoginpage(Model model) {
		
		FormLogin formLogin = new FormLogin();
		model.addAttribute("formLogin",formLogin); 		
		return "login";
	}
	
	@PostMapping("/login/entrar")
	public String validarLogin(Model model,FormLogin formLogin) {
		if(formLogin.getUsuario().equals("admin")&& formLogin.getClave().equals("admin")) {
			return "index";
		}
		else
			
			model.addAttribute("error","Acceso Denegado, Usuario no valido");
			return "login";
	}
}
