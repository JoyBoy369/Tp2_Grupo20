package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.model.Servicios;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

/**
 * Implementación de la interfaz IServicioService.
 * Maneja las operaciones de gestión de servicios.
 */
@Service
public class ServicioServiceImp implements IServicioService {
	
	@Autowired	
	private ListaServicio listaServicios;
	
	@Autowired
	private Servicios servicio;
	
	/**
     * Obtiene una lista de todos los servicios.
     *
     * @return la lista de servicios
     */
	@Override
	public List<Servicios> getListaServicio() {
		return listaServicios.getServicio();
	}
	
    /**
     * Obtiene el servicio actual.
     *
     * @return el servicio actual
     */
	public Servicios getServicio() {
		return servicio;
	}
	
    /**
     * Guarda una nuevo servicio.
     *
     * @param servicio el servicio a guardar
     */
	@Override
	public void guardar(Servicios servicio) {
		listaServicios.getServicio().add(servicio);
	}
	
    /**
     * Obtiene un servicio específico por su id.
     *
     * @param id el id del servicio.
     * @return el servicio con el id especificado.
     */
	@Override
	public Servicios getBy(String id) {
		   Servicios servicioEncontrado = null;
	        for (Servicios serv : listaServicios.getServicio()) {
	            if (serv.getId().equals(id)) {
	            	servicioEncontrado = serv;
	                break;
	            }           
	        }
	        return servicioEncontrado;
	}

	/**
     * Modifica un servicio existente.
     *
     * @param servicio el servicio actualizado.
     */
	@Override
	public void modificar(@Valid Servicios servicio) {
		for(Servicios serv: listaServicios.getServicio()) {
			if(serv.getId().equals(servicio.getId())) {
				
				serv.setNombre(servicio.getNombre());
				serv.setLunes(servicio.getLunes());
				serv.setMartes(servicio.getMartes());
				serv.setMiercoles(servicio.getMiercoles());
				serv.setJueves(servicio.getJueves());
				serv.setViernes(servicio.getViernes());
			}
		}
		
	}
	
    /**
     * Elimina un servicio.
     *
     * @param servicio el servicio a eliminar
     */
	@Override
	public void eliminar(Servicios servicio) {
		listaServicios.getServicio().remove(servicio);
	}


}
