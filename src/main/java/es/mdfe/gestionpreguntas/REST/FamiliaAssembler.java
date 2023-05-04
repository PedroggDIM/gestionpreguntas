package es.mdfe.gestionpreguntas.REST;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.slf4j.Logger;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import es.mdfe.gestionpreguntas.GestionpreguntasApplication;
import es.mdfe.gestionpreguntas.REST.*;
import es.mdfe.gestionpreguntas.entidades.Familia;

@Component
public class FamiliaAssembler implements RepresentationModelAssembler<Familia, FamiliaModel> {
	public final Logger log;

	public FamiliaAssembler() {
		log = GestionpreguntasApplication.log;
	}
	
	public FamiliaModel toModel(Familia entity) {
		FamiliaModel model = new FamiliaModel();
		model.setEnunciado(entity.getEnunciado());
		model.setTamano(entity.getTamano());
		model.add(
				linkTo(methodOn(FamiliaController.class).one(entity.getId())).withSelfRel()
				// En FamiliaController tengo que hacer el método usuariosDeFamilia.
				, linkTo(methodOn(FamiliaController.class).usuariosDeFamilia(entity.getId())).withRel("usuarios")
				// En FamiliaController tengo que tener el método preguntasDeFamilia.
				, linkTo(methodOn(FamiliaController.class).preguntasDeFamilia(entity.getId())).withRel("preguntas")
				);
		return model;
	}
	
	public Familia toEntity(FamiliaPostModel model) {
		Familia familia = new Familia();
		familia.setEnunciado(model.getEnunciado());
		return familia;
	}
}