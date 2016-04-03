package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sd.PracticaSD.Especie;

public interface EspecieRepository extends JpaRepository<Especie,Long>{
	
	List<Especie> findAll();
	Especie findById(long id);

}
