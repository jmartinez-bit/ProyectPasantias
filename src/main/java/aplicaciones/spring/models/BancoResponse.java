package aplicaciones.spring.models;

import java.util.Date;

public class BancoResponse {
	
	private final Long id;
	private final String entidad;
	private final String moneda;
	private final String tipoCuenta;
	private final Date fechaApertura;
	private final String numCuenta;
	private final String cci;
	private final String funcionario;
	private final String agApertura;
	private final String estado;
	private final String comentarios;
	
	public BancoResponse(Banco banco) {
		this.id = banco.getId();
		this.entidad = banco.getEntidad();
		this.moneda = banco.getMoneda();
		this.tipoCuenta = banco.getTipoCuenta();
		this.fechaApertura = banco.getFechaApertura();
		this.numCuenta = banco.getNumCuenta();
		this.cci = banco.getCci();
		this.funcionario = banco.getFuncionario();
		this.agApertura = banco.getAgApertura();
		this.estado = banco.getEstado();
		this.comentarios = banco.getComentarios();
	}
	
	public Long getId() {
		return id;
	}
	public String getEntidad() {
		return entidad;
	}
	public String getMoneda() {
		return moneda;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public Date getFechaApertura() {
		return fechaApertura;
	}
	public String getNumCuenta() {
		return numCuenta;
	}
	public String getCci() {
		return cci;
	}
	public String getFuncionario() {
		return funcionario;
	}
	public String getAgApertura() {
		return agApertura;
	}
	public String getEstado() {
		return estado;
	}
	public String getComentarios() {
		return comentarios;
	}
}
