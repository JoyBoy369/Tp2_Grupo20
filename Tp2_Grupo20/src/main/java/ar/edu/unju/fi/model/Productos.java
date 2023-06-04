package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Component
public class Productos {
		
	
		@NotEmpty(message = "El Nombre no puede estar vacio")
		private String nombre;
		
		@NotBlank(message = "La Categoria no puede estar vacia")
		private String categoria;		
		
		@Positive(message="El codigo no pude ser negativo")
		private int codigo;		
		
		@Positive(message="El precio no pude ser negativo ni 0")
		private double precio;		
		
		@Max(value=50,message="El descuento debe ser menor o igual de 50%")
		@Min(value=0,message="El descuento debe ser positivo")
		private double descuento;
		
		public Productos() {
			// TODO Auto-generated constructor stub
		}
		
		
		public Productos(String nombre, String categoria, int codigo, double precio, double descuento) {
			super();
			this.nombre = nombre;
			this.categoria = categoria;
			this.codigo = codigo;
			this.precio = precio;
			this.descuento = descuento;
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
			
		
		}
