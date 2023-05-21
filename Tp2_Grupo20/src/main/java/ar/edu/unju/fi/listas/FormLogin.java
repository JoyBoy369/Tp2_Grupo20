package ar.edu.unju.fi.listas;

public class FormLogin {

	private String usuario;
	private String clave;

	
	public FormLogin() {
		
	}


	public FormLogin(String usuario, String clave) {
		super();
		this.usuario = usuario;
		this.clave = clave;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}
	
}
