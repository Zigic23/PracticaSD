package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EspeciesController {

	@RequestMapping("/especies")
	public String insertar(@RequestParam int buscarPor, Model model) {

		return "especies";
	}

	@RequestMapping("/especies")
	public String insertar(Model model) {

		return "especies";
	}
}
