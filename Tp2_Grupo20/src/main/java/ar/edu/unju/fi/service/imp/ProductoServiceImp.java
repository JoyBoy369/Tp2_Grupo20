package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

/**
 * Implementación de la interfaz IProductoService.
 * Maneja las operaciones de gestión de productos.
 */
@Service("productoServiceImp")
public class ProductoServiceImp implements IProductoService {
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	ListaProducto listaProductos;
	@Autowired
	private Producto producto;
	
	 /**
     * Obtiene una lista de todos los productos.
     *
     * @return la lista de productos
     */
	@Override
	public List<Producto> getLista() {
		return productoRepository.findByEstado(true);
	}
	
    /**
     * Obtiene el producto actual.
     *
     * @return el producto actual
     */
	@Override
	public Producto getProducto() {
		return producto;
	}
	
	 /**
     * Guarda una nuevo producto.
     *
     * @param producto el producto a guardar
     */
	@Override
	public void guardar(@Valid Producto producto) {
		productoRepository.save(producto);
		
	}
	
    /**
     * Modifica un producto existente.
     *
     * @param producto el producto actualizado.
     */
	@Override
	public void modificar(@Valid Producto producto) {
		producto.setEstado(true);
		productoRepository.save(producto);
		
	}
	
    /**
     * Elimina un producto.
     *
     * @param productoEncontrado el producto a eliminar.
     */
	@Override
	public void eliminar(Producto productoEncontrado) {
		productoEncontrado.setEstado(false);
		productoRepository.save(productoEncontrado);
		
	}
	
    /**
     * Obtiene un producto específico por su codigo.
     *
     * @param codigo el codigo del producto.
     * @return el producto con el codigo especificado.
     */
	@Override
	public Producto getBy(Long id) {
		
		
		return productoRepository.findById(id).get();
	}
	
	
}
