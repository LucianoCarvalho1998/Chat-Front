package br.edu.ifam.ChatFront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifam.ChatFront.Service.ContatoFrontService;
import br.edu.ifam.ChatFront.model.Contato;


@RequestMapping("/contato")
@Controller
public class ContatoFrontController {
	
	@Autowired
	ContatoFrontService contatoFrontService;
	@GetMapping
	public String mostraContatos(Model model) {
		
		model.addAttribute("contatos", contatoFrontService.getContatos());
		return "listaContatos";
		
	}
	
	@GetMapping("/novo")
	public String novoContato(Contato contato) {
		return "novoContato";
	}

    @PostMapping
	@PutMapping("/alterar/{id}")
	public String alterarContato(@PathVariable Long id,
			@Validated Contato contato, BindingResult result, Model model) {

		model.addAttribute("contato", contatoFrontService.getContato(id));
		return "alterarContato";
	}

	@PostMapping
    public String inserirContato(@Validated Contato contato, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "novoContato";
        }
        
        contatoFrontService.postContato(contato);
        return "redirect:/contato";
    }
    
    @PutMapping("/{id}")
    public String alterarContato(@PathVariable long id,@Validated Contato contato, BindingResult result, Model model)
    {
    	contatoFrontService.putContato(id, contato);
    	return "redirect:/contato";
    }

    @DeleteMapping("/{id}")
    public String excluirContato(@PathVariable long id) {
    	System.out.println("Excluindo: "+Long.toString(id));
    	return "redirect:/contato";
    }
    
}
