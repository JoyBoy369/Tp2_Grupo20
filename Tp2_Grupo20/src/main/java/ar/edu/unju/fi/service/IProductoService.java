package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Productos;
import jakarta.validation.Valid;

/**
 * Esta interfaz define el contrato para gestionar objetos Productos.
 */
public interface IProductoService {
	
	 /**
     * Obtiene una lista de todos los productos.
     *
     * @return la lista de productos
     */
	List<Productos> getLista();
	

    /**
     * Obtiene el producto actual.
     *
     * @return el producto actual
     */
	Productos getProducto();
	
    /**
     * Guarda una nuevo producto.
     *
     * @param producto el producto a guardar
     */
	void guardar(@Valid Productos producto);
	
    /**
     * Modifica un producto existente.
     *
     * @param producto el producto actualizado.
     */
	void modificar(@Valid Productos producto);
	
    /**
     * Elimina un producto.
     *
     * @param productoEncontrado el producto a eliminar.
     */
	void eliminar(Productos productoEncontrado);
	
    /**
     * Obtiene un producto específico por su codigo.
     *
     * @param codigo el codigo del producto.
     * @return el producto con el codigo especificado.
     */
	Productos getBy(String codigo);
	
}
