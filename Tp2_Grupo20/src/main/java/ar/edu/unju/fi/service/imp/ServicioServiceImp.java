package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.repository.IServicioRepository;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

/**
 * Implementación de la interfaz IServicioService.
 * Maneja las operaciones de gestión de servicios.
 */
@Service("servicioServiceImp")
public class ServicioServiceImp implements IServicioService {
	
	@Autowired
	private IServicioRepository servicioRepository;
	
	@Autowired
	private Servicio servicio;
	
	@Override
	public List<Servicio> getListaServicio() {
		return servicioRepository.findByEstado(true);
	}

	@Override
	public Servicio getServicio() {
		return servicio;
	}

	@Override
	public void guardar(@Valid Servicio servicio) {
		servicioRepository.save(servicio);
	}

	@Override
	public Servicio getBy(Long id) {
		
		return servicioRepository.findById(id).get();
	}

	@Override
	public void modificar(@Valid Servicio servicio) {
		servicio.setEstado(true);
		servicioRepository.save(servicio);

	}

	@Override
	public void eliminar(Servicio servicioEncontrado) {
		servicioEncontrado.setEstado(false);
		servicioRepository.save(servicioEncontrado);
	}

}
