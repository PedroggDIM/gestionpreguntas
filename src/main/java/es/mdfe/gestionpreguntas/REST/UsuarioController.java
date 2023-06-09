package es.mdfe.gestionpreguntas.REST;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import es.mdef.support.Familia;
import es.mdfe.gestionpreguntas.GestionpreguntasApplication;
import es.mdfe.gestionpreguntas.entidades.Familia;
import es.mdfe.gestionpreguntas.entidades.Pregunta;
import es.mdfe.gestionpreguntas.entidades.Usuario;
import es.mdfe.gestionpreguntas.repositorios.PreguntaRepositorio;
import es.mdfe.gestionpreguntas.repositorios.UsuarioRepositorio;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	private final UsuarioRepositorio repositorio;
	private final PreguntaRepositorio repositorioPreguntas;
	private final UsuarioAssembler assembler;
	private final UssuarioPostAssembler postAsembler;
	private final UsuarioPutAssembler putAssembler;
	private final UsuarioListaAssembler listaAssembler;
	private final FamiliaListaAssembler familiaListaAssembler;
	private final Logger log;
	private final PreguntaListaAssembler prListaAssembler;

	UsuarioController(UsuarioRepositorio repositorio, UsuarioAssembler assembler,
			UssuarioPostAssembler postAssembler, UsuarioPutAssembler putAssembler,UsuarioListaAssembler listaAssembler,
			PreguntaListaAssembler prListaAssembler, PreguntaRepositorio repositorioPreguntas, FamiliaListaAssembler familiaListaAssembler) {
		this.repositorio = repositorio;
		this.assembler = assembler;
		this.postAsembler = postAssembler;
		this.listaAssembler = listaAssembler;
		this.putAssembler = putAssembler;
		log = GestionpreguntasApplication.log;
		this.prListaAssembler = prListaAssembler;
		this.repositorioPreguntas = repositorioPreguntas;
		this.familiaListaAssembler = familiaListaAssembler;		
	}

	@GetMapping("{id}")
	public UsuarioModel one(@PathVariable Long id) {
		Usuario usuario = repositorio.findById(id).
				orElseThrow(() -> new RegisterNotFoundException(id, "usuario"));
		log.info("Recuperado " + usuario);
		return assembler.toModel(usuario);
	}
	
	@GetMapping
	public CollectionModel<UsuarioListaModel> all(){
		return listaAssembler.toCollection(repositorio.findAll());
	}
	
	@GetMapping("porNombreUsuario")
	public CollectionModel<UsuarioListaModel> usuariosporNombreUsuario(@RequestParam String nombreUsuario) {
		return listaAssembler.toCollection(
				repositorio.findUsuarioByNombre(nombreUsuario)
				);
	}
    
	//Metodo para recuperara todas las preguntas que tiene el usuario.	
	@GetMapping("{id}/preguntas")
	public CollectionModel<PreguntaListaModel> preguntasDeUsuario(@PathVariable Long id) {
		Usuario usuario = repositorio.findById(id)
				.orElseThrow(() -> new RegisterNotFoundException(id, "usuario"));
	    return prListaAssembler.toCollection(usuario.getPreguntas());
	}

	@PostMapping
	public UsuarioModel add(@Valid @RequestBody UsuarioPostModel model) {
		Usuario usuario = repositorio.save(postAsembler.toEntity(model));
		log.info("Añadido " + usuario);
		return assembler.toModel(usuario);
	}
	
	@PutMapping("{id}")
	public UsuarioModel edit(@PathVariable Long id, @RequestBody UsuarioPutModel model) {
		Usuario usuario = repositorio.findById(id).map(usr -> {
			usr.setNombre(model.getNombre());
			usr.setNombreUsuario(model.getNombreUsuario());	
			return repositorio.save(usr);
		})
		.orElseThrow(() -> new RegisterNotFoundException(id, "usuario"));
		log.info("Actualizado " + usuario);
		return assembler.toModel(usuario);
	}
	
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		log.info("Borrado usuario " + id);
		repositorio.deleteById(id);
	}
	// Metodo personalizado: retorna las familias de las preguntas en las que ha participado o hecho el usuario.
	@GetMapping({"{id}/familias"})
	public CollectionModel<FamiliaListaModel> familias(@PathVariable long id){
		List<Pregunta>preguntas = repositorioPreguntas.findPreguntaByUsuario(id);
		Set<Familia>familias = new HashSet<>();
		for (Pregunta pregunta : preguntas) {
			familias.add(pregunta.getFamilia());
		}
		return familiaListaAssembler.toCollection(new ArrayList<>(familias));
	}
}

