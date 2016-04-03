package Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Repository.AreaRepository;
import es.sd.PracticaSD.Area;
import es.sd.PracticaSD.Especie;

@Controller
public class AreaController {

	@Autowired
	private AreaRepository areaRep;
	
	@RequestMapping("/aceptarArea")
	public String aceptarArea (Model model, @RequestParam String nombre, @RequestParam String extension){
		
		Area a = new Area();
		a.setNombre(nombre);
		a.setExtension(extension);
		a.setEspecies(new ArrayList<Especie>());
		areaRep.save(a);
		String tipo = "Area";
		model.addAttribute("tipo", tipo);
		return "aceptarAnadir";
	}
	
	@RequestMapping("/mostrarArea")
	public String mostrarArea (Model model){
		model.addAttribute("areas", areaRep.findAll());
		return "mostrarArea";
	}
	
	@RequestMapping("/editarArea/{numArea}")
	public String editarArea (Model model, @PathVariable(value = "numArea")String numArea, @RequestParam String nombre, @RequestParam String extension){
		Area a = areaRep.findById(Long.parseLong(numArea));
		model.addAttribute("area",a);
		return "editarArea";
	}
	
	@RequestMapping("/aceptarEditarArea/{numArea}")
	public String aceptarEditarArea (Model model, @PathVariable(value = "numArea")String numArea, @RequestParam String nombre, @RequestParam String extension){
		Area a = areaRep.findById(Long.parseLong(numArea));
		a.setNombre(nombre);
		a.setExtension(extension);
		String tipo = "Area";
		model.addAttribute("tipo", tipo);
		return "aceptarAnadir";
	}
	
}
