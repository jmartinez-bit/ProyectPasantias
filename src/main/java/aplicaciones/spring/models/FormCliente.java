package aplicaciones.spring.models;

import java.util.List;

public class FormCliente {
	Cliente cliente;
	List<Direccion> direccion;
	List<PersonaContacto> personaContacto;
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
}
