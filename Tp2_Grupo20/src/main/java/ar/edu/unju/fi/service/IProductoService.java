package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Producto;

/**
 * Esta interfaz define el contrato para gestionar objetos Producto.
 */
public interface IProductoService {
	
	 /**
     * Obtiene una lista de todos los productos.
     *
     * @return la lista de productos
     */
	List<Producto> getLista();
	

    /**
     * Obtiene el producto actual.
     *
     * @return el producto actual
     */
	Producto getProducto();
	
    /**
     * Guarda una nuevo producto.
     *
     * @param producto el producto a guardar
     */
	void guardar(Producto producto);
	
    /**
     * Modifica un producto existente.
     *
     * @param producto el producto actualizado.
     */
	void modificar(Producto producto);
	
    /**
     * Elimina un producto.
     *
     * @param productoEncontrado el producto a eliminar.
     */
	void eliminar(Producto productoEncontrado);
	
    /**
     * Obtiene un producto específico por su codigo.
     *
     * @param codigo el codigo del producto.
     * @return el producto con el codigo especificado.
     */
	Producto getBy(Long id);
	
}
