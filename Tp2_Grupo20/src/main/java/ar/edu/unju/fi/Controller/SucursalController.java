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

import ar.edu.unju.fi.entity.Sucursal;

import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

/**
 * Controlador para la gestión de sucursales.
 */
@Controller
@RequestMapping("/sucursales")
public class SucursalController {
	
	@Autowired
	@Qualifier("sucursalServiceImp")
	private ISucursalService sucursalService;
	
	@Autowired
	Sucursal sucursal;
	
	
	/**
	 * Mapeo para obtener la página de listado de sucursales.
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "sucursales"
	 */
	@GetMapping("/listado")
	public String getSucursalesPage(Model model) {
		List<Sucursal> listaSucursales = sucursalService.getLista();
		model.addAttribute("sucursal", listaSucursales);
		return "sucursales";
	}

	/**
	 * Mapeo para obtener la página de creación de una nueva sucursal.
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "nueva_sucursal"
	 */
	@GetMapping("/nuevo")
	public String getNuevaSucursal(Model model) {	
		boolean editar = false;
		
		model.addAttribute("sucursal", sucursalService.getSucursal());
		model.addAttribute("editar", editar);
		return "nueva_sucursal";
	}
	
	/**
	 * Mapeo para guardar una nueva sucursal.
	 * @param sucursal la sucursal a guardar
	 * @param resultado el resultado de la validación
	 * @return el objeto ModelAndView de la vista "sucursales" si no hay errores, o "nueva_sucursal" en caso contrario
	 */
	
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursal(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult resultado) {
		ModelAndView modelView = new ModelAndView("sucursales");
		if (resultado.hasErrors()) {
			modelView.setViewName("nueva_sucursal");
			modelView.addObject("sucursal", sucursal);
			return modelView;
		}
		
		
		sucursal.setEstado(true);
		sucursalService.guardar(sucursal);
	
		modelView.setViewName("sucursales");
		modelView.addObject("sucursal", sucursalService.getLista());
		return modelView;
	}
	
	
	
	
	
	/**
	 * Mapeo para obtener la página de edición de una sucursal.
	 * @param model el modelo de la vista
	 * @param nombre el nombre de la sucursal a editar
	 * @return el nombre de la vista "nueva_sucursal"
	 */
	
	
	
	@GetMapping("/editar/{id}")
	public ModelAndView getEditarSucursal(Model model, @PathVariable(value = "id") Long id) {
		
		ModelAndView modelView = new ModelAndView("nueva_sucursal");
		
		Sucursal sucursalEncontrada = sucursalService.getBy(id);
		boolean editar = true;
		modelView.addObject("sucursal", sucursalEncontrada);
		modelView.addObject("editar", editar);
		return modelView;
	}
	/**
	 * Mapeo para guardar los cambios de una sucursal editada.
	 * @param sucursal la sucursal editada
	 * @param resultado el resultado de la validación
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "nueva_sucursal" si hay errores, o "redirect:/sucursales/listado" en caso contrario
	 */
	@PostMapping("/editar")
	public String editarSucursal(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult resultado, Model model) {
		if (resultado.hasErrors()) {
			boolean editar = true;
			model.addAttribute("editar", editar);
			return "nueva_sucursal";
		}
		
		sucursalService.modificar(sucursal);
		return "redirect:/sucursales/listado";
	}
	
	/**
	 * Mapeo para eliminar una sucursal.
	 * @param nombre el nombre de la sucursal a eliminar
	 * @return el nombre de la vista "redirect:/sucursales/listado"
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminarSucursal(@PathVariable(value = "id") Long id) {
		Sucursal sucursalEncontrada = sucursalService.getBy(id);
		sucursalService.eliminar(sucursalEncontrada);
		return "redirect:/sucursales/listado";
	}
}