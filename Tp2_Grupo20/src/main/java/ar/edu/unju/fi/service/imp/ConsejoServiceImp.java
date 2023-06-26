package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.repository.IConsejoRepository;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

/**
 * Implementación de la interfaz IConsejoService.
 * Maneja las operaciones de gestión de consejos.
 */
@Service("consejoServiceImp")
public class ConsejoServiceImp implements IConsejoService {
	@Autowired
	private IConsejoRepository consejoRepository;
	
	@Autowired
	private Consejo consejo;
	
	 /**
     * Obtiene una lista de todos los consejos.
     *
     * @return la lista de consejos
     */
public List <Consejo> getLista(){
	return consejoRepository.findByEstado(true);
}

/**
 * Guarda un nuevo consejo.
 *
 * @param consejo el consejo a guardar
 */
public void guardar(@Valid Consejo consejo) {
	consejoRepository.save(consejo);
	}

/**
 * Obtiene un consejo específico por su nombre.
 *
 * @param nombre el nombre del consejo
 * @return el consejo con el nombre especificado
 */
public Consejo getBy(Long id) {
	
	return consejoRepository.findById(id).get();
	}

/**
 * Modifica un consejo existente.
 *
 * @param consejo el consejo actualizado
 */
public void modificar(@Valid Consejo consejo) {
	consejo.setEstado(true);
	consejoRepository.save(consejo);
	}

/**
 * Elimina un consejo.
 *
 * @param consejo el consejo a eliminar
 */
public void eliminar(Consejo consejoEncontrado) {
	consejoEncontrado.setEstado(false);
	consejoRepository.save(consejoEncontrado);
	}

/**
 * Obtiene el consejo actual.
 *
 * @return consejo actual
 */
@Override
public Consejo getConsejo() {
	return consejo;
	}
}
