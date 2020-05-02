package br.usjt.previsaoTempo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.previsaoTempo.model.Tempo;
import br.usjt.previsaoTempo.repository.TempoRepository; 
 
@Controller 

public class PrevisaoTempoController {  
	//a injeção de dependência ocorre aqui  
	@Autowired  
	private TempoRepository tempoRepo;
	
	
	@GetMapping ("/tempo") 
	public ModelAndView listarTempo () {  
		//passe o nome da página ao construtor  
		ModelAndView mv = new ModelAndView ("lista_tempo"); 
		
		//Busque a coleção com o repositório  
		List <Tempo> tempos = tempoRepo.findAll(); 
		
		//adicione a coleção ao objeto ModelAndView 
		mv.addObject("tempos", tempos);     
		//devolva o ModelAndView  
		
		//para modelar o formulário 
		mv.addObject(new Tempo()); 
		
		return mv; 
		
	} 
	
	
	@PostMapping("/alunos") 
	public String salvar (Tempo tempo) {  
		tempoRepo.save(tempo);  
		return "redirect:/tempo"; 
	} 
		 
}
	 