package ar.edu.unju.fi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursales;

@Controller
@RequestMapping("/sucursales")
public class sucursalesController {

	ListaSucursal listaSucursales = new ListaSucursal();
	
	@GetMapping("/listado")
	public String getSucursalesPage(Model model) {
		model.addAttribute("sucursales", listaSucursales.getSucursal()); 
		return "sucursales";
	}

	
	@GetMapping("/nuevo")
		public String getNuevaSucursal(Model model) {	
			boolean editar= false;
			
			model.addAttribute("sucursal",new Sucursales());
			model.addAttribute("editar", editar);
			
			return "nueva_sucursal";
		}
	
	@PostMapping("/guardar")
		public ModelAndView getGuardarSucursal(@ModelAttribute("sucursal")Sucursales sucursal) {
			ModelAndView modelView = new ModelAndView("sucursales");
			listaSucursales.getSucursal().add(sucursal);
			modelView.addObject("sucursales",listaSucursales.getSucursal());
			return modelView;
		}
	
	@GetMapping("/editar/{nombre}")
	 public String getEditarSucursal(Model model,@PathVariable(value="nombre")String nombre) {
		Sucursales posicionSucursal = new Sucursales();
		boolean editar = true;
		for (Sucursales sucu: listaSucursales.getSucursal()) {
			if(sucu.getNombre().equals(nombre)) {
				posicionSucursal = sucu;
				break;
				
			}
		}
		model.addAttribute("sucursal", posicionSucursal);
		model.addAttribute("editar",editar);
		return "nueva_sucursal";
	}
	
	@PostMapping("/editar")
	public String editarSucursal(@ModelAttribute("sucursal")Sucursales sucursal) {
		for(Sucursales sucu: listaSucursales.getSucursal()) {
			if(sucu.getNombre().equals(sucursal.getNombre())) {
				
				sucu.setCorreo(sucursal.getCorreo());
				sucu.setDireccion(sucursal.getDireccion());
				sucu.setFecha(sucursal.getFecha());
				sucu.setProvincia(sucursal.getProvincia());
				sucu.setTelefono(sucursal.getTelefono());
				
				
			}
		}
		return "redirect:/sucursales/listado";
	}
	@GetMapping("/eliminar/{nombre}")
		public String eliminarSucursal(@PathVariable(value="nombre")String nombre) {
		for(Sucursales sucu: listaSucursales.getSucursal()) {
			if(sucu.getNombre().equals(nombre)) {
				listaSucursales.getSucursal().remove(sucu);
				break;
			}
		}
			return "redirect:/sucursales/listado";
		}
}