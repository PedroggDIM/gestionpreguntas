package es.mdfe.gestionpreguntas.REST;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import javax.lang.model.element.ModuleElement;
import javax.management.relation.Role;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import es.mdfe.gestionpreguntas.entidades.Usuario;

@Component
public class UsuarioPutAssembler implements RepresentationModelAssembler<Usuario, UsuarioPutModel>{

	@Override
	public UsuarioPutModel toModel(Usuario entity) {
		UsuarioPutModel model = new UsuarioPutModel();
		model.setNombre(entity.getNombre());
		model.setNombreUsuario(entity.getNombreUsuario());
		model.setContrasenia(entity.getContrasenia());
		model.add(
				linkTo(methodOn(UsuarioController.class).one(entity.getId())).withSelfRel()
				);
		return model;
	}
	
	public Usuario toEntity(UsuarioPutModel model) {
		Usuario usuario = new Usuario();
		usuario.setNombre(model.getNombre());
		usuario.setNombreUsuario(model.getNombreUsuario());
		usuario.setContrasenia(model.getContrasenia());
		return usuario;
	}

}
