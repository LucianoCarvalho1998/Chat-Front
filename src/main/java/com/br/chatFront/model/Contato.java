package com.br.chatFront.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Contato(
		String nome, 
		String email,
		String telefone,
		String bairro,
		String cidade,
		String estado
		)
{

}
