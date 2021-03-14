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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<?> create(@RequestBody FormDatoPersonal datoPersonal) {
		
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
				hijo.setDatoFamiliarId(datoFamiliarNuevo);
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
	
	@PutMapping("/datos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody FormDatoPersonal datoPersonal, Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		// Actualización para dato personal
		DatoPersonal datoPersonalEdit = datoPersonal.getDatoPersonal();
		DatoPersonal datoPersonalActual = datoPersonalService.findById(id);
		
		datoPersonalActual.setBanco(datoPersonalEdit.getBanco());
		datoPersonalActual.setCci(datoPersonalEdit.getCci());
		datoPersonalActual.setCorreoPer(datoPersonalEdit.getCorreoPer());
		datoPersonalActual.setCuspp(datoPersonalEdit.getCuspp());
		datoPersonalActual.setDepartamento(datoPersonalEdit.getDepartamento());
		datoPersonalActual.setDireccion(datoPersonalEdit.getDireccion());
		datoPersonalActual.setDistrito(datoPersonalEdit.getDistrito());
		datoPersonalActual.setFechaNac(datoPersonalEdit.getFechaNac());
		datoPersonalActual.setNacionalidad(datoPersonalEdit.getNacionalidad());
		datoPersonalActual.setNombres(datoPersonalEdit.getNombres());
		datoPersonalActual.setNumCuenta(datoPersonalEdit.getNumCuenta());
		datoPersonalActual.setNumDoc(datoPersonalEdit.getNumDoc());
		datoPersonalActual.setNumSeguro(datoPersonalEdit.getNumSeguro());
		datoPersonalActual.setPais(datoPersonalEdit.getPais());
		datoPersonalActual.setpApellido(datoPersonalEdit.getpApellido());
		datoPersonalActual.setProvincia(datoPersonalEdit.getProvincia());
		datoPersonalActual.setsApellido(datoPersonalEdit.getsApellido());
		datoPersonalActual.setSisPensiones(datoPersonalEdit.getSisPensiones());
		datoPersonalActual.setTelefFijo(datoPersonalEdit.getTelefFijo());
		datoPersonalActual.setTelefMovil(datoPersonalEdit.getTelefMovil());
		datoPersonalActual.setTipoCuenta(datoPersonalEdit.getTipoCuenta());
		datoPersonalActual.setTipoDoc(datoPersonalEdit.getTipoDoc());
		datoPersonalActual.setUbigeo(datoPersonalEdit.getUbigeo());
		
		// Actualización para dato familiar
		DatoFamiliar datoFamiliarEdit = datoPersonal.getDatoFamiliar();
		DatoFamiliar datoFamiliarActual = datoFamiliarService.findByDatoPersonal(datoPersonalActual);
		datoFamiliarActual.setDepartamento(datoFamiliarEdit.getDepartamento());
		datoFamiliarActual.setDireccion(datoFamiliarEdit.getDistrito());
		datoFamiliarActual.setDistrito(datoFamiliarEdit.getDistrito());
		datoFamiliarActual.setEstadoCivil(datoFamiliarEdit.getEstadoCivil());
		datoFamiliarActual.setFechaNac(datoFamiliarEdit.getFechaNac());
		datoFamiliarActual.setNacionalidad(datoFamiliarEdit.getNacionalidad());
		datoFamiliarActual.setNombres(datoFamiliarEdit.getNombres());
		datoFamiliarActual.setNumContacto(datoFamiliarEdit.getNumContacto());
		datoFamiliarActual.setNumDoc(datoFamiliarEdit.getNumDoc());
		datoFamiliarActual.setPais(datoFamiliarEdit.getPais());
		datoFamiliarActual.setpApellido(datoFamiliarEdit.getpApellido());
		datoFamiliarActual.setPerContacto(datoFamiliarEdit.getPerContacto());
		datoFamiliarActual.setProvincia(datoFamiliarEdit.getProvincia());
		datoFamiliarActual.setRelacion(datoFamiliarEdit.getRelacion());
		datoFamiliarActual.setsApellido(datoFamiliarEdit.getsApellido());
		datoFamiliarActual.setTipoDoc(datoFamiliarEdit.getTipoDoc());
		datoFamiliarActual.setUbigeo(datoFamiliarEdit.getUbigeo());
		
		// Actualización para datoLaboral
		DatoLaboral datoLaboralEdit = datoPersonal.getDatoLaboral();
		DatoLaboral datoLaboralActual = datoLaboralService.findByDatoPersonal(datoPersonalActual);
		datoLaboralActual.setCentEstudios(datoLaboralEdit.getCentEstudios());
		datoLaboralActual.setCurriculum(datoLaboralEdit.getCurriculum());
		datoLaboralActual.setFechaFin(datoLaboralEdit.getFechaFin());
		datoLaboralActual.setFechaIng(datoLaboralEdit.getFechaIng());
		datoLaboralActual.setFechaIniCargo(datoLaboralEdit.getFechaIniCargo());
		datoLaboralActual.setnAcademico(datoLaboralEdit.getnAcademico());
		datoLaboralActual.setProfesion(datoLaboralEdit.getProfesion());
		datoLaboralActual.setYearEgr(datoLaboralEdit.getYearEgr());
		datoLaboralActual.setYearIng(datoLaboralEdit.getYearIng());
	
		// Actualización para idioma
		List<Idioma> idiomaEdit = datoPersonal.getIdioma();
		List<Idioma> idiomaActual = idiomaService.findByDatoLaboralId(datoLaboralActual);
		List<Idioma> idiomaUpdated = idiomaService.updateIdioma(idiomaEdit, idiomaActual, datoLaboralActual);
		
		// Actualización para Hijo
		List<Hijo> hijoEdit = datoPersonal.getHijo();
		List<Hijo> hijoActual = hijoService.findByDatoFamiliarId(datoFamiliarActual);
		List<Hijo> hijoUpdated = hijoService.updateHijo(hijoEdit, hijoActual, datoFamiliarActual);
		
		// Actualización para datoHistorial
		DatoHistorial datoHistorialUpdated = null;
		if(datoPersonal.getDatoHistorial().getCargoActual() != null) {
			datoPersonal.getDatoHistorial().setDatoLaboralId(datoLaboralActual);
			datoHistorialUpdated = datoHistorialService.save(datoPersonal.getDatoHistorial());
		}
		
		DatoFamiliar datoFamiliarUpdated = datoFamiliarService.save(datoFamiliarActual);
		DatoLaboral datoLaboralUpdated = datoLaboralService.save(datoLaboralActual);
		DatoPersonal datoPersonalUpdated = datoPersonalService.save(datoPersonalActual);
		response.put("datoPersonal", datoPersonalUpdated);
		response.put("datoFamiliar", datoFamiliarUpdated);
		response.put("datoLaboral", datoLaboralUpdated);
		response.put("hijo", hijoUpdated);
		response.put("idioma", idiomaUpdated);
		response.put("datoHistorial", datoHistorialUpdated);
	
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
