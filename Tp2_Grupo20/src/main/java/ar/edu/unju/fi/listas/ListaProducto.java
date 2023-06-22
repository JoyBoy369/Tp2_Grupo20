package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Producto;
@Component
public class ListaProducto {
	private List<Producto> producto;
	
	
	public ListaProducto(){
		producto = new ArrayList <Producto>();
	//	producto.add(new Producto("Papas","Comida",11212,23,0));
	}


	public List<Producto> getProductos() {
		return producto;
	}


	public void setProductos(List<Producto> producto) {
		this.producto = producto;
	}
}