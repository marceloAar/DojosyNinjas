package cl.dojosninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cl.dojosninjas.models.Dojo;
import cl.dojosninjas.models.Ninja;
import cl.dojosninjas.services.DojoService;
import cl.dojosninjas.services.NinjaService;

@Controller
public class HomeController {

	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	
	@GetMapping("/dojos/new")
	public String nuevoDojo() {
		return "newDojo";
	}
	
	@PostMapping("/dojos/new")
	public String guardaDojo(@ModelAttribute Dojo dojo) {
		dojoService.creaDojo(dojo);
		return "redirect:/dojos/new";
	}
	
	@GetMapping("/ninjas/new")
	public String nuevoNinja(Model model) {
		model.addAttribute("dojos", dojoService.todosLosDojos());
		return "newNinja";
	}
	
	@PostMapping("/ninjas/new")
	public String guardaNinja(@ModelAttribute Ninja ninja) {
		ninjaService.creaNinja(ninja);
		return "redirect:/ninjas/new";
	}
	
	@GetMapping("/dojos/{id}")
	public String listaDojos(@PathVariable Long id, Model model) {
		model.addAttribute("dojos", dojoService.mostrarDojo(id));
		
		return "list";
	}
	
}