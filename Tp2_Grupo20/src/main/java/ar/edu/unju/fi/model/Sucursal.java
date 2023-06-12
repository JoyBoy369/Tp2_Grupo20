package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Component
public class Sucursal {
	@NotEmpty(message = "El Nombre no puede estar vacio")
	private String nombre;
	
	@Size(min=5,max=150,message = "Ingrese una direccion completa")
	private String direccion;
	
	@NotBlank(message = "Seleccione una Provincia")
	private String provincia;
	
	@PastOrPresent(message = "Ingrese la Fecha cuando se inaguro la Sucursal (No puede ser mayor que hoy)")
	@NotNull(message = "No puede estar nulo la fecha")
	private LocalDate fecha;
	
	@Email(message = "Ingrese un correo valido")
	@NotEmpty(message = "No puede esatr vacio el correo")
	private String correo;
	
	@Size(min=10,max=18,message = "Ingrese un telefono valido Ej:3880934183")
	private String telefono;

	public Sucursal() {
		
	}

	
	public Sucursal(String nombre, String direccion, String provincia, LocalDate fecha, String correo,
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
