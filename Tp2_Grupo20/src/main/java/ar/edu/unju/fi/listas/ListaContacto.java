package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Contacto;

@Component
public class ListaContacto {
	
	private List <Contacto> contacto;
	
	public ListaContacto() {
		
		contacto = new ArrayList<Contacto>();
		contacto.add(new Contacto("Ezequiel","ezequiel1@hotmail.com", "San Salvador de Jujuy", "Vencido"));
		contacto.add(new Contacto("Franco", "franco2@hotmail.com", "San Salvador de Jujuy", "Excelentes precios"));
		contacto.add(new Contacto("Elias", "elias3@hotmail.com", "San Salvador de Jujuy", "Demasiado caro"));
	}
	
	public List<Contacto> getContacto() {
		return contacto;
	}


	public void setContacto(List<Contacto> contacto) {
		this.contacto = contacto;
	}
}
