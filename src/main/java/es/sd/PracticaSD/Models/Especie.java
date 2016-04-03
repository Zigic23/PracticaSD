package es.sd.PracticaSD.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Especie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idEspecie;

	private String nComun;
	private String nCient;
	private String tipo;
	@ManyToMany
	private List<Area> areas;

	public Especie() {

	}

	public Especie(String nComun, String nCient, String tipo, List<Area> areas) {
		this.nComun = nComun;
		this.nCient = nCient;
		this.tipo = tipo;
		this.areas = areas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNComun() {
		return this.nComun;
	}

	public void setNComun(String nComun) {
		this.nComun = nComun;
	}

	public String getNCient() {
		return this.nCient;
	}

	public void setNCient(String nCient) {
		this.nCient = nCient;
	}

	public List<Area> getAreas() {
		return this.areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public long getId() {
		return this.idEspecie;
	}

}
