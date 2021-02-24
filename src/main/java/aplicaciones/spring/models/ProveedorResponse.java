package aplicaciones.spring.models;

import java.util.Date;

public class ProveedorResponse {
	private final Long id;
	private final String codigo;
	private String rucDni;
	private String razonSocial;
	private Date fechaIni;
	private String rubroActividad;
	private String impuestoAsociado;
	private String tipoPago;
	private String comentarios;
	
	public ProveedorResponse(Proveedor proveedor) {
		this.id = proveedor.getId();
		this.codigo = proveedor.getCodigo();
		this.rucDni = proveedor.getRucDni();
		this.razonSocial = proveedor.getRazonSocial();
		this.fechaIni = proveedor.getFechaIni();
		this.rubroActividad = proveedor.getRubroActividad();
		this.impuestoAsociado = proveedor.getImpuestoAsociado();
		this.tipoPago = proveedor.getTipoPago();
		this.comentarios = proveedor.getComentarios();
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

	public String getImpuestoAsociado() {
		return impuestoAsociado;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public String getComentarios() {
		return comentarios;
	}

}
