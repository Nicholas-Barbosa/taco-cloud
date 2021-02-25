package tacos.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tacos.data.TacoCrudService;
import tacos.domain.Taco;

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
}
