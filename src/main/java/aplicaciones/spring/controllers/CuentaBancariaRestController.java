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

import aplicaciones.spring.models.CuentaBancaria;
import aplicaciones.spring.models.services.ICuentaBancariaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class CuentaBancariaRestController {

	@Autowired
	private ICuentaBancariaService cuentaBancariaService;
	
	@GetMapping("/cuentas-bancarias")
	public List<CuentaBancaria> index() {
		return cuentaBancariaService.findAll();
	}
	
	@GetMapping("/cuentas-bancarias/{id}")
	public CuentaBancaria show(@PathVariable Long id) {
		return cuentaBancariaService.findById(id);
	}
	
	@PostMapping("/cuentas-bancarias")
	@ResponseStatus(HttpStatus.CREATED)
	public CuentaBancaria create(@RequestBody CuentaBancaria cuentaBancaria) {
		return cuentaBancariaService.save(cuentaBancaria);
	}
	
	@PutMapping("/cuentas-bancarias/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public CuentaBancaria update(@RequestBody CuentaBancaria cuentaBancaria, @PathVariable Long id) {
		CuentaBancaria cuentaBancariaActual = cuentaBancariaService.findById(id);
		
		cuentaBancariaActual.setCci(cuentaBancaria.getCci());
		cuentaBancariaActual.setEntidad(cuentaBancaria.getEntidad());
		cuentaBancariaActual.setMoneda(cuentaBancaria.getMoneda());
		cuentaBancariaActual.setNumCuenta(cuentaBancaria.getNumCuenta());
		cuentaBancariaActual.setProveedorId(cuentaBancaria.getProveedorId());
		cuentaBancariaActual.setTipoCuenta(cuentaBancaria.getTipoCuenta());
		
		return cuentaBancariaService.save(cuentaBancariaActual);
	}
	
	@DeleteMapping("/cuentas-bancarias/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		cuentaBancariaService.delete(id);
	}
}
