package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sd.PracticaSD.Area;

public interface AreaRepository extends JpaRepository<Area,Long>{
	
	List<Area> findAll();
	Area findByName(String name);
	Area findById(long id);
	
}
