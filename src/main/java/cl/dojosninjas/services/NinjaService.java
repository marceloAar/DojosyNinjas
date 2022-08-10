package cl.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.dojosninjas.models.Ninja;
import cl.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	@Autowired
	NinjaRepository ninjaRepo;
	
	public List<Ninja> todosLosNinjas(){
		return (List<Ninja>) ninjaRepo.findAll();
	}
	
	public void creaNinja(Ninja ninja) {	
		ninjaRepo.save(ninja);		
	}
	
	
	public Optional<Ninja> mostrarNinja(Long id) {
		return ninjaRepo.findById(id);
	}
}
