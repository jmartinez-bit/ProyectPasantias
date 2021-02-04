package aplicaciones.spring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cuenta_bancaria")
public class CuentaBancaria {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String entidad;
	
	@Column(name="num_cuenta")
	private String numCuenta;
	
	private String cci;
	
	@Column(name="tipo_cuenta")
	private String tipoCuenta;
	private String moneda;
	
	@ManyToOne
	@JoinColumn(name = "proveedor_id")
	private Proveedor proveedorId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getCci() {
		return cci;
	}

	public void setCci(String cci) {
		this.cci = cci;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public Proveedor getProveedorId() {
		return proveedorId;
	}

	public void setProveedorId(Proveedor proveedorId) {
		this.proveedorId = proveedorId;
	}
}
