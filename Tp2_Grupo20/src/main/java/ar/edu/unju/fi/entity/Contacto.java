package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;



@Component
public class Contacto {
	
	@NotEmpty(message="El nombre no puede estar vacio")
	private String nombre;
	
	@Email(message="Debe introducir un e-mail con formato valido")
	@NotEmpty(message="El e-mail no puede estar vacio")
	private String correo;
	
	@NotBlank(message="Ingrese una provincia ")
	private String ciudad;
	
	@Size(min=20, max=150, message="el mensaje debe contener entre 20 y 150 caracteres")
	private String mensaje;
	
	public Contacto() {
		// TODO Auto-generated constructor stub
	}

	
	public Contacto(String nombre, String correo, String ciudad, String mensaje) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.ciudad = ciudad;
		this.mensaje = mensaje;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	
}
