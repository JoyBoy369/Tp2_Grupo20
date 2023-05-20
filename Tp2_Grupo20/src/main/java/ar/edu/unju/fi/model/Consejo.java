package ar.edu.unju.fi.model;

public class Consejo {

	private String titulo;
	private String consejo;
	
	public Consejo() {
		
	}
	public Consejo(String titulo, String consejo) {
		this.titulo = titulo;
		this.consejo = consejo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getConsejo() {
		return consejo;
	}
	
	public void setConsejo(String consejo) {
		this.consejo = consejo;
	}

	
	}


