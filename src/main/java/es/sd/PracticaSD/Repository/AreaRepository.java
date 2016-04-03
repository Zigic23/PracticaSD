package es.sd.PracticaSD.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.sd.PracticaSD.Models.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {

	List<Area> findAll();

	Area findByNombre(String nombre);

	Area findByIdArea(long idArea);

}
