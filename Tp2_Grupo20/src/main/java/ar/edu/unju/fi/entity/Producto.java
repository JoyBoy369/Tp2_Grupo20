package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
@Entity
@Table(name="productos")
@Component
public class Producto {
		
		@Id
		@GeneratedValue (strategy= GenerationType.IDENTITY)
		@Column (name="productos_id")
		private Long id;
	
		@Column (name="nombre_producto",nullable = false,length = 80)
		@NotEmpty(message = "El Nombre no puede estar vacio")
		private String nombre;
		
		@Column (name="categoria_producto",nullable = false,length = 80)
		@NotBlank(message = "La Categoria no puede estar vacia")
		private String categoria;	
		
		@Column (name="codigo_producto",nullable = false)
		@Positive(message="El codigo no pude ser negativo")
		private int codigo;		
		
		@Column (name="precio_producto",nullable = false)
		@Positive(message="El precio no pude ser negativo ni 0")
		
		private double precio;		
		@Column (name="descuento_producto",nullable = false)
		@Max(value=50,message="El descuento debe ser menor o igual de 50%")
		@Min(value=0,message="El descuento debe ser positivo")
		private double descuento;
		
		
		@Column
		private boolean estado;
		
		public Producto() {
			// TODO Auto-generated constructor stub
		}
	
		
		public Producto(Long id, String nombre, String categoria, int codigo, double precio, double descuento, boolean estado){
			super();
			this.id = id;
			this.nombre = nombre;
			this.categoria = categoria;
			this.codigo = codigo;
			this.precio = precio;
			this.descuento = descuento;
			this.estado = estado;
		}


		public double getPrecioConDescuento() {
			return precio*(100-descuento)/100;
		}
		
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}

		public double getDescuento() {
			return descuento;			
		}

		public void setDescuento(double descuento) {
			this.descuento = descuento;
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
