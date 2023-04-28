package es.mdfe.gestionpreguntas.REST;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import es.mdfe.gestionpreguntas.entidades.Usuario;

@Component
public class UsuarioAssembler implements RepresentationModelAssembler<Usuario, UsuarioModel> {

	@Override
	public UsuarioModel toModel(Usuario entity) {
		UsuarioModel model = new UsuarioModel();
		model.setNombre(entity.getNombre());
		model.setNombreUsuario(entity.getNombreUsuario());
		model.setContrasenia(entity.getContrasenia());
//		model.setRole(entity.getRole());
		model.add(
				linkTo(methodOn(UsuarioController.class).one(entity.getId())).withSelfRel(),				
				linkTo(methodOn(UsuarioController.class).preguntasDeUsuario(entity.getId())).withRel("preguntas")
				//Familia como es una clase se carga aquí
	      	//	linkTo(methodOn(FamiliaController.class).one(entity.getFamilia().getId())).withSelfRel()	
				 );
		return model;
	}
	
	public Usuario toEntity(UsuarioModel model) {
		Usuario usuario = new Usuario();
		usuario.setNombre(model.getNombre());
		usuario.setNombreUsuario(model.getNombreUsuario());
		usuario.setContrasenia(model.getContrasenia());
//		usuario.setRole(model.getRole());
		return usuario;
	}
	
}
