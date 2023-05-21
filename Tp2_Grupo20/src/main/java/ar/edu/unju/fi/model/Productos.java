package ar.edu.unju.fi.model;

public class Productos {
			
		private String nombre,categoria;
		private int codigo;
		private double precio,descuento;
		

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
