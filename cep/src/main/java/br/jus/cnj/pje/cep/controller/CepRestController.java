package br.jus.cnj.pje.cep.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.jus.cnj.pje.cep.model.Cep;
import br.jus.cnj.pje.cep.service.CepService;

@RestController
public class CepRestController {

	@Autowired
	private CepService cepService;
	
	@PreAuthorize("#oauth2.hasRole('USER')")
	@RequestMapping(value = "/recuperar-cep/{cep}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public Map<String, String> getCep(@PathVariable("cep") String cep){
		Map<String, String> map = new LinkedHashMap<>();
		
		Cep cepEntity = cepService.findCep(String.valueOf(cep));
		
		if(cepEntity != null){
			map.put("municipio", cepEntity.getMunicipio().getMunicipio());
			map.put("bairro", cepEntity.getNomeBairro());
			map.put("logradouro", cepEntity.getNomeLogradouro());
			map.put("cep", cepEntity.getNumeroCep());
			map.put("numero", cepEntity.getNumeroEndereco());
		}
		
		return map;
	}
	
}
