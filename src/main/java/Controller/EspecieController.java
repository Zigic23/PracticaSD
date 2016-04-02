package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Repository.EspecieRepository;

@Controller
public class EspecieController {

	@Autowired
	private EspecieRepository espRep;
	@Autowired
	private AreaRepository areasRep;
	
	@RequestMapping(value = "/buscarEspecie")
	public String buscarEspecie (Model model, String obABuscar, String buscarPor){
		
		model.addAttribute(obABuscar);
		model.addAttribute(buscarPor);
		model.addAttribute(espRep.findAll());
		return "mostrarEspecie";
	}
	
}
