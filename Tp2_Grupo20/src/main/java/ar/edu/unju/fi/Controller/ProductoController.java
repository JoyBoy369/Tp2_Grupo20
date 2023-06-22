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

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

/**
 * Controlador para la gestión de productos.
 */
@Controller
@RequestMapping("/producto")

public class ProductoController {
	@Autowired
	@Qualifier("productoServiceImp")
	private IProductoService productoService;
	
	@Autowired
	Producto producto;
	
	
	/**
	 * Mapeo para obtener la página de listado de productos.
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "productos"
	 */
	@GetMapping("/listado")
	public String getListaProductoPage(Model model) {
		List<Producto> listaProductos= productoService.getLista();
		model.addAttribute("producto",listaProductos);
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
	public ModelAndView getGuardarProductoPage(@Valid @ModelAttribute("producto")Producto producto,BindingResult resultado) {
	ModelAndView modelView = new ModelAndView("productos");
	if (resultado.hasErrors()) {
		modelView.setViewName("nuevo_producto");
		modelView.addObject("producto",producto);
		return modelView;
				
	}
	producto.setEstado(true);
	productoService.guardar(producto);
	modelView.setViewName("productos");
	modelView.addObject("producto", productoService.getLista());
	
	return modelView;
	
	}
	
	/**
	 * Mapeo para obtener la página de edición de un producto.
	 * @param model el modelo de la vista
	 * @param codigo el codigo del producto a editar
	 * @return el nombre de la vista "nuevo_producto"
	 */
	@GetMapping("/editar/{id}")
	public ModelAndView getEditarProductoPage(Model model, @PathVariable(value="id")Long id) {
		ModelAndView modelView= new ModelAndView("nuevo_producto");
	    Producto productoEncontrado = productoService.getBy(id);
	    boolean edicion=true;
		modelView.addObject("producto",productoEncontrado);
		modelView.addObject("edicion",edicion);
		return modelView;
		
	}
	
	/**
	 * Mapeo para guardar los cambios de un producto editado.
	 * @param producto el producto editado.
	 * @param resultado el resultado de la validación
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "nuevo_producto" si hay errores, o "redirect:/producto/listado" en caso contrario
	 */
	@PostMapping("/editar")
	public String editarProducto(@Valid @ModelAttribute("producto")Producto producto, BindingResult resultado,Model model) {
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
	@GetMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable(value="id")Long id) {
		Producto productoBuscado = productoService.getBy(id);
		productoService.eliminar(productoBuscado);
		return "redirect:/producto/listado";
	}
	
	
	
}

