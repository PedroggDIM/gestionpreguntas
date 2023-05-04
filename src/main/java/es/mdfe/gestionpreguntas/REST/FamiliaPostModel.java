package es.mdfe.gestionpreguntas.REST;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
//import jakarta.validation.constraints.NotBlank;

@Relation(itemRelation = "familia")
public class FamiliaPostModel extends RepresentationModel<FamiliaPostModel> {

private String enunciado;
	
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	
}