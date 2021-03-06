package aplicaciones.spring.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import aplicaciones.spring.models.Banco;
import aplicaciones.spring.models.BancoResponse;
import aplicaciones.spring.models.services.IBancoService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class BancoRestController {

	@Autowired
	private IBancoService bancoService;
	
	@GetMapping("/bancos")
	public Page<BancoResponse> categorias(@RequestParam(name = "page", defaultValue = "0") int page,
							@RequestParam(name = "size", defaultValue = "10") int size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<Banco> pageResult = bancoService.findAll(pageRequest);
		List<BancoResponse> bancos = pageResult
				.stream()
				.map(BancoResponse::new)
				.collect(Collectors.toList());
		
		return new PageImpl<>(bancos, pageRequest, pageResult.getTotalElements());
	}
	
	@GetMapping("/bancos/all")
	public List<Banco> bancos() {
		return bancoService.findAllBancos();
	}
	
	@GetMapping("/bancos/{id}")
	public Banco show(@PathVariable Long id) {
		return bancoService.findById(id);
	}
	
	@PostMapping("/bancos")
	@ResponseStatus(HttpStatus.CREATED)
	public Banco create(@RequestBody Banco banco) {
		return bancoService.save(banco);
	}
	
	@PutMapping("/bancos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Banco update(@RequestBody Banco banco, @PathVariable Long id) {
		Banco bancoActual = bancoService.findById(id);
		
		bancoActual = bancoService.findById(id);
		
		bancoActual.setAgApertura(banco.getAgApertura());
		bancoActual.setCci(banco.getCci());
		bancoActual.setComentarios(banco.getComentarios());
		bancoActual.setEntidad(banco.getEntidad());
		bancoActual.setEstado(banco.getEstado());
		bancoActual.setFechaApertura(banco.getFechaApertura());
		bancoActual.setFuncionario(banco.getFuncionario());
		bancoActual.setMoneda(banco.getMoneda());
		bancoActual.setNumCuenta(banco.getNumCuenta());
		bancoActual.setTipoCuenta(banco.getTipoCuenta());
		
		return bancoService.save(bancoActual);
	}
	
	@DeleteMapping("/bancos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		bancoService.delete(id);
	}
	
}
