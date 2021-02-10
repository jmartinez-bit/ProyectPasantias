package aplicaciones.spring.models;

public class FormProveedor {
	Proveedor proveedor;
	PersonaContacto personaContacto;
	CuentaBancaria cuentaBancaria;
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public PersonaContacto getPersonaContacto() {
		return personaContacto;
	}
	public void setPersonaContacto(PersonaContacto personaContacto) {
		this.personaContacto = personaContacto;
	}
	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}
	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	
	
}
