package es.sd.PracticaSD;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Area {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String nombre;
	
	private int extension;
	
	@ManyToMany
	private List<Animal> animales;
	
}
