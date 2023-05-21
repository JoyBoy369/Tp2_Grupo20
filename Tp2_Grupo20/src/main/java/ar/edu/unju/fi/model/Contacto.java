package ar.edu.unju.fi.model;

public class Contacto {
	
	private String nombre;
	private String correo;
	private String ciudad;
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
