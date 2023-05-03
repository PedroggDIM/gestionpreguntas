package es.mdfe.gestionpreguntas.REST;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import es.mdfe.gestionpreguntas.entidades.*;

@Relation(itemRelation = "familia")
public class FamiliaModel extends RepresentationModel<FamiliaModel>{
	
	private String enunciado;
	private long tamano;
	
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public long getTamano() {
		return tamano;
	}
	public void setTamano(long tamano) {
		this.tamano = tamano;
	}
}




