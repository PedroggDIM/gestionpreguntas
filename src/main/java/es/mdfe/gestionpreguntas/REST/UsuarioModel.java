package es.mdfe.gestionpreguntas.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdfe.gestionpreguntas.entidades.Usuario.Role;

@Relation(itemRelation = "usuario")
public class UsuarioModel extends RepresentationModel<UsuarioModel> {
	
	private String nombre;
	private String nombreUsuario;
	private String contrasenia;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	@Override
	public String toString() {
		return "UsuarioModel [nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", contrasenia=" + contrasenia
				+ "]";
	}

	
}