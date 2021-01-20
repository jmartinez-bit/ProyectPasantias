package aplicaciones.spring.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Categoria implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nombre;
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "parent")
	private Categoria parent;
	
	public Categoria(@NotEmpty String nombre, String descripcion, Categoria parent) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.parent = parent;
	}

	public Categoria() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Categoria getParent() {
		return parent;
	}

	public void setParent(Categoria parent) {
		this.parent = parent;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
