package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Servicios;
import jakarta.validation.Valid;

/**
 * Esta interfaz define el contrato para gestionar objetos Servicios.
 */
public interface IServicioService {
	
    /**
     * Obtiene una lista de todos los servicios.
     *
     * @return la lista de servicios.
     */
	List<Servicios> getListaServicio();
	
    /**
     * Obtiene el servicio actual.
     *
     * @return el servicio actual.
     */
	Servicios getServicio();
	
    /**
     * Guarda una nuevo servicio.
     *
     * @param servicios el servicio a guardar
     */
	void guardar (@Valid Servicios servicio);
	

    /**
     * Obtiene un servicio especifico por su id.
     *
     * @param id el id del servicio
     * @return el servicio con el id especificado
     */
	Servicios getBy(String id);
	
    /**
     * Modifica un servicio existente.
     *
     * @param sucursal servicio el servicio actualizado.
     */
	void modificar(@Valid Servicios servicio);
	
	   /**
     * Elimina un servicio.
     *
     * @param servicioEncontrado el servicio a eliminar.
     */
	void eliminar(Servicios servicioEncontrado);
}
