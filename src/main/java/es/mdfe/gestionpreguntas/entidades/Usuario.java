package es.mdfe.gestionpreguntas.entidades;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="USUARIOS")

@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name="rol_usuario", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("null")
public class Usuario {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private String nombre;	
	@NotBlank(message="nombre de usuario es un campo obligatorio de la clase usuario")
	private String nombreUsuario;
	@NotBlank(message="contrasena es un campo obligatorio de la clase usuario")
	private String contrasenia;	
	private Role role;
	
	public static enum Role {
		administrador,
		noAdministrador
	}
	public Role getRole() {
		return null;
	}
	public Role setRole() {
		return null;
	}	
	// en Usuario en un List recupero todas las preguntas que tiene un usuario.
	@OneToMany(mappedBy = "usuario")
	List<Pregunta>preguntas;	
	

	public Long getId() {
		return id;
	}
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	
}
