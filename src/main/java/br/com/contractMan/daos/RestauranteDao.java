package br.com.contractMan.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.contractMan.models.Restaurantes;

public interface RestauranteDao extends CrudRepository<Restaurantes, Long>{

	List<Restaurantes> findByTipo(String tipo);
	
}
