package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;

import ar.edu.unju.fi.repository.ISucursalRepository;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

/**
 * Implementación de la interfaz ISucursalService.
 * Maneja las operaciones de gestión de sucursales.
 */
@Service("sucursalServiceImp")
public class SucursalServiceImp implements ISucursalService {


	@Autowired
	private ISucursalRepository sucursalRepository;
	
	@Autowired
	private Sucursal sucursal;
	
	@Override
	public List<Sucursal> getLista() {
		
		return sucursalRepository.findByEstado(true);
	}

	@Override
	public void guardar(@Valid Sucursal sucursal) {
		sucursalRepository.save(sucursal);

	}

	@Override
	public Sucursal getBy(Long id) {
		 
		return sucursalRepository.findById(id).get();
	}

	@Override
	public void modificar(@Valid Sucursal sucursal) {
		sucursal.setEstado(true);
		sucursalRepository.save(sucursal);
		

	}

	@Override
	public void eliminar(Sucursal sucursalEncontrada) {
		sucursalEncontrada.setEstado(false);
		sucursalRepository.save(sucursalEncontrada);

	}

	@Override
	public Sucursal getSucursal() {
		 
		return sucursal;
	}
}