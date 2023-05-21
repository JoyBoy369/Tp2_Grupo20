package ar.edu.unju.fi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.model.Servicios;




@Controller 
@RequestMapping("/servicios")
public class serviciosController {
	
	

	ListaServicio listaServicios = new ListaServicio();
	
	@GetMapping("/listado")
		public String getServiciosPage(Model model){
		model.addAttribute("servicios", listaServicios.getServicio());
		return "servicio";		
	}
	
	@GetMapping("/nuevo")
		public String getNuevoServicio(Model model) {
			boolean editar = false;

			model.addAttribute("servicio",new Servicios());
			model.addAttribute("editar", editar);
			
			return "nuevo_servicio";
	}
	@PostMapping("/guardar")
		public ModelAndView getGuardarServicio(@ModelAttribute("servicio")Servicios servicio) {
			ModelAndView modelView = new ModelAndView("servicio");
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
		public String editarservicio(@ModelAttribute("servicio")Servicios servicio) {
		
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
