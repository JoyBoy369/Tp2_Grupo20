package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Servicio;

/**
 * Esta interfaz define el contrato para gestionar objetos Servicios.
 */
public interface IServicioService {
	
    /**
     * Obtiene una lista de todos los servicios.
     *
     * @return la lista de servicios.
     */
	List<Servicio> getListaServicio();
	
    /**
     * Obtiene el servicio actual.
     *
     * @return el servicio actual.
     */
	Servicio getServicio();
	
    /**
     * Guarda una nuevo servicio.
     *
     * @param servicios el servicio a guardar
     */
	void guardar (Servicio servicio);
	

    /**
     * Obtiene un servicio especifico por su id.
     *
     * @param id el id del servicio
     * @return el servicio con el id especificado
     */
	Servicio getBy(Long id);
	
    /**
     * Modifica un servicio existente.
     *
     * @param sucursal servicio el servicio actualizado.
     */
	void modificar(Servicio servicio);
	
	   /**
     * Elimina un servicio.
     *
     * @param servicioEncontrado el servicio a eliminar.
     */
	void eliminar(Servicio servicioEncontrado);
}
