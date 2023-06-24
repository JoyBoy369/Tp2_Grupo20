package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name="sucursales")
public class Sucursal {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="suc_id")
	private Long id;
	
	
	
	
	
	@Column(name = "nombre",nullable = false,length = 80)
	@NotEmpty(message = "El Nombre no puede estar vacio")
	private String nombre;
	
	@Column(name = "direccion")
	@Size(min=5,max=150,message = "Ingrese una direccion completa")
	private String direccion;
	
	@Column(name = "provincia")
	@NotBlank(message = "Seleccione una Provincia")
	private String provincia;
	
	
	@Column(name = "fecha")
	@PastOrPresent(message = "Ingrese la Fecha cuando se inaguro la Sucursal (No puede ser mayor que hoy)")
	@NotNull(message = "No puede estar nulo la fecha")
	private LocalDate fecha;
	
	
	
	
	@Column(name = "correo")
	@Email(message = "Ingrese un correo valido")
	@NotEmpty(message = "No puede esatr vacio el correo")
	private String correo;
	
	
	@Column(name = "telefono")
	@Size(min=10,max=18,message = "Ingrese un telefono valido Ej:3880934183")
	private String telefono;

	@Column
	private boolean estado;
	
	public Sucursal() {
		
	}

	
	public Sucursal(Long id,String nombre, String direccion, String provincia, LocalDate fecha, String correo,
			String telefono,boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.provincia = provincia;
		this.fecha = fecha;
		this.correo = correo;
		this.telefono = telefono;
		this.estado = estado;
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
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
	
}
