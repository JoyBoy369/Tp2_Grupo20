package ar.edu.unju.fi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Consejo;

import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

/**
 * Controlador para la gestión de consejos.
 */
@Controller
@RequestMapping("/consejos")
public class ConsejoController {
	
	@Autowired
	Consejo consejo;
	
	@Autowired
	@Qualifier("consejoServiceImp")
	private IConsejoService consejoService;
	
	
	
	/**
	 * Mapeo para obtener la página de listado de consejos.
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "consejos"
	 */
	@GetMapping("/listado")
	public String getConsejosPage(Model model) {
		List<Consejo> listaConsejos = consejoService.getLista();
		model.addAttribute("consejos", listaConsejos);
		return "consejos";
	}
	
	
	/**
	 * Mapeo para obtener la página de creación de un nuevo consejo.
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "Nuevo_Consejo"
	 */
	@GetMapping("/nuevo_consejo")
	public String getNuevoConsejo(Model model){
		boolean editar = false;
		model.addAttribute("consejo", consejoService.getConsejo());
		model.addAttribute("editar", editar);
		return "nuevo_consejo";
	}
	
	/**
	 * Mapeo para guardar un nuevo consejo.
	 * @param el consejo a guardar
	 * @param resultado el resultado de la validación
	 * @return el objeto ModelAndView de la vista "consejos" si no hay errores, o "Nuevo_Consejo" en caso contrario
	 */
	@PostMapping("/guardar_consejo")
	public ModelAndView getGuardarConsejo(@Valid @ModelAttribute("consejo")Consejo consejo, BindingResult resultado){
		ModelAndView modelView = new ModelAndView("consejos");
		if(resultado.hasErrors()) {
			modelView.setViewName("nuevo_consejo");
			modelView.addObject("consejo", consejo);
			return modelView;
		}
		consejo.setEstado(true);
		consejoService.guardar(consejo);
		modelView.setViewName("consejos");
		modelView.addObject("consejos", consejoService.getLista());
		return modelView;
	}
	
	/**
	 * Mapeo para obtener la página de edición de un consejo.
	 * @param model el modelo de la vista
	 * @param nombre el nombre del consejo a editar
	 * @return el nombre de la vista "Nuevo_Consejo"
	 */
	@GetMapping("/editar/{id}")
	public ModelAndView getEditarConsejo(Model model,@PathVariable(value = "id")Long id) {
		
		ModelAndView modelView = new ModelAndView("nuevo_consejo");
		
		Consejo consejoEncontrado = consejoService.getBy(id);
		boolean editar = true;
		
		modelView.addObject("consejo", consejoEncontrado);
		modelView.addObject("editar", editar);
		return modelView;
	}
	
	/**
	 * Mapeo para guardar los cambios de un consejo editado.
	 * @param consejo el consejo editado
	 * @param resultado el resultado de la validación
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "Nuevo_Consejo" si hay errores, o "redirect:/sucursales/listado" en caso contrario
	 */
	@PostMapping("/editar")
	public String editarConsejo(@Valid @ModelAttribute("consejo")Consejo consejo, BindingResult resultado, Model model){
		if(resultado.hasErrors()){
			boolean editar = true;
			model.addAttribute("editar", editar);
			return "nuevo_consejo";
		}
		consejoService.modificar(consejo);
		return "redirect:/consejos/listado";
	}
	
	/**
	 * Mapeo para eliminar un consejo.
	 * @param nombre el nombre del consejo a eliminar
	 * @return el nombre de la vista "redirect:/consejos/listado"
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminarConsejo(@PathVariable(value = "id")Long id){
		Consejo consejoEncontrado = consejoService.getBy(id);
		consejoService.eliminar(consejoEncontrado);
		return "redirect:/consejos/listado";
	}
}
