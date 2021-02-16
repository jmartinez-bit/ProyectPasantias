package aplicaciones.spring.models;

import java.util.List;

public class FormProveedor {
	Proveedor proveedor;
	List<Direccion> direccion;
	List<PersonaContacto> personaContacto;
	List<CuentaBancaria> cuentaBancaria;
	
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public List<Direccion> getDireccion() {
		return direccion;
	}
	public void setDireccion(List<Direccion> direccion) {
		this.direccion = direccion;
	}
	public List<PersonaContacto> getPersonaContacto() {
		return personaContacto;
	}
	public void setPersonaContacto(List<PersonaContacto> personaContacto) {
		this.personaContacto = personaContacto;
	}
	public List<CuentaBancaria> getCuentaBancaria() {
		return cuentaBancaria;
	}
	public void setCuentaBancaria(List<CuentaBancaria> cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
}
