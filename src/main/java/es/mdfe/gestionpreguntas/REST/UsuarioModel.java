package es.mdfe.gestionpreguntas.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdfe.gestionpreguntas.entidades.NoAdministrador.Dpto;
import es.mdfe.gestionpreguntas.entidades.NoAdministrador.Tipo;
import es.mdfe.gestionpreguntas.entidades.Usuario.Role;

@Relation(itemRelation = "usuario")
public class UsuarioModel extends RepresentationModel<UsuarioModel> {
	
	private String nombre;
	private String nombreUsuario;
	private String contrasenia;
	
	private Role rol;
	//atributo del administrador
    private String telefono;
   //atributos del noAdministrador
    private Dpto dpto;
    private Tipo tipo;
    
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
	public Role getRol() {
		return rol;
	}
	public void setRol(Role rol) {
		this.rol = rol;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Dpto getDpto() {
		return dpto;
	}
	public void setDpto(Dpto dpto) {
		this.dpto = dpto;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "UsuarioModel [nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", contrasenia=" + contrasenia
				+ ", rol=" + rol + ", telefono=" + telefono + ", dpto=" + dpto + ", tipo=" + tipo + "]";
	}
 
	
	


	
}