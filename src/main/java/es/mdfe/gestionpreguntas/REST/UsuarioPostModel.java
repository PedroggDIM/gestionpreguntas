package es.mdfe.gestionpreguntas.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(itemRelation = "usuario")
public class UsuarioPostModel extends RepresentationModel<UsuarioPostModel>{
	private String nombre;
	private String nombreUsuario;
	private String contrasenia;
//	private String telefono;
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
//	public String getTelefono() {
//		return telefono;
//	}
//	public void setTelefono(String telefono) {
//		this.telefono = telefono;
//	}
	@Override
	public String toString() {
		return "UsuarioPostModel [nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", contrasenia="
				+ contrasenia + "]";
	}	
	
}
