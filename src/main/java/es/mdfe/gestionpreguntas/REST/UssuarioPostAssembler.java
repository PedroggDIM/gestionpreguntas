package es.mdfe.gestionpreguntas.REST;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import es.mdfe.gestionpreguntas.entidades.Administrador;
import es.mdfe.gestionpreguntas.entidades.NoAdministrador;
import es.mdfe.gestionpreguntas.entidades.Usuario;
import es.mdfe.gestionpreguntas.entidades.Usuario.Role;

@Component
public class UssuarioPostAssembler implements RepresentationModelAssembler<Usuario, UsuarioPostModel> {

	@Override
	public UsuarioPostModel toModel(Usuario entity) {
		UsuarioPostModel model = new UsuarioPostModel();
		model.setNombre(entity.getNombre());
		model.setNombreUsuario(entity.getNombreUsuario());
		model.setContrasenia(entity.getContrasenia());
		
		model.add(
				linkTo(methodOn(UsuarioController.class).one(entity.getId())).withSelfRel()
				);
		return null;
	}
	
	public Usuario toEntity(UsuarioPostModel model) {
		Usuario usuario = null;
		if (model.getRol() == Role.administrador) {
			Administrador administrador = new Administrador();
		    administrador.setTelefono( model.getTelefono());
		    usuario = administrador;
		} else if (model.getRol() == Role.noAdministrador) {
			NoAdministrador noAdministrador = new NoAdministrador();
			noAdministrador.setDpto(model.getDpto());
			noAdministrador.setTipo(model.getTipo());
			usuario = noAdministrador;
		}
		usuario.setNombre(model.getNombre());
		usuario.setNombreUsuario(model.getNombreUsuario());
		usuario.setContrasenia(model.getContrasenia());
		return usuario;
	}
}

