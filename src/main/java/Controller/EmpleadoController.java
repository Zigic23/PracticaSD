package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Repository.EmpleadoRepository;
import es.sd.PracticaSD.Empleado;

@Controller
public class EmpleadoController {

	@Autowired
	private EmpleadoRepository empRep;
	
	@RequestMapping("/buscarEmpleado")
	public String buscarEmpleado (Model model, @RequestParam String obABuscar,@RequestParam String buscarPor){
		
		model.addAttribute("obABuscar", obABuscar);
		model.addAttribute("buscarPor", buscarPor);
		model.addAttribute("especies", empRep.findAll());
		return "mostrarPersonal";
	}
	
	@RequestMapping("/aceptarEmpleado")
	public String aceptarEmpleado (Model model, @RequestParam String nombre, @RequestParam String apellidos, @RequestParam String correo, @RequestParam String fijo, @RequestParam String movil, @RequestParam String tipo){
		Empleado e = new Empleado();
		e.setNombre(nombre);
		e.setApellidos(apellidos);
		e.setCorreo(correo);
		e.setTipo(tipo);
		e.setMovil(Integer.parseInt(movil));
		e.setMovil(Integer.parseInt(fijo));
		empRep.save(e);
		String tipo2 = "Empleado";
		model.addAttribute("tipo", tipo2);
		return "aceptarAñadir";
	}
	
	@RequestMapping("/editarEmpleado/{numEmpleado}")
	public String editarEmpleado (Model model, @PathVariable(value = "numEmpleado")String numEmpleado) {
		
		Empleado e = empRep.findById(Long.parseLong(numEmpleado));
		model.addAttribute("empleado", e);
		return "editarPersonal";
	}
	
	@RequestMapping("/aceptarEditarEmpleado/{numEmpleado}")
	public String aceptarEditarEspecie (Model model, @PathVariable (value = "numEmpleado")String numEmpleado, @RequestParam String nombre, @RequestParam String apellidos, @RequestParam String correo, @RequestParam String fijo, @RequestParam String movil, @RequestParam String tipo){
		
		Empleado e = empRep.findById(Long.parseLong(numEmpleado));
		e.setNombre(nombre);
		e.setApellidos(apellidos);
		e.setTipo(tipo);
		e.setCorreo(correo);
		e.setMovil(Integer.parseInt(movil));
		e.setTFijo(Integer.parseInt(fijo));
		empRep.save(e);
		String tipo2 = "Empleado";
		model.addAttribute("tipo", tipo2);
		return "aceptarAñadir";
	}
}
