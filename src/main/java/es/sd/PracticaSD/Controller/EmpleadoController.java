package es.sd.PracticaSD.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.sd.PracticaSD.Models.Empleado;
import es.sd.PracticaSD.Repository.EmpleadoRepository;

@Controller
public class EmpleadoController {

	@Autowired
	private EmpleadoRepository empRep;

	@RequestMapping(value = "/buscarEmpleado")
	public String buscarEmpleado(Model model, @RequestParam String obABuscar, @RequestParam String buscarPor) {
		model.addAttribute("obABuscar", obABuscar);
		model.addAttribute("buscarPor", buscarPor);
		if (buscarPor.equals("NyA")){
			String[] NyA = obABuscar.split(" ");
			if (NyA.length == 2){
				model.addAttribute("nombreEm", NyA[0]);
				model.addAttribute("apellidosEm", NyA[1]);
			} else if (NyA.length == 3){
				model.addAttribute("nombreEm", NyA[0]);
				model.addAttribute("apellidosEm", NyA[1] + ' ' + NyA[2]);
			}
		}
		model.addAttribute("empleados", empRep.findAll());
		return "mostrarPersonal";
	}

	@RequestMapping(value = "/aceptarEmpleado")
	public String aceptarEmpleado(Model model, @RequestParam String nombre, @RequestParam String apellidos,
			@RequestParam String correo, @RequestParam String fijo, @RequestParam String movil,
			@RequestParam String tipo) {
		Empleado e = new Empleado();
		e.setNombre(nombre);
		e.setApellidos(apellidos);
		e.setCorreo(correo);
		e.setTipo(tipo);
		e.setMovil(Integer.parseInt(movil));
		e.setFijo(Integer.parseInt(fijo));
		empRep.save(e);
		String tipo2 = "Empleado";
		model.addAttribute("tipo", tipo2);
		return "aceptarAnadir";
	}

	@RequestMapping(value = "/editarEmpleado/{numEmpleado}")
	public String editarEmpleado(Model model, @PathVariable(value = "numEmpleado") String numEmpleado) {

		Empleado e = empRep.findByIdEmpleado(Long.parseLong(numEmpleado));
		model.addAttribute("empleado", e);
		return "editarPersonal";
	}

	@RequestMapping(value = "/aceptarEditarEmpleado/{numEmpleado}")
	public String aceptarEditarEspecie(Model model, @PathVariable(value = "numEmpleado") String numEmpleado,
			@RequestParam String nombre, @RequestParam String apellidos, @RequestParam String correo,
			@RequestParam String fijo, @RequestParam String movil, @RequestParam String tipo) {

		Empleado e = empRep.findByIdEmpleado(Long.parseLong(numEmpleado));
		e.setNombre(nombre);
		e.setApellidos(apellidos);
		e.setTipo(tipo);
		e.setCorreo(correo);
		e.setMovil(Integer.parseInt(movil));
		e.setFijo(Integer.parseInt(fijo));
		empRep.save(e);
		String tipo2 = "Empleado";
		model.addAttribute("tipo", tipo2);
		return "aceptarAnadir";
	}
}
