package ar.edu.unju.fi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaContacto;
import ar.edu.unju.fi.model.Contacto;

@Controller
@RequestMapping("/contacto")
public class contactoController {

	ListaContacto listaContacto = new ListaContacto();
	
	@GetMapping("/listado")
	public String getContactosPage(Model model) {
		model.addAttribute("contacto", listaContacto.getContacto()); 
		return "contacto";
	}

	
	@GetMapping("/nuevo")
		public String getNuevaSucursal(Model model) {	
			boolean editar= false;
			
			model.addAttribute("contacto",new Contacto());
			model.addAttribute("editar", editar);
			
			return "nuevo_contacto";
		}
	
	@PostMapping("/guardar")
		public ModelAndView getGuardarContacto(@ModelAttribute("contacto")Contacto contacto) {
			ModelAndView modelView = new ModelAndView("contacto");
			listaContacto.getContacto().add(contacto);
			modelView.addObject("contacto",listaContacto.getContacto());
			return modelView;
		}
	
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
	
	@PostMapping("/editar")
	public String editarContacto(@ModelAttribute("contacto")Contacto contacto) {
		for(Contacto contac: listaContacto.getContacto()) {
			if(contac.getNombre().equals(contacto.getNombre())) {
				
				contac.setCorreo(contacto.getCorreo());
				contac.setCiudad(contacto.getCiudad());
				contac.setMensaje(contacto.getMensaje());
				
				
			}
		}
		return "redirect:/contacto/listado";
	}
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
