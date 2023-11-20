package br.edu.ifam.ChatFront.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.edu.ifam.ChatFront.model.Mensagem;

@Service
public class MensagemFrontService {


	    private final String API_URL = "http://localhost:8080/mensagem";

	    public Mensagem[] listarMensagensDoContato(String contatoId) {
	        RestTemplate restTemplate = new RestTemplate();
	        return restTemplate.getForObject(API_URL + "/contato/" + contatoId, Mensagem[].class);
	    }

	    public void enviarMensagem(Mensagem mensagem) {
	        RestTemplate restTemplate = new RestTemplate();
	        restTemplate.postForObject(API_URL, mensagem, Mensagem.class);
	    }
	}

