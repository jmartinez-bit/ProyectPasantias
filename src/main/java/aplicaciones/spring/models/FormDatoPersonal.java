package aplicaciones.spring.models;

import java.util.List;

public class FormDatoPersonal {
	
	DatoPersonal datoPersonal;
	DatoFamiliar datoFamiliar;
	DatoLaboral datoLaboral;
	DatoHistorial datoHistorial;
	List<Idioma> idioma;
	List<Hijo> hijo;
	
	public DatoPersonal getDatoPersonal() {
		return datoPersonal;
	}
	public void setDatoPersonal(DatoPersonal datoPersonal) {
		this.datoPersonal = datoPersonal;
	}
	public DatoFamiliar getDatoFamiliar() {
		return datoFamiliar;
	}
	public void setDatoFamiliar(DatoFamiliar datoFamiliar) {
		this.datoFamiliar = datoFamiliar;
	}
	public DatoLaboral getDatoLaboral() {
		return datoLaboral;
	}
	public void setDatoLaboral(DatoLaboral datoLaboral) {
		this.datoLaboral = datoLaboral;
	}
	public DatoHistorial getDatoHistorial() {
		return datoHistorial;
	}
	public void setDatoHistorial(DatoHistorial datoHistorial) {
		this.datoHistorial = datoHistorial;
	}
	public List<Idioma> getIdioma() {
		return idioma;
	}
	public void setIdioma(List<Idioma> idioma) {
		this.idioma = idioma;
	}
	public List<Hijo> getHijo() {
		return hijo;
	}
	public void setHijo(List<Hijo> hijo) {
		this.hijo = hijo;
	}
}
