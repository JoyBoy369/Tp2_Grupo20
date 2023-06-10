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
import ar.edu.unju.fi.model.Sucursales;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sucursales")
public class SucursalesController {

	@Autowired
	ListaSucursal listaSucursales;
	@Autowired
	private Sucursales sucursal;
	
	
	//Peticion que retorna el listado de las Sucursales//
	@GetMapping("/listado")
	public String getSucursalesPage(Model model) {
		model.addAttribute("sucursales", listaSucursales.getSucursal()); 
		return "sucursales";
	}

	//Retorma un formulario para guardar una nueva Sucursal//
	@GetMapping("/nuevo")
		public String getNuevaSucursal(Model model) {	
			boolean editar= false;
			
			model.addAttribute("sucursal",sucursal);
			model.addAttribute("editar", editar);
			
			return "nueva_sucursal";
		}
	//Metodo post que se ejecuta despues de hacer un submid en una nueva sucursal//
	@PostMapping("/guardar")
		public ModelAndView getGuardarSucursal(@Valid @ModelAttribute("sucursal")Sucursales sucursal,BindingResult resultado) {
			ModelAndView modelView = new ModelAndView("sucursales");
			if(resultado.hasErrors()) {
				modelView.setViewName("nueva_sucursal");
				modelView.addObject("sucursal",sucursal);
				return modelView;
			}
			
			listaSucursales.getSucursal().add(sucursal);
			modelView.addObject("sucursales",listaSucursales.getSucursal());
			return modelView;
		}
	//Metodo que permite devolver la posicion y objetos del Array tomando como atributo de busqueda el Titulo//
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
	
	
	//Metodo que se lanza cuando el usuario actualiza los datos de una tabla//
	@PostMapping("/editar")
	public String editarSucursal(@Valid @ModelAttribute("sucursal")Sucursales sucursal,BindingResult resultado,Model model) {

		if(resultado.hasErrors()) {
			boolean editar = true;
			model.addAttribute("editar",editar);
			return "nueva_sucursal";
		}
		
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
	
	//Permite eliminar completamente un objeto de la tabla//
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