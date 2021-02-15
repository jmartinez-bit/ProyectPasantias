package aplicaciones.spring.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalle_producto_compra")
public class DetalleProductoCompra implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="guia_remision")
	private String guiaRemision;
	
	
	private String familia;
	
	@Column(name = "sub_familia")
	private String subFamilia;
	
	private String tipo;
	private String marca;
	private String modelo;
	private String serie;
	
	@Column(name = "cant_ing")
	private int cantIng;
	
	@Column(name = "cod_int")
	private String codInt;
	
	@ManyToOne
	@JoinColumn(name = "producto_compra_id")
	private ProductoCompra productoCompraId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGuiaRemision() {
		return guiaRemision;
	}

	public void setGuiaRemision(String guiaRemision) {
		this.guiaRemision = guiaRemision;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getSubFamilia() {
		return subFamilia;
	}

	public void setSubFamilia(String subFamilia) {
		this.subFamilia = subFamilia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public int getCantIng() {
		return cantIng;
	}

	public void setCantIng(int cantIng) {
		this.cantIng = cantIng;
	}

	public String getCodInt() {
		return codInt;
	}

	public void setCodInt(String codInt) {
		this.codInt = codInt;
	}

	public ProductoCompra getProductoCompraId() {
		return productoCompraId;
	}

	public void setProductoCompraId(ProductoCompra productoCompraId) {
		this.productoCompraId = productoCompraId;
	}
}
