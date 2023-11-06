package br.edu.ifam.ChatFront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifam.ChatFront.Service.ContatoFrontService;
import br.edu.ifam.ChatFront.model.Contato;


@Controller
public class ContatoFrontController {

	@Autowired
	ContatoFrontService contatoService;
	
	@GetMapping("/mostrarcontato")
	public String mostrarContato(Model model) {
		
		model.addAttribute("contatos", ContatoFrontService.getContato());
		return "listaContatos";
	}
	
	@GetMapping("/novoContato")
	public String novoContato(Contato contato) {
		return "novoContato";
	}

    @PostMapping("/inserircontato")
    public String addUser(@Validated Contato contato, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "novoContato";
        }

        ContatoFrontService.postContato(contato);
        return "redirect:/mostrarContatos";
    }
}
