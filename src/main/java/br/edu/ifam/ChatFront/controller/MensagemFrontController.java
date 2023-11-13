package br.edu.ifam.ChatFront.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.edu.ifam.ChatFront.Service.MensagemFrontService;
import br.edu.ifam.ChatFront.model.Mensagem;

public class MensagemFrontController {

	@Controller
	@RequestMapping("/mensagem-front")
	public class MensagemController {

	    private final MensagemFrontService mensagemService;

	    public MensagemController(MensagemFrontService mensagemService) {
	        this.mensagemService = mensagemService;
	    }

	    @GetMapping("/visualizar/{contatoId}")
	    public String visualizarMensagens(@PathVariable String contatoId, Model model) {
	        Mensagem[] mensagens = mensagemService.listarMensagensDoContato(contatoId);
	        model.addAttribute("mensagens", mensagens);
	        return "visualizarMensagens";
	    }

	    @GetMapping("/enviar/{destinatario}")
	    public String enviarMensagem(@PathVariable String destinatario, Model model) {
	        model.addAttribute("destinatario", destinatario);
	        model.addAttribute("mensagem", new Mensagem());
	        return "enviarMensagem";
	    }

	    @PostMapping("/enviar")
	    public String enviarMensagem(@ModelAttribute Mensagem mensagem) {
	        mensagemService.enviarMensagem(mensagem);
	        return "redirect:/mensagem-front/visualizar/" + mensagem.getDestinatario();
	    }
	}

}
