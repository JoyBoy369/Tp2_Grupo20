package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Component
public class Servicios {
	
	@NotEmpty(message = "el ID no puede estar vacio")
	private String id;
	
	@Size(min=5,max=150,message = "Ingrese un nombre valido")
	private String nombre;
	
	
	@Size(min=0,max=5,message="Ingrese una hora valida")
	private	String lunes;
	@Size(min=0,max=5,message="Ingrese una hora valida")
	private String martes;
	@Size(min=0,max=5,message="Ingrese una hora valida")
	private String miercoles;
	@Size(min=0,max=5,message="Ingrese una hora valida")
	private String jueves;
	@Size(min=0,max=5,message="Ingrese una hora valida")
	private String viernes;
	
	
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Servicios(String id, String nombre, String lunes, String martes, String miercoles, String jueves,
			String viernes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.lunes = lunes;
		this.martes = martes;
		this.miercoles = miercoles;
		this.jueves = jueves;
		this.viernes = viernes;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getLunes() {
		return lunes;
	}


	public void setLunes(String lunes) {
		this.lunes = lunes;
	}


	public String getMartes() {
		return martes;
	}


	public void setMartes(String martes) {
		this.martes = martes;
	}


	public String getMiercoles() {
		return miercoles;
	}


	public void setMiercoles(String miercoles) {
		this.miercoles = miercoles;
	}


	public String getJueves() {
		return jueves;
	}


	public void setJueves(String jueves) {
		this.jueves = jueves;
	}


	public String getViernes() {
		return viernes;
	}


	public void setViernes(String viernes) {
		this.viernes = viernes;
	}


	public Servicios() {
		
	}


}
