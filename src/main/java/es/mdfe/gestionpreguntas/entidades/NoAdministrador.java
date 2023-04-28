package es.mdfe.gestionpreguntas.entidades;

import jakarta.persistence.Entity;
import es.mdfe.gestionpreguntas.entidades.Usuario.Role;
import jakarta.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("N")
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
    
	public Role getRole() {
		return Role.administrador;
		
	}
	
	
	
	


}
	