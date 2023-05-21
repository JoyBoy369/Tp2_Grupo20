package ar.edu.unju.fi.model;

import java.time.LocalDate;

public class Sucursales {

	private String nombre;
	private String direccion;
	private String provincia;
	private LocalDate fecha;
	private String correo;
	private String telefono;

	public Sucursales() {
		
	}

	
	public Sucursales(String nombre, String direccion, String provincia, LocalDate fecha, String correo,
			String telefono) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.provincia = provincia;
		this.fecha = fecha;
		this.correo = correo;
		this.telefono = telefono;
	}












	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	
	
	
	
}
