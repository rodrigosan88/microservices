package br.jus.cnj.pje.cep.repository;

import org.springframework.data.repository.CrudRepository;

import br.jus.cnj.pje.cep.model.Cep;

public interface CepRepository extends CrudRepository<Cep, Integer>{
	
	Cep findByNumeroCep(String cep);

}
