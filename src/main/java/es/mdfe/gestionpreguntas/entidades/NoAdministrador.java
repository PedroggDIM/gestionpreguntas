package es.mdfe.gestionpreguntas.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


public class NoAdministrador extends Usuario {
	
	public static enum Dpto {
		EMIES,
	    CCESP	
	}
	public static enum Tipo {
		alumno,
	    docente,
	    adminsitracion
	}
	
	private Tipo tipo;
	private Dpto dpto;
	

	public Role getRole() {
		return Role.noAdministrador;
	}

	public Role setRole() {		
		return Role.noAdministrador;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Dpto getDpto() {
		return dpto;
	}
	public void setDpto(Dpto dpto) {
		this.dpto = dpto;
	}

}
	