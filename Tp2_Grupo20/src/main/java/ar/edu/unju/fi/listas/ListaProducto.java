package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Productos;

public class ListaProducto {
	private List<Productos> productos;
	
	
	public ListaProducto(){
		productos = new ArrayList <Productos>();
		productos.add(new Productos("Papas","Comida",11212,23,0));
	}


	public List<Productos> getProductos() {
		return productos;
	}


	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}
}