package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.model.Productos;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

/**
 * Implementación de la interfaz IProductoService.
 * Maneja las operaciones de gestión de productos.
 */
@Service
public class ProductoServiceImp implements IProductoService {
	
	@Autowired
	ListaProducto listaProductos;
	@Autowired
	private Productos producto;
	
	 /**
     * Obtiene una lista de todos los productos.
     *
     * @return la lista de productos
     */
	@Override
	public List<Productos> getLista() {
		return listaProductos.getProductos();
	}
	
    /**
     * Obtiene el producto actual.
     *
     * @return el producto actual
     */
	@Override
	public Productos getProducto() {
		return producto;
	}
	
	 /**
     * Guarda una nuevo producto.
     *
     * @param producto el producto a guardar
     */
	@Override
	public void guardar(@Valid Productos producto) {
		listaProductos.getProductos().add(producto);
		
	}
	
    /**
     * Modifica un producto existente.
     *
     * @param producto el producto actualizado.
     */
	@Override
	public void modificar(@Valid Productos producto) {
		for(Productos prod : listaProductos.getProductos()) {
			if(prod.getCodigo()==(producto.getCodigo())) {
				
				prod.setNombre(producto.getNombre());
				prod.setCategoria(producto.getCategoria());
				prod.setPrecio(producto.getPrecio());
				prod.setDescuento(producto.getDescuento());
			}
		}
	}
	
    /**
     * Elimina un producto.
     *
     * @param productoEncontrado el producto a eliminar.
     */
	@Override
	public void eliminar(Productos productoEncontrado) {
		listaProductos.getProductos().remove(producto);
	}
	
    /**
     * Obtiene un producto específico por su codigo.
     *
     * @param codigo el codigo del producto.
     * @return el producto con el codigo especificado.
     */
	@Override
	public Productos getBy(String codigo) {
		Productos productoEncontrado = null;
		for(Productos prod : listaProductos.getProductos()) {
			if(prod.getCodigo()==(Integer.parseInt(codigo))) {
				productoEncontrado = prod;
				break;
			}
		}
		return productoEncontrado;
	}
	
	
}
