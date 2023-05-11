package es.mdfe.gestionpreguntas.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;


public class Administrador extends Usuario {
	

	private String telefono;

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}	

	public Role getRole() {
		return Role.administrador;		
	}

	public Role setRole() {		
		return Role.administrador;
	}
}
