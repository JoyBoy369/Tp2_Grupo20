package ar.edu.unju.fi.Controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class indexController {
	
	@GetMapping("/inicio")
	public String getIndexPage() {
		
		return "index";
			
	}

	

}
