package es.mdfe.gestionpreguntas.REST;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import es.mdfe.gestionpreguntas.entidades.Pregunta;
import es.mdfe.gestionpreguntas.entidades.Usuario;

@Component
public class PreguntaPostAssembler implements RepresentationModelAssembler<Pregunta, PreguntaPostModel> {

	@Override
	public PreguntaPostModel toModel(Pregunta entity) {
		PreguntaPostModel model = new PreguntaPostModel();		
		model.setEnunciado(entity.getEnunciado());
		
		model.add(
				linkTo(methodOn(PreguntaController.class).one(entity.getId())).withSelfRel()
				
				);
		return model;
	}
	
	public Pregunta toEntity(PreguntaPostModel model) {
		Pregunta pregunta = new Pregunta();
		pregunta.setEnunciado(model.getEnunciado());	
		pregunta.setUsuario(model.getUsuario());
	//	pregunta.setFamilia(model.getFamilia());
		return pregunta;
	}

}

