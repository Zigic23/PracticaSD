package es.sd.PracticaSD;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String tipo;
	private String nombre;
	private String nombreCientifico;
	@ManyToMany(mappedBy="animales")
	private List<Area> areas;
	
}
