package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Repository.EspecieRepository;
import es.sd.PracticaSD.Especie;

@Controller
public class CatalogoController {
	
	
	@RequestMapping(value = "/")
	public String catalogo(Model model){
		
		return "catalogo";
	}
	
}
