package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Consejo;

/**
 * Esta interfaz define el contrato para gestionar objetos Consejo.
 */
public interface IConsejoService {
	
	/**
     * Obtiene una lista de todos los consejos.
     *
     * @return la lista de consejos
     */
	List <Consejo> getLista();
	
	/**
     * Guarda un nuevo consejo.
     *
     * @param consejo el consejo a guardar
     */
	void guardar(Consejo consejo);
	
	/**
     * Obtiene un consejo específico por su nombre.
     *
     * @param nombre el nombre del consejo
     * @return el consejo con el nombre especificado
     */
	Consejo getBy(Long id);
	
	/**
     * Modifica un consejo existente.
     *
     * @param consejo el consejo actualizado
     */
	void modificar(Consejo consejo);
	
	/**
     * Elimina un consejo.
     *
     * @param consejoEncontrado el consejo a eliminar
     */
	void eliminar(Consejo consejoEncontrado);
	
	/**
     * Obtiene el consejo actual.
     *
     * @return el consejo actual
     */
	Consejo getConsejo();
}
