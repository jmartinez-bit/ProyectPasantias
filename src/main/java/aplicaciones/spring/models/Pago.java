package aplicaciones.spring.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Pago  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String metodo;
	
	@Column(name="titular_tarjeta")
	private String titularTarjeta;
	
	@Column(name="num_cheque")
	private String numCheque;
	private String beneficiario;
	
	@Column(name="num_operacion")
	private String numOperacion;
	private String banco;
	
	@OneToOne
	@JoinColumn(name = "gasto_id")
	private Gasto gastoId;
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getTitularTarjeta() {
		return titularTarjeta;
	}

	public void setTitularTarjeta(String titularTarjeta) {
		this.titularTarjeta = titularTarjeta;
	}

	public String getNumCheque() {
		return numCheque;
	}

	public void setNumCheque(String numCheque) {
		this.numCheque = numCheque;
	}

	public String getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}

	public String getNumOperacion() {
		return numOperacion;
	}

	public void setNumOperacion(String numOperacion) {
		this.numOperacion = numOperacion;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Gasto getGastoId() {
		return gastoId;
	}

	public void setGastoId(Gasto gastoId) {
		this.gastoId = gastoId;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
