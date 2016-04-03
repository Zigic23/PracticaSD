package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sd.PracticaSD.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado,Long>{
	
	List<Empleado> findAll();
	Empleado findById(long idEmpleado);
}
