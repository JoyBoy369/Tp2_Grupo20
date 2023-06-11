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

import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

/**
 * Controlador para la gestión de consejos.
 */
@Controller
@RequestMapping("/consejos")
public class ConsejoController {
	
	@Autowired
	ListaConsejo listaConsejos;
	@Autowired
	private IConsejoService consejoService;
	
	
	
	/**
	 * Mapeo para obtener la página de listado de consejos.
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "consejos"
	 */
	@GetMapping("/listado")
	public String getConsejosPage(Model model) {
		model.addAttribute("consejos", consejoService.getLista());
		return "consejos";
	}
	
	
	/**
	 * Mapeo para obtener la página de creación de un nuevo consejo.
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "Nuevo_Consejo"
	 */
	@GetMapping("/Nuevo_Consejo")
	public String getNuevoConsejo(Model model){
		boolean editar = false;
		model.addAttribute("consejo", consejoService.getConsejo());
		model.addAttribute("editar", editar);
		return "Nuevo_Consejo";
	}
	
	/**
	 * Mapeo para guardar un nuevo consejo.
	 * @param el consejo a guardar
	 * @param resultado el resultado de la validación
	 * @return el objeto ModelAndView de la vista "consejos" si no hay errores, o "Nuevo_Consejo" en caso contrario
	 */
	@PostMapping("/Guardar_Consejo")
	public ModelAndView getGuardarConsejo(@Valid @ModelAttribute("consejo")Consejo consejo, BindingResult resultado){
		ModelAndView modelView = new ModelAndView("consejos");
		if(resultado.hasErrors()) {
			modelView.setViewName("Nuevo_Consejo");
			modelView.addObject("consejo", consejo);
			return modelView;
		}
		consejoService.guardar(consejo);
		modelView.addObject("consejos", consejoService.getLista());
		return modelView;
	}
	
	/**
	 * Mapeo para obtener la página de edición de un consejo.
	 * @param model el modelo de la vista
	 * @param nombre el nombre del consejo a editar
	 * @return el nombre de la vista "Nuevo_Consejo"
	 */
	@GetMapping("/editar/{consejo}")
	public String getEditarConsejo(Model model,@PathVariable(value = "consejo")String consejo) {
		Consejo consejoEncontrado = consejoService.getBy(consejo);
		boolean editar = true;
		model.addAttribute("consejo", consejoEncontrado);
		model.addAttribute("editar", editar);
		return "Nuevo_Consejo";
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
			return "Nuevo_Consejo";
		}
		consejoService.modificar(consejo);
		return "redirect:/consejos/listado";
	}
	
	/**
	 * Mapeo para eliminar un consejo.
	 * @param nombre el nombre del consejo a eliminar
	 * @return el nombre de la vista "redirect:/consejos/listado"
	 */
	@GetMapping("/eliminar/{titulo}")
	public String eliminarConsejo(@PathVariable(value = "titulo")String titulo){
		Consejo consejoEncontrado = consejoService.getBy(titulo);
		consejoService.eliminar(consejoEncontrado);
		return "redirect:/consejos/listado";
	}
}
