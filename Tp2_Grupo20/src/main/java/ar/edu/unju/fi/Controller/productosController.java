package ar.edu.unju.fi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.model.Productos;

@Controller
@RequestMapping("/producto")

public class productosController {

	ListaProducto listaProductos = new ListaProducto();
	
	
	
	@GetMapping("/listado")
	public String getListaProductoPage(Model model) {
		model.addAttribute("productos", listaProductos.getProductos());
		return "productos";
		
	}
	
	@GetMapping("/nuevo")
	public String getNuevoProductoPage(Model model) {
		boolean edicion=false;
		model.addAttribute("producto", new Productos());
		model.addAttribute("edicion",edicion);
		return "nuevo_producto";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarProductoPage(@ModelAttribute("producto")Productos producto) {
	ModelAndView modelView = new ModelAndView("productos");
	listaProductos.getProductos().add(producto);
	modelView.addObject("productos",listaProductos.getProductos());
	return modelView;
	
	}
	
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
	
	@PostMapping("/editar")
	public String editarProducto(@ModelAttribute("producto")Productos producto) {
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

