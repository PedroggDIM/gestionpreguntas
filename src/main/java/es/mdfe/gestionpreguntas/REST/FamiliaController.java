package es.mdfe.gestionpreguntas.REST;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.mdfe.gestionpreguntas.REST.FamiliaAssembler;
import es.mdfe.gestionpreguntas.GestionpreguntasApplication;
import es.mdfe.gestionpreguntas.entidades.Administrador;
import es.mdfe.gestionpreguntas.entidades.NoAdministrador;
import es.mdfe.gestionpreguntas.entidades.Pregunta;
import es.mdfe.gestionpreguntas.entidades.Usuario;
import es.mdfe.gestionpreguntas.entidades.Familia;
import es.mdfe.gestionpreguntas.repositorios.FamiliaRepositorio;
import es.mdfe.gestionpreguntas.repositorios.PreguntaRepositorio;
// import es.mdef.gestionusuarios.validation.RegisterNotFoundException;
// import jakarta.validation.Valid;

@RestController
@RequestMapping("/familias")
public class FamiliaController {
	private final FamiliaRepositorio repositorio;
	private final FamiliaAssembler assembler;
	private final FamiliaListaAssembler famListaAssembler;
	private final PreguntaListaAssembler prListaAssembler;
	private final UsuarioListaAssembler usuListaAssembler;
	private final Logger log;
		
	FamiliaController(FamiliaRepositorio repositorio, FamiliaAssembler assembler, 
			PreguntaListaAssembler prListaAssembler, FamiliaListaAssembler famListaAssembler,
			UsuarioListaAssembler userListaAssembler) {
			this.repositorio = repositorio;
			this.assembler = assembler;
			this.prListaAssembler = prListaAssembler;
			this.famListaAssembler = famListaAssembler;
			this.usuListaAssembler = userListaAssembler;
		    log = GestionpreguntasApplication.log;
		}		
//		@GetMapping("{id}")
//		public EntityModel<Familia> one(@PathVariable Long id) {
//			Familia familia = repositorio.findById(id)
//					.orElseThrow(() -> new RegisterNotFoundException(id, "familia"));
//			log.info("Recuperado " + familia);
//			//return assembler.toModel(familia);
//			return EntityModel.of(familia);
//		}	
		@GetMapping("{id}")
		public FamiliaModel one(@PathVariable Long id) {
			Familia familia = repositorio.findById(id).orElseThrow(() -> new RegisterNotFoundException(id, "familia"));
			log.info("Recuperado " + familia);
			return assembler.toModel(familia);
		}

		@GetMapping("{id}/preguntas")
		public CollectionModel<PreguntaListaModel> preguntasDeFamilia(@PathVariable Long id) {
			Familia familia = repositorio.findById(id).orElseThrow(() -> new RegisterNotFoundException(id, "familia"));
			return prListaAssembler.toCollection(familia.getPreguntas());
		}

		@GetMapping
		public CollectionModel<FamiliaListaModel> all() {
			return famListaAssembler.toCollection(repositorio.findAll());
		}

		@PostMapping
		public FamiliaModel add(@RequestBody FamiliaPostModel model) {
			Familia familia = repositorio.save(assembler.toEntity(model));
			// log.info("Añadido " + familia);
			return assembler.toModel(familia);
		}

		@PutMapping("{id}")
		public FamiliaModel edit(@PathVariable Long id, @RequestBody FamiliaPostModel model) {

			Familia familia = repositorio.findById(id).map(fam -> {
				// al tener solo un atributo, no merece la pena consultar que sea nulo
				// el comportamenitno es igual que en un put (validar en el modelo)
				// if (model.getEnunciado() != null) fam.setEnunciado(model.getEnunciado());
				fam.setEnunciado(model.getEnunciado());
				return repositorio.save(fam);
			}).orElseThrow(() -> new RegisterNotFoundException(id, "Familia"));
			log.info("Actualizado " + familia);
			return assembler.toModel(familia);
		}

		@GetMapping("{id}/usuarios")
		public CollectionModel<UsuarioListaModel> usuariosDeFamilia(@PathVariable Long id) {
			Familia familia = repositorio.findById(id).orElseThrow(() -> new RegisterNotFoundException(id, "familia"));

			List<Usuario> usuarios = familia.getPreguntas().stream().map(Pregunta::getUsuario).distinct()
					.collect(Collectors.toList());
			return usuListaAssembler.toCollection(usuarios);
		}

		@DeleteMapping("{id}")
		public void delete(@PathVariable Long id) {
			log.info("Borrado Familia " + id);
			Familia familia = repositorio.findById(id).map(fam -> {
				repositorio.deleteById(id);
				return fam;
			}).orElseThrow(() -> new RegisterNotFoundException(id, "familia"));
		}
	}