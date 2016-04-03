package es.sd.PracticaSD.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.sd.PracticaSD.Models.Area;
import es.sd.PracticaSD.Models.Especie;
import es.sd.PracticaSD.Repository.AreaRepository;
import es.sd.PracticaSD.Repository.EspecieRepository;

@Controller
public class EspecieController {

	@Autowired
	private EspecieRepository espRep;

	@Autowired
	private AreaRepository areasRep;

	@RequestMapping(value = "/buscarEspecie")
	public String buscarEspecie(Model model, @RequestParam String obABuscar, @RequestParam String buscarPor) {

		model.addAttribute("obABuscar", obABuscar);
		model.addAttribute("buscarPor", buscarPor);
		model.addAttribute("especies", espRep.findAll());
		return "mostrarEspecie";
	}

	@RequestMapping(value = "/aceptarEspecie")
	public String aceptarEspecie(Model model, @RequestParam String nComun, @RequestParam String nCient,
			@RequestParam String tipo, @RequestParam String areas) {

		Especie e = new Especie();
		e.setNComun(nComun);
		e.setNCient(nCient);
		e.setTipo(tipo);
		List<Area> areasAux = new ArrayList<Area>();
		Area areaAux = new Area();
		String[] areasAux2 = areas.split(",");
		for (int i = 0; i < areasAux2.length; i++) {
			areaAux = areasRep.findByNombre(areasAux2[i]);
			areasAux.add(areaAux);
		}
		e.setAreas(areasAux);
		espRep.save(e);
		String tipo2 = "Especie";
		model.addAttribute("tipo", tipo2);
		return "aceptarAnadir";
	}

	@RequestMapping(value = "/editarEspecie/{idEspecie}")
	public String editarEspecie(Model model, @PathVariable(value = "idEspecie") String idEspecie) {

		Especie e = espRep.findByIdEspecie(Long.parseLong(idEspecie));
		model.addAttribute("especie", e);
		return "editarEspecie";
	}

	@RequestMapping(value = "/aceptarEditarEspecie/{idEspecie}")
	public String aceptarEditarEspecie(Model model, @PathVariable(value = "idEspecie") String idEspecie,
			@RequestParam String nComun, @RequestParam String nCient, @RequestParam String tipo,
			@RequestParam String areas) {

		Especie e = espRep.findByIdEspecie(Long.parseLong(idEspecie));
		e.setNComun(nComun);
		e.setNCient(nCient);
		e.setTipo(tipo);
		List<Area> areasAux = new ArrayList<Area>();
		Area areaAux = new Area();
		String[] areasAux2 = areas.split(",");
		for (int i = 0; i < areasAux2.length; i++) {
			areaAux = areasRep.findByNombre(areasAux2[i]);
			areasAux.add(areaAux);
		}
		e.setAreas(areasAux);
		espRep.save(e);
		String tipo2 = "Especie";
		model.addAttribute("tipo", tipo2);
		return "aceptarAnadir";
	}

}
