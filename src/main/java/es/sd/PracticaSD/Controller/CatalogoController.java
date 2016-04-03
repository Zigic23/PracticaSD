package es.sd.PracticaSD.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.sd.PracticaSD.Models.Area;
import es.sd.PracticaSD.Models.Empleado;
import es.sd.PracticaSD.Models.Especie;
import es.sd.PracticaSD.Repository.AreaRepository;
import es.sd.PracticaSD.Repository.EmpleadoRepository;
import es.sd.PracticaSD.Repository.EspecieRepository;

@Controller
public class CatalogoController {

	@Autowired
	private AreaRepository areaRep;

	@Autowired
	private EmpleadoRepository empRep;

	@Autowired
	private EspecieRepository espRep;

	@RequestMapping(value = "/")
	public String catalogo(Model model) {
		List<Especie> l = espRep.findAll();
		model.addAttribute("especies", l);
		List<Empleado> lemp = empRep.findAll();
		model.addAttribute("empleados", lemp);
		List<Area> larea = areaRep.findAll();
		model.addAttribute("areas", larea);
		return "index";
	}

}
