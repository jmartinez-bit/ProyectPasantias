package aplicaciones.spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import aplicaciones.spring.models.DatoFamiliar;
import aplicaciones.spring.models.DatoHistorial;
import aplicaciones.spring.models.DatoLaboral;
import aplicaciones.spring.models.DatoPersonal;
import aplicaciones.spring.models.FormDatoPersonal;
import aplicaciones.spring.models.Hijo;
import aplicaciones.spring.models.Idioma;
import aplicaciones.spring.models.services.IDatoFamiliarService;
import aplicaciones.spring.models.services.IDatoHistorialService;
import aplicaciones.spring.models.services.IDatoLaboralService;
import aplicaciones.spring.models.services.IDatoPersonalService;
import aplicaciones.spring.models.services.IHijoService;
import aplicaciones.spring.models.services.IIdiomaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class DatoPersonalRestController {
	
	@Autowired
	private IDatoPersonalService datoPersonalService;
	
	@Autowired
	private IDatoFamiliarService datoFamiliarService;
	
	@Autowired
	private IDatoLaboralService datoLaboralService;
	
	@Autowired
	private IDatoHistorialService datoHistorialService;
	
	@Autowired
	private IIdiomaService idiomaService;
	
	@Autowired
	private IHijoService hijoService;
	
	@GetMapping("/datos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		DatoPersonal datoPersonal = datoPersonalService.findById(id);
		
		DatoFamiliar datoFamiliar = datoFamiliarService.findByDatoPersonal(datoPersonal);
		
		DatoLaboral datoLaboral = datoLaboralService.findByDatoPersonal(datoPersonal);
		
		response.put("datoPersonal", datoPersonal);
		response.put("datoFamiliar", datoFamiliar);
		response.put("datoLaboral", datoLaboral);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/datos")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(FormDatoPersonal datoPersonal) {
		
		Map<String, Object> response = new HashMap<>();
		
		DatoPersonal datoPersonalNuevo = datoPersonalService.save(datoPersonal.getDatoPersonal());
		
		datoPersonal.getDatoFamiliar().setDatoPersonalId(datoPersonalNuevo);
		DatoFamiliar datoFamiliarNuevo = datoFamiliarService.save(datoPersonal.getDatoFamiliar());
		
		datoPersonal.getDatoLaboral().setDatoPersonalId(datoPersonalNuevo);
		DatoLaboral datoLaboralNuevo = datoLaboralService.save(datoPersonal.getDatoLaboral());
		
		List<Idioma> idiomas = datoPersonal.getIdioma();
		List<Idioma> idiomaNuevo = null;
		if(idiomas != null) {
			for(Idioma idioma : idiomas) {
				idioma.setDatoLaboralId(datoLaboralNuevo);
			}
			idiomaNuevo = idiomaService.saveAll(idiomas);
		}
		
		List<Hijo> hijos = datoPersonal.getHijo();
		List<Hijo> hijoNuevo = null;
		if(hijos != null) {
			for(Hijo hijo: hijos) {
				hijo.setDatoFamilarId(datoFamiliarNuevo);
			}
			hijoNuevo = hijoService.saveAll(hijos);
		}
		
		datoPersonal.getDatoHistorial().setDatoLaboralId(datoLaboralNuevo);
		DatoHistorial datoHistorialNuevo = datoHistorialService.save(datoPersonal.getDatoHistorial());
		
		response.put("datoPersonal", datoPersonalNuevo);
		response.put("datoFamiliar", datoFamiliarNuevo);
		response.put("datoLaboral", datoLaboralNuevo);
		response.put("idioma", idiomaNuevo);
		response.put("hijo", hijoNuevo);
		response.put("datoHistorial", datoHistorialNuevo);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
