package tacos.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import tacos.data.TacoCrudService;
import tacos.domain.Taco;
import tacos.dto.TacoDTO;

@RestController
@RequestMapping(path = "/api/design", produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignTacoRestController {

	private final TacoCrudService tacoCrudService;

	public DesignTacoRestController(TacoCrudService tacoCrudService) {
		super();
		this.tacoCrudService = tacoCrudService;
	}

	@GetMapping("/recent")
	public Iterable<Taco> recentTacos() {
		return tacoCrudService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<TacoDTO> tacoById(@PathVariable Long id) {
		Optional<Taco> taco = tacoCrudService.findById(id);

		return new ResponseEntity<TacoDTO>(
				new TacoDTO(taco.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))), HttpStatus.OK);

	}

	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(consumes = "application/json", path = "/save")
	public ResponseEntity<Taco> processTaco(@RequestBody TacoDTO taco) {
		System.out.println("name " + taco.getName());
		return new ResponseEntity<Taco>(HttpStatus.CREATED);
	}
}
