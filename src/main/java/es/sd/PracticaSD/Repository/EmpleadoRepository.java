package es.sd.PracticaSD.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.sd.PracticaSD.Models.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

	List<Empleado> findAll();

	Empleado findByIdEmpleado(long idEmpleado);
}
