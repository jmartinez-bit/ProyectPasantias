package aplicaciones.spring.models;

import java.util.Date;

import javax.persistence.Column;

public class ClienteResponse {

	private final Long id;
	private final String codigo;
	private final String rucDni;
	private final String razonSocial;
	private final Date fechaIni;
	private final String rubroActividad;
	private final String comentarios;
	
	public ClienteResponse(Cliente cliente) {
		this.id = cliente.getId();
		this.codigo = cliente.getCodigo();
		this.rucDni = cliente.getRucDni();
		this.razonSocial = cliente.getRazonSocial();
		this.fechaIni = cliente.getFechaIni();
		this.rubroActividad = cliente.getRubroActividad();
		this.comentarios = cliente.getComentarios();
	}
	
	public Long getId() {
		return id;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getRucDni() {
		return rucDni;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public Date getFechaIni() {
		return fechaIni;
	}
	public String getRubroActividad() {
		return rubroActividad;
	}
	public String getComentarios() {
		return comentarios;
	}
}
