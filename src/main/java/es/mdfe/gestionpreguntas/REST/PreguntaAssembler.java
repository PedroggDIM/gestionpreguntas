package es.mdfe.gestionpreguntas.REST;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import es.mdfe.gestionpreguntas.entidades.Pregunta;
import es.mdfe.gestionpreguntas.entidades.Usuario;

@Component
public class PreguntaAssembler implements RepresentationModelAssembler<Pregunta, PreguntaModel> {

	@Override
	public PreguntaModel toModel(Pregunta entity) {
		PreguntaModel model = new PreguntaModel();		
		model.setEnunciado(entity.getEnunciado());
		model.add(
				linkTo(methodOn(PreguntaController.class).one(entity.getId())).withSelfRel(),
				//Usuario como es una clase se carga aquí
				linkTo(methodOn(UsuarioController.class).one(entity.getUsuario().getId())).withRel("usuario"),
				//Familia como es una clase se carga aquí
	      		linkTo(methodOn(FamiliaController.class).one(entity.getFamilia().getId())).withRel("familia")	
				);
		return model;
	}
	
	public Pregunta toEntity(PreguntaModel model) {
		Pregunta pregunta = new Pregunta();		
		pregunta.setEnunciado(model.getEnunciado());
		//pregunta.setUsuario(model.get);
		return pregunta;
		
	}
	
}  
