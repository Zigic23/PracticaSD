package es.sd.PracticaSD;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Especie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String tipo;
	private String nComun;
	private String nCient;
	@ManyToMany(mappedBy="especies")
	private List<Area> areas;
	
}
