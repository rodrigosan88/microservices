package br.jus.cnj.pje.cep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jus.cnj.pje.cep.model.Cep;
import br.jus.cnj.pje.cep.repository.CepRepository;

@Service
public class CepServiceImpl implements CepService{

	@Autowired
	private CepRepository repository;
	
	@Override
	public Cep findCep(String cep) {
		return repository.findByNumeroCep(cep);
	}
	
	
}
