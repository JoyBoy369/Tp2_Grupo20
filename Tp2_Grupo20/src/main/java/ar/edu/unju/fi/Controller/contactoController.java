package ar.edu.unju.fi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaContacto;
import ar.edu.unju.fi.model.Contacto;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/contacto")
public class contactoController {

	@Autowired
	private ListaContacto listaContacto;
	@Autowired
	private Contacto contacto;
	
	//Peticion que retorna el listado de los Contactos//
	@GetMapping("/listado")
	public String getContactosPage(Model model) {
		model.addAttribute("contacto", listaContacto.getContacto()); 
		return "contacto";
	}

	//Retorma un formulario para guardar un nuevo Contacto//
	@GetMapping("/nuevo")
		public String getNuevaSucursal(Model model) {	
			boolean editar= false;
			
			model.addAttribute("contacto", contacto);
			model.addAttribute("editar", editar);
			
			return "nuevo_contacto";
		}
	//Metodo post que se ejecuta despues de hacer un submid en un nuevo coctacto//
	@PostMapping("/guardar")
		public ModelAndView getGuardarContacto(@Valid @ModelAttribute("contacto")Contacto contacto, BindingResult result) {
			ModelAndView modelView = new ModelAndView("contacto");
			if(result.hasErrors()) {
				modelView.setViewName("nuevo_contacto");
				modelView.addObject("contacto", contacto);
				return modelView;
			}
			listaContacto.getContacto().add(contacto);
			modelView.addObject("contacto",listaContacto.getContacto());
			return modelView;
		}
	//Metodo que permite devolver la posicion y objetos del Array tomando como atributo de busqueda el Nombre//
	@GetMapping("/editar/{nombre}")
	 public String getEditarContacto(Model model,@PathVariable(value="nombre")String nombre) {
		Contacto posicionContacto = new Contacto();
		boolean editar = true;
		for (Contacto contac: listaContacto.getContacto()) {
			if(contac.getNombre().equals(nombre)) {
				posicionContacto = contac;
				break;
				
			}
		}
		model.addAttribute("contacto", posicionContacto);
		model.addAttribute("editar",editar);
		return "nuevo_contacto";
	}
	
	//Metodo que se lanza cuando el usuario actualiza los datos de una tabla//
	@PostMapping("/editar")
	public String editarContacto(@Valid @ModelAttribute("contacto")Contacto contacto, BindingResult result, Model model) {
		if(result.hasErrors()) {
			boolean editar=true;
			model.addAttribute("editar", editar);
			return "nuevo_contacto";
		}
		for(Contacto contac: listaContacto.getContacto()) {
			if(contac.getNombre().equals(contacto.getNombre())) {
				
				contac.setCorreo(contacto.getCorreo());
				contac.setCiudad(contacto.getCiudad());
				contac.setMensaje(contacto.getMensaje());
				
				
			}
		}
		return "redirect:/contacto/listado";
	}
	//Permite eliminar completamente un objeto de la tabla//
	@GetMapping("/eliminar/{nombre}")
		public String eliminarContacto(@PathVariable(value="nombre")String nombre) {
		for(Contacto contac: listaContacto.getContacto()) {
			if(contac.getNombre().equals(nombre)) {
				listaContacto.getContacto().remove(contac);
				break;
			}
		}
			return "redirect:/contacto/listado";
		}

}
