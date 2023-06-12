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
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

/**
 * Controlador para la gestión de productos.
 */
@Controller
@RequestMapping("/producto")

public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	ListaProducto listaProducto;
	
	/**
	 * Mapeo para obtener la página de listado de productos.
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "productos"
	 */
	@GetMapping("/listado")
	public String getListaProductoPage(Model model) {
		model.addAttribute("productos", productoService.getLista());
		return "productos";
		
	}
	
	/**
	 * Mapeo para obtener la página de creación de un nuevo producto.
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "nuevo_producto"
	 */
	@GetMapping("/nuevo")
	public String getNuevoProductoPage(Model model) {
		boolean edicion=false;
		model.addAttribute("producto", productoService.getProducto());
		model.addAttribute("edicion",edicion);
		return "nuevo_producto";
	}
	
	/**
	 * Mapeo para guardar un nuevo producto.
	 * @param producto el producto a guardar
	 * @param resultado el resultado de la validación
	 * @return el objeto ModelAndView de la vista "producto" si no hay errores, o "nuevo_producto" en caso contrario
	 */
	@PostMapping("/guardar")
	public ModelAndView getGuardarProductoPage(@Valid @ModelAttribute("producto")Productos producto,BindingResult resultado) {
	ModelAndView modelView = new ModelAndView("productos");
	if (resultado.hasErrors()) {
		modelView.setViewName("nuevo_producto");
		modelView.addObject("producto",producto);
		return modelView;
				
	}
	productoService.guardar(producto);
	modelView.addObject("productos", productoService.getLista());
	return modelView;
	
	}
	
	/**
	 * Mapeo para obtener la página de edición de un producto.
	 * @param model el modelo de la vista
	 * @param codigo el codigo del producto a editar
	 * @return el nombre de la vista "nuevo_producto"
	 */
	@GetMapping("/editar/{codigo}")
	public String getEditarProductoPage(Model model, @PathVariable(value="codigo")String codigo) {
		Productos productoEncontrado = productoService.getBy(codigo);
		boolean edicion=true;
		model.addAttribute("producto",productoEncontrado);
		model.addAttribute("edicion",edicion);
		
		return "nuevo_producto";
	}
	
	/**
	 * Mapeo para guardar los cambios de un producto editado.
	 * @param producto el producto editado.
	 * @param resultado el resultado de la validación
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "nuevo_producto" si hay errores, o "redirect:/producto/listado" en caso contrario
	 */
	@PostMapping("/editar")
	public String editarProducto(@Valid @ModelAttribute("producto")Productos producto, BindingResult resultado,Model model) {
		if (resultado.hasErrors()) {
			boolean editar=true;
			model.addAttribute("editar",editar);
			return "nuevo_producto";
		}
		productoService.modificar(producto);
		return "redirect:/producto/listado";
	}
	
	
	/**
	 * Mapeo para eliminar un producto.
	 * @param nombre el nombre del producto a eliminar.
	 * @return el nombre de la vista "redirect:/producto/listado"
	 */
	@GetMapping("/eliminar/{codigo}")
	public String eliminarProducto(@PathVariable(value="codigo")String codigo) {
		Productos productoBuscado = productoService.getBy(codigo);
		productoService.eliminar(productoBuscado);
		return "redirect:/producto/listado";
	}
	
	
	
}

