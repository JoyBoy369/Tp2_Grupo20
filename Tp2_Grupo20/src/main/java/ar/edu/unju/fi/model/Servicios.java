package ar.edu.unju.fi.model;



public class Servicios {
	
	private String id;
	private String nombre;
	private	String lunes;
	private String martes;
	private String miercoles;
	private String jueves;
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
