package ar.edu.unju.fi.listas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Sucursales;

@Component
public class ListaSucursal {
	private List <Sucursales> sucursal;
	
	
	public ListaSucursal() {
		
		sucursal = new ArrayList<Sucursales>();
		sucursal.add(new Sucursales("Super Mercado de Mascotas","Av. Fuerza Aerea 15","Jujuy",LocalDate.of(2019,03,20),"SuperMacotas15@gmail.com","0388 584-0387") );
		sucursal.add(new Sucursales("Forrajeria San Benito","Av. Carlos Undiano","Jujuy",LocalDate.of(2015,07,10),"SanBenito23@gmail.com","0388 15-590-4442") );
		sucursal.add(new Sucursales("Petit Pet Shop Las Heras","Av. Gral. Las Heras","Buenos Aires",LocalDate.of(2020,04,15),"HerasPetshop3@gmail.com","011 4814-0209") );
		sucursal.add(new Sucursales("Los Amigos Pet - Shop & Animal Zoo","Gdor. Luis Vernet ","Chaco",LocalDate.of(2019,05,02),"HerasPetshop3@gmail.com","011 4814-0209") );
	}


	
	
	
	public List<Sucursales> getSucursal() {
		return sucursal;
	}


	public void setSucursal(List<Sucursales> sucursal) {
		this.sucursal = sucursal;
	}
	
	
}
