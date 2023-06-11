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

import ar.edu.unju.fi.model.Servicios;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;



/**
 * Controlador para la gestión de servicios.
 */
@Controller 
@RequestMapping("/servicios")
public class ServicioController {
	
	@Autowired
	private IServicioService servicioService;
	
	
	/**
	 * Mapeo para obtener la página de listado de servicios.
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "servicio"
	 */
	@GetMapping("/listado")
		public String getServiciosPage(Model model){
		model.addAttribute("servicios", servicioService.getListaServicio());
		return "servicio";		
	}
	
	/**
	 * Mapeo para obtener la página de creación de una nuevo servicio.
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "nuevo_servicio"
	 */
	@GetMapping("/nuevo")
		public String getNuevoServicio(Model model) {
			boolean editar = false;

			model.addAttribute("servicio", servicioService.getServicio());
			model.addAttribute("editar", editar);
			
			return "nuevo_servicio";
	}
	
	/**
	 * Mapeo para guardar un nuevo servicio.
	 * @param servicio el servicio a guardar
	 * @param resultado el resultado de la validación
	 * @return el objeto ModelAndView de la vista "servicio" si no hay errores, o "nuevo_servicio" en caso contrario
	 */
	@PostMapping("/guardar")
		public ModelAndView getGuardarServicio(@Valid @ModelAttribute("servicio")Servicios servicio,BindingResult resultado) {
			ModelAndView modelView = new ModelAndView("servicio");
			if(resultado.hasErrors()) {
				modelView.setViewName("nuevo_servicio");
				modelView.addObject("servicio",servicio);
				return modelView;
			}
			servicioService.guardar(servicio);
			modelView.addObject("servicios",servicioService.getListaServicio());
			return modelView;		
	}
	/**
	 * Mapeo para obtener la página de edición de un servicio.
	 * @param model el modelo de la vista
	 * @param id el id del servicio a editar
	 * @return el nombre de la vista "nuevo_servicio"
	 */
	@GetMapping("/editar/{id}")
		public String getEditarServicio(Model model,@PathVariable(value="id")String id) {
		
		Servicios posicionServicio = servicioService.getBy(id);
		boolean editar =true;
		model.addAttribute("servicio", posicionServicio);
		model.addAttribute("editar",editar);
		return "nuevo_servicio";
	}
	
	/**
	 * Mapeo para guardar los cambios de un servicio editado.
	 * @param servicio el servicio editado
	 * @param resultado el resultado de la validación
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "nuevo_servicio" si hay errores, o "redirect:/servicios/listado" en caso contrario
	 */
	@PostMapping("/editar")
		public String editarservicio(@Valid @ModelAttribute("servicio")Servicios servicio,BindingResult resultado, Model model) {
		if(resultado.hasErrors()) {
			boolean editar = true;
			model.addAttribute("editar",editar);
			return "nuevo_servicio";
		}
		servicioService.modificar(servicio);
		return "redirect:/servicios/listado";
	}
	
	/**
	 * Mapeo para eliminar un servicio.
	 * @param id el id del servicio a eliminar
	 * @return el id de la vista "redirect:/servicios/listado"
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminarServicio(@PathVariable(value="id")String id) {
		Servicios servicioEncontrado = servicioService.getBy(id);
		servicioService.eliminar(servicioEncontrado);
		return "redirect:/servicios/listado";
	}
}
