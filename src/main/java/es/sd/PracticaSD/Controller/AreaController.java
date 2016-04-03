package es.sd.PracticaSD.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.sd.PracticaSD.Models.Area;
import es.sd.PracticaSD.Models.Especie;
import es.sd.PracticaSD.Repository.AreaRepository;

@Controller
public class AreaController {

	@Autowired
	private AreaRepository areaRep;

	@RequestMapping(value = "/aceptarArea")
	public String aceptarArea(Model model, @RequestParam String nombre, @RequestParam String extension) {

		Area a = new Area();
		a.setNombre(nombre);
		a.setExtension(extension);
		a.setEspecies(new ArrayList<Especie>());
		areaRep.save(a);
		String tipo = "Area";
		model.addAttribute("tipo", tipo);
		return "aceptarAnadir";
	}

	@RequestMapping(value = "/mostrarArea")
	public String mostrarArea(Model model) {
		model.addAttribute("areas", areaRep.findAll());
		return "mostrarArea";
	}

	@RequestMapping(value = "/editarArea/{numArea}")
	public String editarArea(Model model, @PathVariable(value = "numArea") String numArea){
		Area a = areaRep.findByIdArea(Long.parseLong(numArea));
		model.addAttribute("area", a);
		return "editarArea";
	}

	@RequestMapping(value = "/aceptarEditarArea/{areaId}")
	public String aceptarEditarArea(Model model, @PathVariable(value = "areaId") String areaId,
			@RequestParam String nombre, @RequestParam String extension) {
		Area a = areaRep.findByIdArea(Long.parseLong(areaId));
		a.setNombre(nombre);
		a.setExtension(extension);
		areaRep.save(a);
		String tipo = "Area";
		model.addAttribute("tipo", tipo);
		return "aceptarAnadir";
	}

}
