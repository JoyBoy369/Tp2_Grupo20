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

import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

/**
 * Controlador para la gestión de sucursales.
 */
@Controller
@RequestMapping("/sucursales")
public class SucursalController {
	
	@Autowired
	private ISucursalService sucursalService;
	
	@Autowired
	ListaSucursal listaSucursales;
	
	/**
	 * Mapeo para obtener la página de listado de sucursales.
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "sucursales"
	 */
	@GetMapping("/listado")
	public String getSucursalesPage(Model model) {
		model.addAttribute("sucursales", sucursalService.getLista()); 
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
		sucursalService.guardar(sucursal);
		modelView.addObject("sucursales", sucursalService.getLista());
		return modelView;
	}
	
	/**
	 * Mapeo para obtener la página de edición de una sucursal.
	 * @param model el modelo de la vista
	 * @param nombre el nombre de la sucursal a editar
	 * @return el nombre de la vista "nueva_sucursal"
	 */
	@GetMapping("/editar/{nombre}")
	public String getEditarSucursal(Model model, @PathVariable(value = "nombre") String nombre) {
		Sucursal sucursalEncontrada = sucursalService.getBy(nombre);
		boolean editar = true;
		model.addAttribute("sucursal", sucursalEncontrada);
		model.addAttribute("editar", editar);
		return "nueva_sucursal";
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
	@GetMapping("/eliminar/{nombre}")
	public String eliminarSucursal(@PathVariable(value = "nombre") String nombre) {
		Sucursal sucursalEncontrada = sucursalService.getBy(nombre);
		sucursalService.eliminar(sucursalEncontrada);
		return "redirect:/sucursales/listado";
	}
}