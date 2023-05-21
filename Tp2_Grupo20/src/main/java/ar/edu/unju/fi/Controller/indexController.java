package ar.edu.unju.fi.Controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class indexController {
	
	@GetMapping("/inicio")
	public String getIndexPage() {
		
		return "index";
			
	}

	

}
