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

import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.model.Servicios;
import jakarta.validation.Valid;




@Controller 
@RequestMapping("/servicios")
public class serviciosController {
	
	
	@Autowired	
	ListaServicio listaServicios;
	
	@Autowired
	private Servicios servicio;
	
	@GetMapping("/listado")
		public String getServiciosPage(Model model){
		model.addAttribute("servicios", listaServicios.getServicio());
		return "servicio";		
	}
	
	@GetMapping("/nuevo")
		public String getNuevoServicio(Model model) {
			boolean editar = false;

			model.addAttribute("servicio",servicio);
			model.addAttribute("editar", editar);
			
			return "nuevo_servicio";
	}
	@PostMapping("/guardar")
		public ModelAndView getGuardarServicio(@Valid @ModelAttribute("servicio")Servicios servicio,BindingResult resultado) {
			ModelAndView modelView = new ModelAndView("servicio");
			if(resultado.hasErrors()) {
				modelView.setViewName("nuevo_servicio");
				modelView.addObject("servicio",servicio);
				return modelView;
			}
			listaServicios.getServicio().add(servicio);
			modelView.addObject("servicios",listaServicios.getServicio());
			return modelView;		
	}
	
	@GetMapping("/editar/{id}")
		public String getEditarServicio(Model model,@PathVariable(value="id")String id) {
		
		Servicios posicionServicio = new Servicios();
		boolean editar =true;
		for (Servicios serv: listaServicios.getServicio()) {
			if(serv.getId().equals(id)) {
				posicionServicio = serv;
				break;
				
			}
		}
		model.addAttribute("servicio", posicionServicio);
		model.addAttribute("editar",editar);
		return "nuevo_servicio";
	}
	
	@PostMapping("/editar")
		public String editarservicio(@Valid @ModelAttribute("servicio")Servicios servicio,BindingResult resultado, Model model) {
		if(resultado.hasErrors()) {
			boolean editar = true;
			model.addAttribute("editar",editar);
			return "nuevo_servicio";
		}
		for(Servicios serv: listaServicios.getServicio()) {
			if(serv.getId().equals(servicio.getId())) {
				
				serv.setNombre(servicio.getNombre());
				serv.setLunes(servicio.getLunes());
				serv.setMartes(servicio.getMartes());
				serv.setMiercoles(servicio.getMiercoles());
				serv.setJueves(servicio.getJueves());
				serv.setViernes(servicio.getViernes());
					
				break;
			}
		}
		return "redirect:/servicios/listado";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarServicio(@PathVariable(value="id")String id) {
	for(Servicios serv: listaServicios.getServicio()) {
		if(serv.getId().equals(id)) {
			listaServicios.getServicio().remove(serv);
			break;
		}
	}
		return "redirect:/servicios/listado";
	}
}
