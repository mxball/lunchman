package br.com.contractMan.daos;

import org.springframework.data.repository.CrudRepository;

import br.com.contractMan.models.Eventos;

public interface EventosDao extends CrudRepository<Eventos, Long>{

	Eventos findById(Long i);}
