package ar.edu.unju.fi.Controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class IndexController {
	
	//Metodo ue devuelve la pagina index luego de ingresar por primera vez//
	@GetMapping("/inicio")
	public String getIndexPage() {
		
		return "index";
			
	}

	

}
