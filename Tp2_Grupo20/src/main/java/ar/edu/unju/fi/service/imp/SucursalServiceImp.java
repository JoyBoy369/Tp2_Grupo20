package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

/**
 * Implementación de la interfaz ISucursalService.
 * Maneja las operaciones de gestión de sucursales.
 */
@Service
public class SucursalServiceImp implements ISucursalService {

    @Autowired
    private ListaSucursal listaSucursales;
    @Autowired
    private Sucursal sucursal;
    
    /**
     * Obtiene una lista de todas las sucursales.
     *
     * @return la lista de sucursales
     */
    public List<Sucursal> getLista() {
        return listaSucursales.getSucursal();
    }
    
    /**
     * Guarda una nueva sucursal.
     *
     * @param sucursal la sucursal a guardar
     */
    public void guardar(@Valid Sucursal sucursal) {
        listaSucursales.getSucursal().add(sucursal);
    }
    
    /**
     * Obtiene una sucursal específica por su nombre.
     *
     * @param nombre el nombre de la sucursal
     * @return la sucursal con el nombre especificado
     */
    public Sucursal getBy(String nombre) {
        Sucursal sucursalEncontrada = null;
        for (Sucursal sucu : listaSucursales.getSucursal()) {
            if (sucu.getNombre().equals(nombre)) {
                sucursalEncontrada = sucu;
                break;
            }           
        }
        return sucursalEncontrada;
    }
    
    /**
     * Modifica una sucursal existente.
     *
     * @param sucursal la sucursal actualizada
     */
    public void modificar(@Valid Sucursal sucursal) {
        for (Sucursal sucu : listaSucursales.getSucursal()) {
            if (sucu.getNombre().equals(sucursal.getNombre())) {
                sucu.setCorreo(sucursal.getCorreo());
                sucu.setDireccion(sucursal.getDireccion());
                sucu.setFecha(sucursal.getFecha());
                sucu.setProvincia(sucursal.getProvincia());
                sucu.setTelefono(sucursal.getTelefono());
            }
        }
    }
    
    /**
     * Elimina una sucursal.
     *
     * @param sucursal la sucursal a eliminar
     */
    public void eliminar(Sucursal sucursal) {
        listaSucursales.getSucursal().remove(sucursal);
    }
    
    /**
     * Obtiene la sucursal actual.
     *
     * @return la sucursal actual
     */
    @Override
    public Sucursal getSucursal() {
        return sucursal;
    }
}