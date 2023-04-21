package es.mdfe.gestionpreguntas.REST;

import javax.management.relation.Role;
import javax.print.DocFlavor.STRING;

import org.springframework.hateoas.RepresentationModel;

public class UsuarioPutModel extends RepresentationModel<UsuarioPutModel>{
	
	private String nombre;
	private String nombreUsuario;
	private String telefono;
	private Role role;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UsuarioPutModel [nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", telefono=" + telefono
				+ ", role=" + role + "]";
	}
	
	
}
