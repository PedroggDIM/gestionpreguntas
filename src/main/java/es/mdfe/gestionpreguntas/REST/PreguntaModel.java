package es.mdfe.gestionpreguntas.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdfe.gestionpreguntas.entidades.Usuario.Role;

@Relation(itemRelation = "pregunta")
public class PreguntaModel extends RepresentationModel<PreguntaModel> {
	
     private String enunciado;

	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	@Override
	public String toString() {
		return "PreguntaModel [enunciado=" + enunciado + "]";
	}    
     

	
}