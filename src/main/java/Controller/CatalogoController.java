package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CatalogoController {

	@RequestMapping("/")
	public String tablon(Model model) {


		return "catalogo";
	}

}