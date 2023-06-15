package ar.edu.unju.fi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Contacto;
import jakarta.validation.Valid;


@Controller

public class ContactoController {

	@Autowired
	Contacto contacto;
	
	@GetMapping("/contacto") 
	public String getContacto(Model model){
	model.addAttribute( "contacto", contacto); //enviar un pbjeto a la pagina, agrega un atributo a la pagina llamada contacto
	return "contacto";
}

/**
 * @param model  modelo que se utiliza para la vista
 * @param contacto objeto que representa los datos para rellenar el formulario
 * @param result objeto que  controla las validaciones de los datos introducidos
 * @return  el retorno es la pagina contacto-form.html, vista
 */
@PostMapping("/contacto")
public ModelAndView postContacto(Model model ,@Valid @ModelAttribute(value = "contacto") Contacto contacto, BindingResult  resultado ) {
    ModelAndView modelAndView = new ModelAndView("contacto");
    if(resultado.hasErrors()) {
       
        modelAndView.setViewName("contacto");
        model.addAttribute("contacto");
        modelAndView.addObject("contacto", contacto);
        return modelAndView;
    }
    	
        model.addAttribute( "contacto", contacto); //Se envia un nuevo objeto para que se reinicie el formulario. 
        model.addAttribute("datos", "Gracias por Contactarse!");
       
        return modelAndView;
      
      

}
	
	

}
