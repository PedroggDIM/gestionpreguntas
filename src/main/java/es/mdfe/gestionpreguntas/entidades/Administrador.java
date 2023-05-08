package es.mdfe.gestionpreguntas.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("A")
public class Administrador extends Usuario {
	

	private String telefono;

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}	
	@Override
	public Role getRole() {
		return Role.administrador;		
	}
	@Override
	public Role setRole() {		
		return Role.administrador;
	}
}
