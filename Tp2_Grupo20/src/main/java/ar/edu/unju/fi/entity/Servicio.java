package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name="servicios")
public class Servicio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="serv_id")
	private Long id;
	
	@Column(name="serv_nombre")
	@Size(min=5,max=150,message = "Ingrese un nombre valido")
	private String nombre;
	
	@Column(name="serv_lunes")
	@Size(min=0,max=5,message="Ingrese una hora valida")
	private	String lunes;
	
	@Column(name="serv_martes")
	@Size(min=0,max=5,message="Ingrese una hora valida")
	private String martes;
	
	@Column(name="serv_miercoles")
	@Size(min=0,max=5,message="Ingrese una hora valida")
	private String miercoles;
	
	@Column(name="serv_jueves")
	@Size(min=0,max=5,message="Ingrese una hora valida")
	private String jueves;
	
	@Column(name="serv_viernes")
	@Size(min=0,max=5,message="Ingrese una hora valida")
	private String viernes;
	
	@Column(name="serv_estado")
	private boolean estado;
	


	public Servicio() {
		
	}
	
	public Servicio(Long id, String nombre, String lunes, String martes, String miercoles, String jueves,
			String viernes,boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.lunes = lunes;
		this.martes = martes;
		this.miercoles = miercoles;
		this.jueves = jueves;
		this.viernes = viernes;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
