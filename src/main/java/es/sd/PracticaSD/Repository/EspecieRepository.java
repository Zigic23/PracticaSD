package es.sd.PracticaSD.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.sd.PracticaSD.Models.Especie;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Long> {

	List<Especie> findAll();

	Especie findByIdEspecie(long idEspecie);

}
