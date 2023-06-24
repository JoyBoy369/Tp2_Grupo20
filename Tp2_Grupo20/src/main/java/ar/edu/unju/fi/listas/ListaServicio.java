package ar.edu.unju.fi.listas;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Servicio;

@Component
public class ListaServicio {
	private List<Servicio> servicio;
	
	public ListaServicio() {
		servicio = new ArrayList<Servicio>();
		
		//servicio.add(new Servicio("0021","Carlos","09:20","12:00","-----","-----","10:30"));
		//servicio.add(new Servicio("0210","Nacho","19:30","09:00","-----","-----","14:00"));
		//servicio.add(new Servicio("3696","Melody","19:30","12:00","-----","-----","15:15"));
	}

	public List<Servicio> getServicio() {
		return servicio;
	}

	public void setServicio(List<Servicio> servicio) {
		this.servicio = servicio;
	}
	
}
