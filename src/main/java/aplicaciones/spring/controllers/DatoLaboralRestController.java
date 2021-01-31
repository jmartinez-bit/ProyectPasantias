package aplicaciones.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import aplicaciones.spring.models.DatoLaboral;
import aplicaciones.spring.models.services.IDatoLaboralService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class DatoLaboralRestController {

	@Autowired
	private IDatoLaboralService datoLaboralService;
	
	@GetMapping("/dato-laboral")
	public List<DatoLaboral> index() {
		return datoLaboralService.findAll();
	}
	
	@GetMapping("/dato-laboral/{id}")
	public DatoLaboral show(@PathVariable Long id) {
		return datoLaboralService.findById(id);
	}
	
	@PostMapping("/dato-laboral")
	@ResponseStatus(HttpStatus.CREATED)
	public DatoLaboral create(@RequestBody DatoLaboral datoLaboral) {
		return datoLaboralService.save(datoLaboral);
	}
	
	@PutMapping("/dato-laboral/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public DatoLaboral update(@RequestBody DatoLaboral datoLaboral, @PathVariable Long id) {
		DatoLaboral datoLaboralActual = datoLaboralService.findById(id);
		
		datoLaboralActual.setCentEstudios(datoLaboral.getCentEstudios());
		datoLaboralActual.setCurriculum(datoLaboral.getCurriculum());
		datoLaboralActual.setDatoPersonalId(datoLaboral.getDatoPersonalId());
		datoLaboralActual.setFechaFin(datoLaboral.getFechaFin());
		datoLaboralActual.setFechaIng(datoLaboral.getFechaIng());
		datoLaboralActual.setFechaIniCargo(datoLaboral.getFechaIniCargo());
		datoLaboralActual.setHistorial(datoLaboral.getHistorial());
		datoLaboralActual.setnAcademico(datoLaboral.getnAcademico());
		datoLaboralActual.setProfesion(datoLaboral.getProfesion());
		datoLaboralActual.setYearEgr(datoLaboral.getYearEgr());
		datoLaboralActual.setYearIng(datoLaboral.getYearIng());
		
		return datoLaboralService.save(datoLaboralActual);
	}
	
	@DeleteMapping("/dato-laboral/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		datoLaboralService.delete(id);
	}
}
