package cl.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.dojosninjas.models.Dojo;
import cl.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired
	DojoRepository dojoRepo;
	
	public List<Dojo> todosLosDojos(){
		return (List<Dojo>) dojoRepo.findAll();
	}
	
	public void creaDojo(Dojo dojo) {	
		dojoRepo.save(dojo);		
	}
	
	public Dojo mostrarDojo(Long id) {
        Optional<Dojo> undojo = dojoRepo.findById(id);
        if(undojo.isPresent()) {
            return undojo.get();
        } else {
            return null;
        }
    }
	
}
