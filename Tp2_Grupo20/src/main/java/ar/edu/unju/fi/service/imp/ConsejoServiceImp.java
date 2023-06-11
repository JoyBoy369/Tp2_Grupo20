package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

/**
 * Implementación de la interfaz IConsejoService.
 * Maneja las operaciones de gestión de consejos.
 */
@Service
public class ConsejoServiceImp implements IConsejoService {
	@Autowired
	private ListaConsejo listaConsejos;
	@Autowired
	private Consejo consejo;
	
	 /**
     * Obtiene una lista de todos los consejos.
     *
     * @return la lista de consejos
     */
public List <Consejo> getLista(){
	return listaConsejos.getConsejoList();
}

/**
 * Guarda un nuevo consejo.
 *
 * @param consejo el consejo a guardar
 */
public void guardar(@Valid Consejo consejo) {
	listaConsejos.getConsejoList().add(consejo);
	}

/**
 * Obtiene un consejo específico por su nombre.
 *
 * @param nombre el nombre del consejo
 * @return el consejo con el nombre especificado
 */
public Consejo getBy(String nombre) {
	Consejo consejoEncontrado = null;
	for(Consejo consej: listaConsejos.getConsejoList()) {
		if(consej.getTitulo().equals(nombre)) {
			consejoEncontrado = consej;
			break;
		}
	}
	return consejoEncontrado;
	}

/**
 * Modifica un consejo existente.
 *
 * @param consejo el consejo actualizado
 */
public void modificar(@Valid Consejo consejo) {
	for(Consejo consej: listaConsejos.getConsejoList()){
		if(consej.getTitulo().equals(consejo.getTitulo())) {
			consej.setTitulo(consejo.getTitulo());
			consej.setConsejo(consejo.getConsejo());
			break;
		}
		}
	}

/**
 * Elimina un consejo.
 *
 * @param consejo el consejo a eliminar
 */
public void eliminar(Consejo consejoEncontrado) {
	listaConsejos.getConsejoList().remove(consejoEncontrado);
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
