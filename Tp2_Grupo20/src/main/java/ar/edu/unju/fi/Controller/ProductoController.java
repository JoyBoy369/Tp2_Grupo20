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

import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.model.Productos;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/producto")

public class ProductoController {
	@Autowired
	ListaProducto listaProductos;
	@Autowired
	private Productos producto;
	
	//Peticion que retorna el listado de los Productos//
	@GetMapping("/listado")
	public String getListaProductoPage(Model model) {
		model.addAttribute("productos", listaProductos.getProductos());
		return "productos";
		
	}
	//Retorma un formulario para guardar un nuevo Producto//
	@GetMapping("/nuevo")
	public String getNuevoProductoPage(Model model) {
		boolean edicion=false;
		model.addAttribute("producto", producto);
		model.addAttribute("edicion",edicion);
		return "nuevo_producto";
	}
	
	//Metodo post que se ejecuta despues de hacer un submid en un nuevo producto//
	@PostMapping("/guardar")
	public ModelAndView getGuardarProductoPage(@Valid @ModelAttribute("producto")Productos producto,BindingResult resultado) {
	ModelAndView modelView = new ModelAndView("productos");
	if (resultado.hasErrors()) {
		modelView.setViewName("nuevo_producto");
		modelView.addObject("producto",producto);
		return modelView;
				
	}
		
	listaProductos.getProductos().add(producto);
	modelView.addObject("productos",listaProductos.getProductos());
	return modelView;
	
	}
	
	//Metodo que permite devolver la posicion y objetos del Array tomando como atributo de busqueda el Codigo//
	@GetMapping("/editar/{codigo}")
	public String getEditarProductoPage(Model model, @PathVariable(value="codigo")String codigo) {
		Productos productoEncontrado = new Productos();
		boolean edicion=true;
		for(Productos prod : listaProductos.getProductos()) {
			if(prod.getCodigo()==(Integer.parseInt(codigo))) {
				productoEncontrado = prod;
				break;
			}
		}
		model.addAttribute("producto",productoEncontrado);
		model.addAttribute("edicion",edicion);
		
		return "nuevo_producto";
	}
	
	//Metodo que se lanza cuando el usuario actualiza los datos de una tabla//
	@PostMapping("/editar")
	public String editarProducto(@Valid @ModelAttribute("producto")Productos producto, BindingResult resultado,Model model) {
		if (resultado.hasErrors()) {
			boolean editar=true;
			model.addAttribute("editar",editar);
			return "nuevo_producto";
		}
		for(Productos prod : listaProductos.getProductos()) {
			if(prod.getCodigo()==(producto.getCodigo())) {
				
				prod.setNombre(producto.getNombre());
				prod.setCategoria(producto.getCategoria());
				// prod.setCodigo(producto.getCodigo());
				prod.setPrecio(producto.getPrecio());
				prod.setDescuento(producto.getDescuento());
			}
		}
		return "redirect:/producto/listado";
	}
	
	
	//Permite eliminar completamente un objeto de la tabla//
	@GetMapping("/eliminar/{codigo}")
	public String eliminarProducto(@PathVariable(value="codigo")String codigo) {
		Productos productoBuscado = new Productos();
		for(Productos prod : listaProductos.getProductos()) {
			if(prod.getCodigo()==Integer.parseInt(codigo)) {
				productoBuscado=prod;
				break;				
			}
		}
		listaProductos.getProductos().remove(productoBuscado);
		return "redirect:/producto/listado";
	}
	
	
	
}

